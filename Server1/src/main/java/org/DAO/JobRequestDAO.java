package org.DAO;

import org.controller.Converter;
import org.model.*;
import proto.ServerClient;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class JobRequestDAO {
    public JobRequests readJobRequest(ServerClient.JobRequestFullInfo request, Connection connection) throws Exception {
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
                JobRequests jobRequests = new JobRequests();
                Integer jobID = resultSet.getInt("jobID");
                jobRequests.setJobID(jobID);
                Integer branchID = resultSet.getInt("branchID");
                jobRequests.setBranchID(branchID);

                String title = resultSet.getString("title");
                jobRequests.setTitle(title);
                String worktime = resultSet.getString("worktime");
                jobRequests.setWorktime(worktime);
                String jobField = resultSet.getString("jobField");
                jobRequests.setJobField(jobField);
                Integer locationID = resultSet.getInt("locationID");
                jobRequests.setLocationID(locationID);
                JobType jobType = JobType.valueOf(resultSet.getString("jobType"));
                jobRequests.setJobType(jobType);
                Integer salaryLeast = resultSet.getInt("salaryLeast");
                jobRequests.setSalaryLeast(salaryLeast);
                Integer salaryGreatest = resultSet.getInt("salaryGreatest");
                jobRequests.setSalaryGreatest(salaryGreatest);
                Date deadlineDate = resultSet.getDate("deadlineDate");
                jobRequests.setDeadlineDate(deadlineDate);

                String jobTitle = resultSet.getString("jobTitle");
                jobRequests.setJobTitle(jobTitle);
                JobLevel jobLevel = JobLevel.valueOf(resultSet.getString("jobLevel"));
                jobRequests.setJobLevel(jobLevel);
                String jobDescription = resultSet.getString("jobDescription");
                jobRequests.setJobDescription(jobDescription);
                String jobRequirement = resultSet.getString("jobRequirement");
                jobRequests.setJobRequirement(jobRequirement);
                String jobBenefit = resultSet.getString("jobBenefit");
                jobRequests.setJobBenefit(jobBenefit);

                Integer groupID = resultSet.getInt("groupID");
                jobRequests.setGroupID(groupID);

                return jobRequests;
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
        sb.append("INSERT INTO `JobRequests` (`branchID`, " +
                "`title`, `worktime`, `jobField`, `locationID`, `jobType`, `salaryLeast`, `salaryGreatest`, `deadlineDate`," +
                " `jobTitle`, `jobLevel`, `jobDescription`, `jobRequirement`, `jobBenefit`, `groupID`) ");
        sb.append("VALUES (?, ?, ?,  ?, ?, ?,  ?, ?, ?,  ?, ?, ?,  ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (request.getJobID() != 0)    throw new Exception("Job ID should not be set for new entries.");

            Integer branchID = request.getBranchID();
            if (branchID <= 0)  throw new Exception("Invalid branch ID.");
            String title = request.getTitle().toString();
            String worktime = request.getWorktime().toString();
            String jobField = request.getJobField().toString();
            Integer locationID = request.getLocationID();
            if (locationID <= 0)  throw new Exception("Invalid Location ID.");
            ServerClient.JobType jobType = request.getJobType();
            if (jobType != ServerClient.JobType.FULLTIME && jobType != ServerClient.JobType.HALFTIME && jobType != ServerClient.JobType.INTERN)
                throw new Exception("Invalid Job Type.");
            String jobTypeString = jobType.name();
            Integer salaryLeast = request.getSalaryLeast();
            Integer salaryGreatest = request.getSalaryGreatest();
            if (salaryLeast <= 0 || salaryGreatest <= 0 || salaryLeast > salaryGreatest) {
                throw new Exception("Invalid salary range.");
            }
            com.google.protobuf.Timestamp deadlineDate = request.getDeadlineDate();
            String deadlineDateString;
            if (deadlineDate == null) {
                deadlineDateString = "9999-01-01";
            } else {
                Date sqlDate = new Date(deadlineDate.getSeconds() * 1000); // Convert seconds to milliseconds
                deadlineDateString = sqlDate.toString();
            }


            String jobTitle = request.getJobTitle().toString();
            ServerClient.JobLevel jobLevel = request.getJobLevel();
            if (jobLevel == null || (jobLevel != ServerClient.JobLevel.ENTRY_LEVEL &&
                    jobLevel != ServerClient.JobLevel.MID_LEVEL &&
                    jobLevel != ServerClient.JobLevel.SENIOR_LEVEL &&
                    jobLevel != ServerClient.JobLevel.MANAGER &&
                    jobLevel != ServerClient.JobLevel.DIRECTOR &&
                    jobLevel != ServerClient.JobLevel.EXECUTIVE)) {
                throw new Exception("Invalid Job Level.");
            }
            String jobLevelString = jobLevel.name();
            String jobDescription = request.getJobDescription().toString();
            String jobRequirement = request.getJobRequirement().toString();
            String jobBenefit = request.getJobBenefit().toString();

            Integer groupID = request.getGroupID();

            // Set values in the prepared statement
            preparedStatement.setInt(1, branchID);

            preparedStatement.setString(2, title);
            preparedStatement.setString(3, worktime);
            preparedStatement.setString(4, jobField);
            preparedStatement.setInt(5, locationID);
            preparedStatement.setString(6, jobTypeString);
            preparedStatement.setInt(7, salaryLeast);
            preparedStatement.setInt(8, salaryGreatest);
            preparedStatement.setString(9, deadlineDateString);

            preparedStatement.setString(10, jobTitle);
            preparedStatement.setString(11, jobLevelString);
            preparedStatement.setString(12, jobDescription);
            preparedStatement.setString(13, jobRequirement);
            preparedStatement.setString(14, jobBenefit);


            preparedStatement.setInt(15, groupID);
            // Execute the query and handle the result
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int jobID = resultSet.getInt(1);
                    return this.readJobRequest(ServerClient.JobRequestFullInfo
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
            if (request.getBranchID() > 0) {
                sb.append("`JobRequests`.`branchID` = ?, ");
                parameters.add(request.getBranchID());
            }

            if (!request.getTitle().isEmpty()) {
                sb.append("`JobRequests`.`title` = ?, ");
                parameters.add(request.getTitle());
            }

            if (!request.getWorktime().isEmpty()) {
                sb.append("`JobRequests`.`worktime` = ?, ");
                parameters.add(request.getWorktime());
            }

            if (!request.getJobField().isEmpty()) {
                sb.append("`JobRequests`.`jobField` = ?, ");
                parameters.add(request.getJobField());
            }

            if (request.getLocationID() > 0) {
                sb.append("`JobRequests`.`locationID` = ?, ");
                parameters.add(request.getLocationID());
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

            if (request.hasDeadlineDate()) {
                sb.append("`JobRequests`.`deadlineDate` = ?, ");
                parameters.add(new Date(request.getDeadlineDate().getSeconds() * 1000));
            }


            if (!request.getJobTitle().isEmpty()) {
                sb.append("`JobRequests`.`jobTitle` = ?, ");
                parameters.add(request.getJobTitle());
            }

            if (request.getJobLevel() != null) {
                sb.append("`JobRequests`.`jobLevel` = ?, ");
                parameters.add(request.getJobLevel().name());
            }

            if (!request.getJobDescription().isEmpty()) {
                sb.append("`JobRequests`.`jobDescription` = ?, ");
                parameters.add(request.getJobDescription());
            }

            if (!request.getJobRequirement().isEmpty()) {
                sb.append("`JobRequests`.`jobRequirement` = ?, ");
                parameters.add(request.getJobRequirement());
            }

            if (!request.getJobBenefit().isEmpty()) {
                sb.append("`JobRequests`.`jobBenefit` = ?, ");
                parameters.add(request.getJobBenefit());
            }

            if (request.getGroupID() > 0) {
                sb.append("`JobRequests`.`groupID` = ?, ");
                parameters.add(request.getGroupID());
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
                return this.readJobRequest(ServerClient.JobRequestFullInfo.newBuilder()
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

    public Boolean deleteJob(ServerClient.JobRequestFullInfo request, Connection connection) throws Exception {
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

                jobsList.add(this.readJobRequest(ServerClient.JobRequestFullInfo
                                .newBuilder()
                                .setJobID(jobID)
                        .build(), connection));
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
            JobRequests jobRequests = this.readJobRequest(ServerClient.JobRequestFullInfo.newBuilder().setJobID(request.getJobID()).build(), connection);

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

    public ArrayList<Integer> readJobRequestIDs(Branchs branchs, Connection connection) throws Exception {
        System.out.println("readJobRequestIDs");

        Integer branchID = branchs.getBranchID();
        if (branchID <= 0) throw new Exception("Kết quả trả về không hợp lệ");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT `jobID` FROM `JobRequests` WHERE `JobRequests`.`branchID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Integer> jobRequestMap = new ArrayList<>();

        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, branchID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer jobRequestID = resultSet.getInt("jobID");

                if (jobRequestID <= 0) throw new Exception("Kết quả trả về không hợp lệ");
                jobRequestMap.add(jobRequestID);
            }
            return jobRequestMap;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public ArrayList<Integer> searchJobsInApplies(ServerClient.JobRequestRestrict requestRestrict, Connection connection) throws Exception {
        System.out.println("searchJobsInApplies");

        ArrayList<Integer> Jobs = new ArrayList<>();
        List<Object> parameters = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        StringBuilder queryBuilder = new StringBuilder("SELECT `Applies`.`jobID` FROM `Applies` WHERE 1=1");
        if(requestRestrict.getCVID() != 0){
            queryBuilder.append(" AND `Applies`.`CVID` = ?");
            parameters.add(requestRestrict.getCVID());
        }
        try {
            preparedStatement = connection.prepareStatement(queryBuilder.toString());
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            System.out.println(queryBuilder.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Jobs.add(resultSet.getInt("jobID"));
            }
            return Jobs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public ArrayList<JobRequests> searchJobsInJobs(ServerClient.JobRequestRestrict request, ArrayList<Integer> searchLocation, ArrayList<Integer> searchJob, Connection connection) throws Exception {
        System.out.println("searchJobsInJobs");

        StringBuilder sql = new StringBuilder("SELECT `jobID` FROM `JobRequests` WHERE 1=1");
        List<Object> parameters = new ArrayList<>();

        if (!request.getSearchParam().isEmpty()) {
            sql.append(" AND CONCAT(jobDescription, '#', jobRequirement, '#', jobBenefit, '#', title, '#', jobField, '#', jobTitle) LIKE ?");
            parameters.add("%" + request.getSearchParam() + "%");
        }

        if (searchLocation != null && !searchLocation.isEmpty()) {
            sql.append(" AND `branchID` IN (");
            for (int i = 0; i < searchLocation.size(); i++) {
                sql.append(searchLocation.get(i));
                if (i < searchLocation.size() - 1) {
                    sql.append(", ");
                }
            }
            sql.append(")");
        }

        if (searchJob != null && !searchJob.isEmpty()) {
            sql.append(" AND jobID IN (");
            for (int i = 0; i < searchJob.size(); i++) {
                sql.append(searchJob.get(i));
                if (i < searchJob.size() - 1) {
                    sql.append(", ");
                }
            }
            sql.append(")");
        }

        // Add salary filter
        if (request.getSalaryMinimum() > 0) {
            sql.append(" AND salaryLeast >= ").append(request.getSalaryMinimum());
        }

        if (request.getJobLevel().getNumber() != 0) {
            sql.append(" AND jobLevel = '").append(request.getJobLevel().name()).append("'");
        }

        if (request.getJobType().getNumber() != 0) {
            sql.append(" AND jobType = '").append(request.getJobType().name()).append("'");
        }

        if (request.getIsEnded()) {
            sql.append(" AND deadlineDate < CURRENT_DATE");
        } else {
            sql.append(" AND deadlineDate >= CURRENT_DATE");
        }

        if(request.getLocationID() != 0){
            sql.append(" AND `locationID` = ").append(request.getLocationID());
        }

        sql.append(" ORDER BY createdAt DESC");

        System.out.println(sql);
//        Statement stmt = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        for (int i = 0; i < parameters.size(); i++) {
            preparedStatement.setObject(i + 1, parameters.get(i));
        }
        System.out.println(sql.toString());
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<JobRequests> jobRequests = new ArrayList<>();
        while (rs.next()) {
            jobRequests.add(this.readJobRequest(ServerClient.JobRequestFullInfo.newBuilder().setJobID(rs.getInt("jobID")).build(), connection));
        }
        return jobRequests;
    }

    public ArrayList<ServerClient.AppliesInfo> searchCV(ServerClient.JobRequestRestrict request, Connection connection) throws Exception {
        System.out.println("searchCV");

        Integer CVID = request.getCVID();
        Integer jobID = request.getJobRequestID();

        if ((CVID == null || CVID == 0) && (jobID == null || jobID == 0)) {
            throw new Exception("Either CVID or jobID must be provided.");
        }

        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM Applies WHERE 1=1"); // Start with a base query

        if (CVID != null && CVID != 0) {
            sqlBuilder.append(" AND CVID = ?");
        }

        if (jobID != null && jobID != 0) {
            sqlBuilder.append(" AND jobID = ?");
        }

        String sql = sqlBuilder.toString();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            int paramIndex = 1;

            // Set the parameters dynamically
            if (CVID != null && CVID != 0) {
                stmt.setInt(paramIndex++, CVID);
            }
            if (jobID != null && jobID != 0) {
                stmt.setInt(paramIndex++, jobID);
            }

            ArrayList<ServerClient.AppliesInfo> ans = new ArrayList<>();

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ServerClient.AppliesInfo.Builder builder = ServerClient.AppliesInfo.newBuilder();

                    // Build the AppliesInfo object from the ResultSet
                    builder.setCVID(rs.getInt("CVID"));
                    builder.setJobID(rs.getInt("jobID"));
                    builder.setStatus(ServerClient.Status.valueOf(rs.getString("status")));

                    ans.add(builder.build());
                }
                return ans;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error executing the query", e);
        }
    }
}
