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

public class RecruiterDAO {
    public Recruiters createRecruiter(Users users, ServerClient.RecruiterFullInfo request, Connection connection) throws Exception {
        System.out.println("createRecruiter");

        StringBuilder sb= new StringBuilder();
        sb.append("INSERT INTO `Recruiters`(`userID`, `companyID`, `roleID`, `departmentName`) VALUES (?, ? , ?, ?)");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Recruiters recruiters = new Recruiters(users);
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, users.getUserID());

            if(users.getUserID() == 0) throw new Exception("Copany không tồn tại");
            recruiters.setCompanyID(request.getCompanyID());
            preparedStatement.setInt(2, request.getCompanyID());

            if(request.getRoleID() == 0) throw  new Exception("Role không tồn tại");
            recruiters.setRoleID(request.getRoleID());
            preparedStatement.setInt(3, request.getRoleID());

            if(!request.getDepartmentName().isEmpty() && !request.getDepartmentName().isEmpty()){
                recruiters.setDepartmentName(request.getDepartmentName());
                preparedStatement.setString(4, request.getDepartmentName());
            }
            else preparedStatement.setString(4, "");

            int rowsInserted = preparedStatement.executeUpdate();

            if(rowsInserted == 1){
                return recruiters;
            }
            else throw new Exception("Recruiter không thêm thành công ");
        }
        finally {
            if(resultSet != null)    resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }


    }

    public Recruiters readRecruiter(ServerClient.UserMetaInfo request, Connection connection) throws SQLException {
        System.out.println("readRecruiter");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Recruiters` WHERE 1 = 1 ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Recruiters recruiters = null;
        UserDAO userDAO = new UserDAO();

        try {
            if(request.getUserID() == 0)    throw new RuntimeException("UserID không hợp lệ");
            Users users = userDAO.readUser(request, connection);
            recruiters = new Recruiters(users);

            sb.append(" AND `Recruiters`.`userID` = ?;");
            String sql = sb.toString();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getUserID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.isLast()) {
                    Integer companyID = resultSet.getInt("companyID");
                    Integer roleID = resultSet.getInt("roleID");
                    String departmentName = resultSet.getString("departmentName");

                    recruiters.setCompanyID(companyID);
                    recruiters.setRoleID(roleID);
                    recruiters.setDepartmentName(departmentName);
                    return recruiters;
                } else {
                    throw new IllegalStateException("Query nhiều kết quả");
                }
            }
            else throw new RuntimeException("Không query được");
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Recruiters updateRecruiter(ServerClient.RecruiterFullInfo request, Connection connection) throws SQLException {
        System.out.println("updateRecruiter");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Recruiters` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if(request.getCompanyID() != 0){
                sb.append("`Recruiters`.`companyID` = ?, ");
                parameters.add(request.getCompanyID());
            }
            if(request.getRoleID() != 0){
                sb.append("`Recruiters`.`roleID` = ?, ");
                parameters.add(request.getRoleID());
            }
            if(request.getDepartmentName() != null && !request.getDepartmentName().isEmpty() && !request.getDepartmentName().isEmpty()){
                sb.append("`Recruiters`.`departmentName` = ?, ");
                parameters.add(request.getDepartmentName());
            }
            sb.setLength(sb.length()-2);
            if(request.getUser().getUserID() != 0){
                sb.append(" WHERE `Recruiters`.`userID` = ?;");
                parameters.add(request.getUser().getUserID());
            }
            else {
                throw new RuntimeException("Không có UserID");
            }

            String sql =sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated > 0){
                RecruiterDAO recruiterDAO = new RecruiterDAO();
                return recruiterDAO.readRecruiter(Converter.userFullToMeta(request.getUser()), connection);
            }
            throw new RuntimeException("Không update thành công");
        }finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public ArrayList<Recruiters> readRecruiterList(Connection connection) throws SQLException {
        System.out.println("readRecruiterLost");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Recruiters`;");
        ArrayList<Recruiters>   arrayList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            UserDAO userDAO = new UserDAO();
            preparedStatement = connection.prepareStatement(sb.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer userID = resultSet.getInt("userID");
                Recruiters recruiters = new Recruiters(userDAO.readUser(ServerClient.UserMetaInfo.newBuilder().setUserID(userID).build(), connection));

                Integer companyID = resultSet.getInt("companyID");
                recruiters.setCompanyID(companyID);

                Integer roleID = resultSet.getInt("roleID");
                recruiters.setRoleID(roleID);

                String departmentName = resultSet.getString("departmentName");
                recruiters.setDepartmentName(departmentName != null ? departmentName : "");

                arrayList.add(recruiters);
            }
            return  arrayList;
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }
}
