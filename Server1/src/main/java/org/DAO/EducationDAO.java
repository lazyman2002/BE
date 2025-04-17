package org.DAO;

import org.model.Educations;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EducationDAO {
    public ArrayList<Educations> readEducationList(ServerClient.CVFullInfo request, Connection connection) throws Exception {
        System.out.println("readEducationList");

        String query = "SELECT * FROM `Educations` WHERE `Educations`.`CVID` = ?;";
        ArrayList<Educations> educationList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getCVID() == 0) throw new Exception("CVID is missing");
            preparedStatement.setInt(1, request.getCVID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Educations education = new Educations();
                education.setCVID(request.getCVID());

                Integer educationID = resultSet.getInt("educationID");
                if (educationID <= 0) throw new Exception("educationID returned is invalid");
                education.setEducationID(educationID);

                String degree = resultSet.getString("degree");
                education.setDegree(degree != null ? degree : "");

                String fieldOfStudy = resultSet.getString("EduFields");
                education.setEduFields(fieldOfStudy != null ? fieldOfStudy : "");

                String institution = resultSet.getString("EduDescription");
                education.setEduDescription(institution != null ? institution : "");

                Date startDate = resultSet.getDate("startDate");
                education.setStartDate(startDate);

                Date endDate = resultSet.getDate("endDate");
                education.setEndDate(endDate);

                educationList.add(education);
            }
            return educationList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Educations readEducation(ServerClient.EducationFullInfo request, Connection connection) throws Exception {
        System.out.println("readEducation");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Educations` WHERE `Educations`.`educationID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, request.getEducationID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Educations educations = new Educations();
                educations.setEducationID(request.getEducationID());
                Integer CVID = resultSet.getInt("CVID");
                if (CVID <= 0) throw new Exception("Invalid CVID returned");
                educations.setCVID(CVID);

                String degree = resultSet.getString("degree");
                degree = (degree != null) ? degree : "";
                educations.setDegree(degree);

                String EduFields = resultSet.getString("EduFields");
                EduFields = (EduFields != null) ? EduFields : "";
                educations.setEduFields(EduFields);

                String EduDescription = resultSet.getString("EduDescription");
                EduDescription = (EduDescription != null) ? EduDescription : "";
                educations.setEduDescription(EduDescription);

                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                educations.setStartDate(startDate);
                educations.setEndDate(endDate);
                return educations;
            } else {
                throw new Exception("Education not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Educations registerEducation(ServerClient.EducationFullInfo request, Connection connection) throws Exception {
        System.out.println("registerEducation");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Educations`(`CVID`, `degree`, `EduFields`, `EduDescription`, `startDate`, `endDate`) VALUES (?, ?, ?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getCVID() == 0) {
                throw new Exception("CVID không hợp lệ");
            }

            String degree = request.getDegree();
            if (degree.isEmpty()) {
                throw new Exception("Degree không được để trống");
            }

            String fieldOfStudy = request.getEduFields();
            if (fieldOfStudy.isEmpty()) {
                throw new Exception("Field of study không được để trống");
            }

            String institution = request.getEduDescription();
            if (institution.isEmpty()) {
                throw new Exception("EduDescription không được để trống");
            }

            com.google.protobuf.Timestamp startTimestamp = request.getStartDate();
            com.google.protobuf.Timestamp endTimestamp = request.getEndDate();
            if (!request.hasStartDate() || !request.hasEndDate()) {
                throw new Exception("StartDate hoặc EndDate không hợp lệ");
            }

            Date startDate = new Date(startTimestamp.getSeconds() * 1000);
            Date endDate = new Date(endTimestamp.getSeconds() * 1000);

            preparedStatement.setInt(1, request.getCVID());
            preparedStatement.setString(2, degree);
            preparedStatement.setString(3, fieldOfStudy);
            preparedStatement.setString(4, institution);
            preparedStatement.setDate(5, startDate);
            preparedStatement.setDate(6, endDate);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer educationID;
                if (resultSet.next()) {
                    educationID = resultSet.getInt(1);
                    return this.readEducation(ServerClient.EducationFullInfo
                                    .newBuilder()
                                    .setEducationID(educationID)
                                    .build(),
                            connection);
                }
            } else {
                throw new Exception("Không thêm education thành công");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Lỗi code");
    }

    public Educations updateEducation(ServerClient.EducationFullInfo request, Connection connection) throws Exception {
        System.out.println("updateEducation");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Educations` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if (!request.getDegree().isEmpty()) {
                sb.append("`Educations`.`degree` = ?, ");
                parameters.add(request.getDegree());
            }

            if (!request.getEduFields().isEmpty()) {
                sb.append("`Educations`.`EduFields` = ?, ");
                parameters.add(request.getEduFields());
            }

            if (!request.getEduDescription().isEmpty()) {
                sb.append("`Educations`.`EduDescription` = ?, ");
                parameters.add(request.getEduDescription());
            }

            if (request.hasStartDate()) {
                Date startDate = new Date(request.getStartDate().getSeconds() * 1000);
                sb.append("`Educations`.`startDate` = ?, ");
                parameters.add(startDate);
            }

            if (request.hasEndDate()) {
                Date endDate = new Date(request.getEndDate().getSeconds() * 1000);
                sb.append("`Educations`.`endDate` = ?, ");
                parameters.add(endDate);
            }

            if (request.getCVID() != 0) {
                sb.append("`Educations`.`CVID` = ?, ");
                parameters.add(request.getCVID());
            }

            if (request.getEducationID() == 0) throw new Exception("Không có educationID");

            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `Educations`.`educationID` = ?;");
            parameters.add(request.getEducationID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readEducation(ServerClient.EducationFullInfo.newBuilder()
                                .setEducationID(request.getEducationID())
                                .build(),
                        connection);
            }
            throw new Exception("Không update thành công");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteEducation(ServerClient.EducationFullInfo request, Connection connection) throws Exception {
        System.out.println("deleteEducation");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Educations` WHERE `Educations`.`educationID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (request.getEducationID() == 0) throw new Exception("Không có educationID");

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getEducationID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("educationID không có trong CSDL");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public HashSet<Integer> readEducationIDs(Integer CVID, Connection connection) throws Exception {
        System.out.println("readEducationIDs");

        if(CVID <=0) throw new Exception("Kết quả trả về không hợp lệ");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `educationID` FROM `Educations` WHERE `Educations`.`CVID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashSet<Integer> educationIDs = new HashSet<>();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, CVID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer educationID = resultSet.getInt("educationID");
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
