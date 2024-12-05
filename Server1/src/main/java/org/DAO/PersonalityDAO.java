package org.DAO;

import org.model.Personalities;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PersonalityDAO {
    public ArrayList<Personalities> readPersonalityList(ServerClient.CVMetaInfo request, Connection connection) throws Exception {
        System.out.println("readPersonalityList");

        String query = "SELECT * FROM `Personalities` WHERE `Personalities`.`CVID` = ?;";
        ArrayList<Personalities> personalityList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getCVID() == 0) throw new Exception("CVID is missing");
            preparedStatement.setInt(1, request.getCVID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Personalities personality = new Personalities();
                personality.setCVID(request.getCVID());

                Integer personalityID = resultSet.getInt("personalityID");
                if(personalityID <= 0) throw new Exception("PersonalityID is invalid");
                personality.setPersonalityID(personalityID);

                String personalityTitle = resultSet.getString("personalityTitle");
                personality.setPersonalityTitle(personalityTitle != null ? personalityTitle : "");

                String detail = resultSet.getString("detail");
                personality.setDetail(detail != null ? detail : "");

                personalityList.add(personality);
            }
            return personalityList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Personalities readPersonality(ServerClient.PersonalityFullInfo request, Connection connection) throws Exception {
        System.out.println("readPersonality");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Personalities` WHERE `Personalities`.`personalityID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getPersonalityID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Integer CVID = resultSet.getInt("CVID");
                if (CVID <= 0) throw new Exception("Kết quả trả về không hợp lệ");

                String personalityTitle = resultSet.getString("personalityTitle");
                personalityTitle = (personalityTitle != null) ? personalityTitle : "";

                String detail = resultSet.getString("detail");
                detail = (detail != null) ? detail : "";

                return new Personalities(
                        CVID,
                        personalityTitle,
                        detail,
                        resultSet.getInt("personalityID")
                );
            } else {
                throw new Exception("Personality not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Personalities registerPersonality(ServerClient.PersonalityFullInfo request, Connection connection) throws Exception {
        System.out.println("registerPersonality");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Personalities`(`CVID`, `personalityTitle`, `detail`) VALUES (?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getCVID() == 0) {
                throw new Exception("CVID không hợp lệ");
            }

            String personalityTitle = request.getPersonalityTitle();
            if (personalityTitle == null || personalityTitle.isEmpty() || personalityTitle.isBlank()) {
                throw new Exception("Tiêu đề tính cách không được để trống");
            }

            String detail = request.getDescription();
            if (detail == null || detail.isEmpty() || detail.isBlank()) {
                throw new Exception("Chi tiết tính cách không được để trống");
            }

            preparedStatement.setInt(1, request.getCVID());
            preparedStatement.setString(2, personalityTitle);
            preparedStatement.setString(3, detail);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer personalityID;
                if (resultSet.next()) {
                    personalityID = resultSet.getInt(1);
                    return this.readPersonality(ServerClient.PersonalityFullInfo
                                    .newBuilder()
                                    .setPersonalityID(personalityID)
                                    .build(),
                            connection);
                }
            } else {
                throw new Exception("Không thêm tính cách thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Lỗi code");
    }

    public Personalities updatePersonality(ServerClient.PersonalityFullInfo request, Connection connection) throws Exception {
        System.out.println("updatePersonality");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Personalities` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            // Check and append fields for update
            if (request.getPersonalityTitle() != null && !request.getPersonalityTitle().isBlank() && !request.getPersonalityTitle().isEmpty()) {
                sb.append("`Personalities`.`personalityTitle` = ?, ");
                parameters.add(request.getPersonalityTitle());
            }

            if (request.getDescription() != null && !request.getDescription().isBlank() && !request.getDescription().isEmpty()) {
                sb.append("`Personalities`.`detail` = ?, ");
                parameters.add(request.getDescription());
            }

            if (request.getCVID() != 0) {
                sb.append("`Personalities`.`CVID` = ?, ");
                parameters.add(request.getCVID());
            }

            if (request.getPersonalityID() == 0) throw new Exception("Không có personalityID");

            sb.setLength(sb.length() - 2); // Remove the last comma
            sb.append(" WHERE `Personalities`.`personalityID` = ?;");
            parameters.add(request.getPersonalityID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readPersonality(ServerClient.PersonalityFullInfo.newBuilder()
                                .setPersonalityID(request.getPersonalityID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deletePersonality(ServerClient.PersonalityFullInfo request, Connection connection) throws Exception {
        System.out.println("deletePersonality");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Personalities` WHERE `Personalities`.`personalityID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (request.getPersonalityID() == 0) throw new Exception("Không có personalityID");

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getPersonalityID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("personalityID không có trong CSDL");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public HashSet<Integer> readPersonalityIDs(Integer CVID, Connection connection) throws Exception {
        System.out.println("readPersonalityIDs");

        if(CVID <=0) throw new Exception("Kết quả trả về không hợp lệ");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `personalityID` FROM `Personalities` WHERE `Personalities`.`CVID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashSet<Integer> educationIDs = new HashSet<>();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, CVID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer educationID = resultSet.getInt("personalityID");
                if(educationID <=0) throw new Exception("Kết quả trả về không hợp lệ");
                educationIDs.add(educationID);
            }
            return educationIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }

    }
}
