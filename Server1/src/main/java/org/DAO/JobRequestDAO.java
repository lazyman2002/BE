package org.DAO;

import org.controller.Converter;
import org.model.JobLevel;
import org.model.JobRequests;
import org.model.JobType;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class JobRequestDAO {
    public JobRequests readJobRequest(ServerClient.JobRequestMetaInfo request, Connection connection) throws Exception {
        System.out.println("readJobRequest");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `JobRequests` WHERE `JobRequests`.`jobID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            if(request.getJobID() == 0) throw new Exception("JobReqID không hợp lệ;");
            preparedStatement.setInt(1, request.getJobID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer jobID = resultSet.getInt("jobID");
                Integer locationID = resultSet.getInt("locationID");
                JobType jobType = JobType.valueOf(resultSet.getString("jobType"));
                Integer salaryLeast = resultSet.getInt("salaryLeast");
                Integer salaryGreatest = resultSet.getInt("salaryGreatest");
                String currency = resultSet.getString("currency");
                String jobTitle = resultSet.getString("jobTitle");
                JobLevel jobLevel = JobLevel.valueOf(resultSet.getString("jobLevel"));
                String jobDescription = resultSet.getString("jobDescription");
                Date deadlineDate = resultSet.getDate("deadlineDate");

                jobTitle = (jobTitle != null) ? jobTitle : "";

                return new JobRequests(
                        jobID,
                        jobType,
                        salaryLeast,
                        salaryGreatest,
                        currency != null ? currency : "",
                        jobTitle,
                        jobLevel,
                        jobDescription != null ? jobDescription : "",
                        deadlineDate,
                        locationID
                );
            } else {
                throw new Exception("Không tìm được JobRequest");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public JobRequests registerJobRequest(ServerClient.JobRequestFullInfo request, Connection connection) throws Exception {
        System.out.println("registerJobRequest");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `JobRequests` (`locationID`, `jobType`, `salaryLeast`, `salaryGreatest`, `currency`, `jobTitle`, `jobLevel`, `jobDescription`, `deadlineDate`) ");
        sb.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Validate and process inputs
            if (request.getJobID() != 0) {
                throw new Exception("Job ID should not be set for new entries.");
            }

            int locationID = request.getLocationID();
            if (locationID <= 0) {
                throw new Exception("Invalid Location ID.");
            }

            ServerClient.JobType jobType = request.getJobType();
            if (jobType != ServerClient.JobType.FULLTIME && jobType != ServerClient.JobType.HALFTIME) {
                throw new Exception("Invalid Job Type.");
            }
            String jobTypeString = jobType.name();

            int salaryLeast = request.getSalaryLeast();
            int salaryGreatest = request.getSalaryGreatest();
            if (salaryLeast <= 0 || salaryGreatest <= 0 || salaryLeast > salaryGreatest) {
                throw new Exception("Invalid salary range.");
            }

            String currency = request.getCurrency();
            if (currency == null || currency.isEmpty()) {
                throw new Exception("Currency is required.");
            }

            String jobTitle = request.getJobTitle();
            if (jobTitle == null || jobTitle.isEmpty()) {
                jobTitle = "";
            }

            ServerClient.JobLevel jobLevel = request.getJobLevel();
            if (jobLevel == null || (jobLevel != ServerClient.JobLevel.ENTRY_LEVEL &&
                    jobLevel != ServerClient.JobLevel.MID_LEVEL &&
                    jobLevel != ServerClient.JobLevel.SENIOR_LEVEL &&
                    jobLevel != ServerClient.JobLevel.MANAGER &&
                    jobLevel != ServerClient.JobLevel.DIRECTOR &&
                    jobLevel != ServerClient.JobLevel.EXECUTIVE)) {
                throw new Exception("Invalid Job Level.");
            }
            String jobLevelString = jobLevel.name(); // Converts enum to its string representation


            String jobDescription = request.getJobDescription();
            if (jobDescription == null) {
                jobDescription = "";
            }

            com.google.protobuf.Timestamp deadlineDate = request.getDeadlineDate();
            String deadlineDateString;

            if (deadlineDate == null) {
                deadlineDateString = "9999-01-01";
            } else {
                java.sql.Date sqlDate = new java.sql.Date(deadlineDate.getSeconds() * 1000); // Convert seconds to milliseconds
                deadlineDateString = sqlDate.toString();
            }

            // Set values in the prepared statement
            preparedStatement.setInt(1, locationID);
            preparedStatement.setString(2, jobTypeString);
            preparedStatement.setInt(3, salaryLeast);
            preparedStatement.setInt(4, salaryGreatest);
            preparedStatement.setString(5, currency);
            preparedStatement.setString(6, jobTitle);
            preparedStatement.setString(7, jobLevelString);
            preparedStatement.setString(8, jobDescription);
            preparedStatement.setString(9, deadlineDateString);

            // Execute the query and handle the result
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int jobID = resultSet.getInt(1);
                    return this.readJobRequest(ServerClient.JobRequestMetaInfo
                            .newBuilder()
                            .setJobID(jobID)
                            .build(), connection);
                }
            } else {
                throw new Exception("Failed to insert JobRequest.");
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        throw new Exception("Unexpected error during JobRequest registration.");
    }

    public JobRequests updateJob(ServerClient.JobRequestFullInfo request, Connection connection) throws Exception {
        System.out.println("updateJob");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `JobRequests` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if (request.getJobTitle() != null && !request.getJobTitle().isBlank()) {
                sb.append("`JobRequests`.`jobTitle` = ?, ");
                parameters.add(request.getJobTitle());
            }

            if (request.getJobType() != null) {
                sb.append("`JobRequests`.`jobType` = ?, ");
                parameters.add(request.getJobType().name());
            }

            if (request.getSalaryLeast() > 0) {
                sb.append("`JobRequests`.`salaryLeast` = ?, ");
                parameters.add(request.getSalaryLeast());
            }

            if (request.getSalaryGreatest() > 0) {
                sb.append("`JobRequests`.`salaryGreatest` = ?, ");
                parameters.add(request.getSalaryGreatest());
            }

            if (request.getCurrency() != null && !request.getCurrency().isBlank()) {
                sb.append("`JobRequests`.`currency` = ?, ");
                parameters.add(request.getCurrency());
            }

            if (request.getJobLevel() != null) {
                sb.append("`JobRequests`.`jobLevel` = ?, ");
                parameters.add(request.getJobLevel().name());
            }

            if (request.hasDeadlineDate()) {
                sb.append("`JobRequests`.`deadlineDate` = ?, ");
                parameters.add(new java.sql.Date(request.getDeadlineDate().getSeconds() * 1000));
            }

            if (request.getJobID() == 0) throw new Exception("JobID is required for an update.");
            sb.setLength(sb.length() - 2);
            sb.append(" WHERE `JobRequests`.`jobID` = ?;");
            parameters.add(request.getJobID());

            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return this.readJobRequest(ServerClient.JobRequestMetaInfo.newBuilder()
                                .setJobID(request.getJobID())
                                .build(),
                        connection);
            }
            throw new Exception("Update operation failed.");
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Boolean deleteJob(ServerClient.JobRequestMetaInfo request, Connection connection) throws Exception {
        System.out.println("deleteJob");

        String sql = "DELETE FROM `JobRequests` WHERE `jobID` = ?";
        PreparedStatement preparedStatement = null;
        try {
            if (request.getJobID() == 0) {
                throw new Exception("Job ID is required for deletion");
            }

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getJobID());

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } finally {
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public ArrayList<JobRequests> readJobRequestList(Connection connection) throws Exception {
        System.out.println("readJobRequestList");

        String query = "SELECT * FROM `JobRequests`;";
        ArrayList<JobRequests> jobsList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer jobID = resultSet.getInt("jobID");
                Integer locationID = resultSet.getInt("locationID");
                JobType jobType = JobType.valueOf(resultSet.getString("jobType"));
                Integer salaryLeast = resultSet.getInt("salaryLeast");
                Integer salaryGreatest = resultSet.getInt("salaryGreatest");
                String currency = resultSet.getString("currency");
                String jobTitle = resultSet.getString("jobTitle");
                JobLevel jobLevel = JobLevel.valueOf(resultSet.getString("jobLevel"));
                String jobDescription = resultSet.getString("jobDescription");
                Date deadlineDate = resultSet.getDate("deadlineDate");
                jobsList.add(new JobRequests(
                        jobID,
                        jobType,
                        salaryLeast,
                        salaryGreatest,
                        currency != null ? currency : "",
                        jobTitle,
                        jobLevel,
                        jobDescription != null ? jobDescription : "",
                        deadlineDate,
                        locationID
                ));
            }
            return jobsList;
        }finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Boolean applyCV(ServerClient.JobRequestFullInfo request, Connection connection) throws Exception {
        System.out.println("applyCV");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Applies` (`CVID`, `jobID`) ");
        sb.append("VALUES (?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = sb.toString();
            if(request.getJobID() == 0)   throw new Exception("Job không hợp lệ");
            JobRequests jobRequests = this.readJobRequest(ServerClient.JobRequestMetaInfo.newBuilder().setJobID(request.getJobID()).build(), connection);

            Date deadlineDate = jobRequests.getDeadlineDate();
            if (deadlineDate == null) throw new Exception("Ngày hết hạn không được xác định");

            LocalDateTime deadlineDateTime = deadlineDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            if (LocalDateTime.now().isAfter(deadlineDateTime)) throw new Exception("Hết hạn nộp CV cho job này");

            preparedStatement = connection.prepareStatement(sql);

            List<Integer> CVsList = Converter.protoMapToList(request.getCurrentCVsMap());
            if(CVsList.isEmpty()) throw new Exception("Danh sách CV rỗng");

            for (Integer cvID : CVsList) {
                preparedStatement.setInt(1, cvID);
                preparedStatement.setInt(2, request.getJobID());
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected == 0) {
                    throw new Exception("Có CV không hợp lệ");
                }
            }
            return true;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }
}
