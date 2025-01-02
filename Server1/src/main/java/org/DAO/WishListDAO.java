package org.DAO;

import org.model.Roles;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WishListDAO {
    public ServerClient.WishListFullInfo registerWishList(ServerClient.WishListFullInfo request, Connection connection) throws Exception {
        System.out.println("registerWishList");

        String insertQuery = "INSERT INTO WishList (candidateID, salaryMinimum, location, jobType, jobLevel, insurance) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, request.getCandidateID());

            if (request.getSalaryMinimum() >0) {
                preparedStatement.setInt(2, request.getSalaryMinimum());
            } else {
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            }

            if (!request.getLocation().isEmpty()) {
                preparedStatement.setString(3, request.getLocation());  // Set location if it's present
            } else {
                preparedStatement.setNull(3, java.sql.Types.VARCHAR);  // Set null if location is not present
            }

            preparedStatement.setString(4, request.getJobType().name());
            preparedStatement.setString(5, request.getJobLevel().name());  // Set jobLevel if it's present

            // Set insurance (can be null)
            if (!request.getInsurance().isEmpty()) {
                preparedStatement.setString(6, request.getInsurance());
            } else {
                preparedStatement.setNull(6, java.sql.Types.VARCHAR);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return readWishList(ServerClient.UserMetaInfo.newBuilder().setUserID(request.getCandidateID()).build(), connection);
            } else {
                throw new Exception("Failed to insert WishList.");
            }
        }
    }

    public ServerClient.WishListFullInfo readWishList(ServerClient.UserMetaInfo request, Connection connection) throws Exception {
        System.out.println("readWishList");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `WishList` WHERE `WishList`.`candidateID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getUserID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ServerClient.WishListFullInfo.Builder builder = ServerClient.WishListFullInfo.newBuilder();
                Integer candidateID = resultSet.getInt("candidateID");
                if(candidateID != null && candidateID != 0) builder.setCandidateID(candidateID);
                Integer salaryMinimum = resultSet.getInt("salaryMinimum");
                if(salaryMinimum!= null)    builder.setSalaryMinimum(salaryMinimum);
                String location = resultSet.getString("location");
                if(location!= null && !location.isEmpty())  builder.setLocation(location);
                String jobType = resultSet.getString("jobType");
                builder.setJobType(ServerClient.JobType.valueOf(jobType));
                String jobLevel = resultSet.getString("jobLevel");
                builder.setJobLevel(ServerClient.JobLevel.valueOf(jobLevel));
                String insurance = resultSet.getString("insurance");
                if(insurance!= null && !insurance.isEmpty())  builder.setInsurance(insurance);
                return builder.build();
            } else {
                return ServerClient.WishListFullInfo.newBuilder().build();
            }
        }
        finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public ServerClient.WishListFullInfo updateWishList(ServerClient.WishListFullInfo request, Connection connection) throws Exception {
        System.out.println("updateWishList");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `WishList` SET `salaryMinimum` = ?, `location` = ?, `jobType` = ?, `jobLevel` = ?, `insurance` = ? WHERE `candidateID` = ?;");
        PreparedStatement preparedStatement = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters based on the request
            if (request.getSalaryMinimum() >0) {
                preparedStatement.setInt(1, request.getSalaryMinimum());
            } else {
                preparedStatement.setNull(1, java.sql.Types.INTEGER);
            }

            if (!request.getLocation().isEmpty()) {
                preparedStatement.setString(2, request.getLocation());
            } else {
                preparedStatement.setNull(2, java.sql.Types.VARCHAR);
            }

            preparedStatement.setString(3, request.getJobType().name());
            preparedStatement.setString(4, request.getJobLevel().name());

            if (!request.getInsurance().isEmpty()) {
                preparedStatement.setString(5, request.getInsurance());
            } else {
                preparedStatement.setNull(5, java.sql.Types.VARCHAR);
            }

            preparedStatement.setInt(6, request.getCandidateID());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return readWishList(ServerClient.UserMetaInfo.newBuilder().setUserID(request.getCandidateID()).build(), connection);
            } else {
                throw new Exception("Failed to update the WishList record for candidateID: " + request.getCandidateID());
            }
        } finally {
            if (preparedStatement != null) preparedStatement.close();
        }
    }

}
