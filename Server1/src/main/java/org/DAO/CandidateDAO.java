package org.DAO;

import org.controller.Converter;
import org.model.Candidates;
import org.model.Gender;
import org.model.Recruiters;
import org.model.Users;
import proto.ServerClient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    public Candidates createCandidates(Users users, ServerClient.CandidateFullInfo request, Connection connection) throws SQLException {
        System.out.println("createCandidates");

        System.out.println(request);
        StringBuilder sb= new StringBuilder();
        sb.append("INSERT INTO `Candidates`(`userID`, `birthDate`, `gender`) VALUES (?, ? , ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Candidates candidates = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, users.getUserID());

            Timestamp timestamp = Converter.protoToTimeStamp(request.getBirthDate());

            preparedStatement.setDate(2, new Date(timestamp.getTime()));

            Gender gender = Gender.fromProto(request.getGender());
            preparedStatement.setString(3, gender.getDisplayName().toUpperCase());

            int rowsInserted = preparedStatement.executeUpdate();

            if(rowsInserted == 1){
                candidates = new Candidates(users);
                candidates.setBirthDate(new Date(timestamp.getTime()));
                candidates.setGender(gender);
                return candidates;
            }
        }finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
        return null;
    }

    public Candidates readCandidates(ServerClient.UserMetaInfo request, Connection connection) throws SQLException, RuntimeException {
        System.out.println("readCandidates");

        StringBuilder sb= new StringBuilder();
        sb.append("SELECT * FROM `Candidates` WHERE 1 = 1");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Candidates candidates = null;
        UserDAO userDAO = new UserDAO();

        try {
            if (request.getUserID() == 0) throw new RuntimeException("UserID không hợp lệ");
            Users users = userDAO.readUser(request, connection);
            candidates = new Candidates(users);

            sb.append(" AND `Candidates`.`userID` = ?;");
            String sql = sb.toString();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getUserID());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.isLast()) {
                    Date birthDate = resultSet.getDate("birthDate");
                    Gender gender = Gender.valueOf(resultSet.getString("gender"));
                    candidates.setGender(gender);
                    candidates.setBirthDate(birthDate);
                    return candidates;
                } else {
                    throw new IllegalStateException("Query nhiều kết quả");
                }
            }
            else throw new RuntimeException("Không query được");
        } finally {
            if(resultSet!= null)    resultSet.close();
            if(preparedStatement!= null)    preparedStatement.close();
        }
    }

    public Candidates updateCandidates(ServerClient.CandidateFullInfo request, Connection connection) throws SQLException {
        System.out.println("updateCandidates");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Candidates` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if(request.hasBirthDate()){
                Timestamp timestamp = Converter.protoToTimeStamp(request.getBirthDate());
                sb.append("`Candidates`.`birthDate` = ?, ");

            }

            sb.append("`Candidates`.`gender` = ?, ");
            Gender gender = Gender.fromProto(request.getGender());
            parameters.add(gender.getDisplayName().toUpperCase());

            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Candidates`.`userID` = ?");
            parameters.add(request.getUser().getUserID());

            String sql =sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated >0 ){
                CandidateDAO candidateDAO = new CandidateDAO();
                return candidateDAO.readCandidates(Converter.userFullToMeta(request.getUser()), connection);
            }
            throw new RuntimeException("Không update thành công");
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public ArrayList<Candidates> readCandidateList(Connection connection) throws SQLException {
        System.out.println("readCandidateList");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Candidates`;");
        ArrayList<Candidates>   arrayList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            UserDAO userDAO = new UserDAO();
            preparedStatement = connection.prepareStatement(sb.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer userID = resultSet.getInt("userID");
                Candidates candidates = new Candidates(userDAO.readUser(ServerClient.UserMetaInfo.newBuilder().setUserID(userID).build(), connection));
                Date birthDate = resultSet.getDate("birthDate");
                Gender gender = Gender.valueOf(resultSet.getString("gender"));
                candidates.setGender(gender);
                candidates.setBirthDate(birthDate);
                arrayList.add(candidates);
            }
            return arrayList;
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }
}
