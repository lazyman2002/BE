package org.DAO;

import org.model.WorkExperiences;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WorkExperienceDAO {
    public ArrayList<WorkExperiences> readWorkExperienceList(ServerClient.CVMetaInfo request, Connection connection) throws Exception {
        System.out.println("readWorkExperienceList");

        String query = "SELECT * FROM `WorkExperiences` WHERE `WorkExperiences`.`CVID` = ?;";
        ArrayList<WorkExperiences> workExperienceList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            if (request.getCVID() == 0) throw new Exception("CVID is missing");
            preparedStatement.setInt(1, request.getCVID());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                WorkExperiences workExperience = new WorkExperiences();
                workExperience.setCVID(request.getCVID());

                Integer workExperienceID = resultSet.getInt("workExperienceID");
                if (workExperienceID <= 0) throw new Exception("WorkExperienceID is invalid");
                workExperience.setWorkExperienceID(workExperienceID);

                String jobTitle = resultSet.getString("jobTitle");
                workExperience.setJobTitle(jobTitle != null ? jobTitle : "");

                String companyName = resultSet.getString("companyName");
                workExperience.setCompanyName(companyName != null ? companyName : "");

                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");
                workExperience.setStartDate(startDate);
                workExperience.setEndDate(endDate);

                workExperienceList.add(workExperience);
            }
            return workExperienceList;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public WorkExperiences readWorkExperience(ServerClient.WorkExperienceFullInfo request, Connection connection) throws Exception {
        System.out.println("readWorkExperience");

        String query = "SELECT * FROM `WorkExperiences` WHERE `WorkExperiences`.`workExperienceID` = ?;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, request.getWorkExperienceID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer CVID = resultSet.getInt("CVID");
                if (CVID <= 0) throw new Exception("Invalid CVID");

                String jobTitle = resultSet.getString("jobTitle");
                jobTitle = (jobTitle != null) ? jobTitle : "";

                String jobDescription = resultSet.getString("jobDescription");
                jobDescription = (jobDescription != null) ? jobDescription : "";

                String companyName = resultSet.getString("companyName");
                companyName = (companyName != null) ? companyName : "";

                Date startDate = resultSet.getDate("startDate");
                Date endDate = resultSet.getDate("endDate");

                return new WorkExperiences(
                        CVID,
                        jobTitle,
                        startDate,
                        endDate,
                        jobDescription,
                        request.getWorkExperienceID(),
                        companyName
                );
            } else {
                throw new Exception("WorkExperience not found");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public WorkExperiences registerWorkExperience(ServerClient.WorkExperienceFullInfo request, Connection connection) throws Exception {
        System.out.println("registerWorkExperience");

        String query = "INSERT INTO `WorkExperiences`(`CVID`, `jobTitle`, `jobDescription`, `startDate`, `endDate`, `companyName`) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getCVID() == 0) {
                throw new Exception("Invalid CVID");
            }

            String jobTitle = request.getJobTitle();
            if (jobTitle == null || jobTitle.isEmpty() || jobTitle.isEmpty()) {
                throw new Exception("Job title cannot be empty");
            }

            String company = request.getCompanyName();
            if (company == null || company.isEmpty() || company.isEmpty()) {
                throw new Exception("Company cannot be empty");
            }

            String jobDescription = request.getJobDescription();
            if (jobDescription == null || jobDescription.isEmpty() || jobDescription.isEmpty()) {
                throw new Exception("Job Description cannot be empty");
            }

            com.google.protobuf.Timestamp startDateTimestamp = request.getStartDate();
            com.google.protobuf.Timestamp endDateTimestamp = request.getEndDate();
            if (!request.hasStartDate() || !request.hasEndDate()) {
                throw new Exception("Start date and end date must be valid");
            }
            java.sql.Date startDate = new java.sql.Date(startDateTimestamp.getSeconds() * 1000);
            java.sql.Date endDate = new java.sql.Date(endDateTimestamp.getSeconds() * 1000);

            preparedStatement.setInt(1, request.getCVID());
            preparedStatement.setString(2, jobTitle);
            preparedStatement.setString(3, jobDescription);
            preparedStatement.setDate(4, startDate);
            preparedStatement.setDate(5, endDate);
            preparedStatement.setString(6, company);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                Integer workExperienceID;
                if (resultSet.next()) {
                    workExperienceID = resultSet.getInt(1);
                    return this.readWorkExperience(ServerClient.WorkExperienceFullInfo
                                    .newBuilder()
                                    .setWorkExperienceID(workExperienceID)
                                    .build(),
                            connection);
                }
            } else {
                throw new Exception("Failed to add work experience");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Unexpected error occurred");
    }

    public WorkExperiences updateWorkExperience(ServerClient.WorkExperienceFullInfo request, Connection connection) throws Exception {
        System.out.println("updateWorkExperience");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `WorkExperiences` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if (request.getJobTitle() != null && !request.getJobTitle().isEmpty() && !request.getJobTitle().isEmpty()) {
                sb.append("`WorkExperiences`.`jobTitle` = ?, ");
                parameters.add(request.getJobTitle());
            }

            if (request.getCompanyName() != null && !request.getCompanyName().isEmpty() && !request.getCompanyName().isEmpty()) {
                sb.append("`WorkExperiences`.`companyName` = ?, ");
                parameters.add(request.getCompanyName());
            }

            if (request.getJobDescription() != null && !request.getJobDescription().isEmpty() && !request.getJobDescription().isEmpty()) {
                sb.append("`WorkExperiences`.`jobDescription` = ?, ");
                parameters.add(request.getCompanyName());
            }

            if (request.hasStartDate()) {
                java.sql.Date startDate = new java.sql.Date(request.getStartDate().getSeconds() * 1000);
                sb.append("`WorkExperiences`.`startDate` = ?, ");
                parameters.add(startDate);
            }

            if (request.hasEndDate()) {
                java.sql.Date endDate = new java.sql.Date(request.getEndDate().getSeconds() * 1000);
                sb.append("`WorkExperiences`.`endDate` = ?, ");
                parameters.add(endDate);
            }

            if (request.getWorkExperienceID() == 0) throw new Exception("Missing workExperienceID");

            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `WorkExperiences`.`workExperienceID` = ?;");
            parameters.add(request.getWorkExperienceID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readWorkExperience(ServerClient.WorkExperienceFullInfo.newBuilder()
                                .setWorkExperienceID(request.getWorkExperienceID())
                                .build(),
                        connection);
            }
            throw new Exception("Update failed");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteWorkExperience(ServerClient.WorkExperienceFullInfo request, Connection connection) throws Exception {
        System.out.println("deleteWorkExperience");

        String query = "DELETE FROM `WorkExperiences` WHERE `WorkExperiences`.`workExperienceID` = ?;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if (request.getWorkExperienceID() == 0) throw new Exception("Missing workExperienceID");

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, request.getWorkExperienceID());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
            throw new Exception("WorkExperienceID not found in the database");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public HashSet<Integer> readWorkExperienceIDs(Integer CVID, Connection connection) throws Exception {
        System.out.println("readWorkExperienceIDs");

        if(CVID <=0) throw new Exception("Kết quả trả về không hợp lệ");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `workExperienceID` FROM `WorkExperiences` WHERE `WorkExperiences`.`CVID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashSet<Integer> educationIDs = new HashSet<>();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, CVID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer educationID = resultSet.getInt("workExperienceID");
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

