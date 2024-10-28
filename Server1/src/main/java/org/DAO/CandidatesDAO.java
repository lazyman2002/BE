package org.DAO;

import org.connectConfig.HikariDataSource;
import org.model.Candidates;
import org.model.Gender;
import org.model.Users;

import java.sql.*;

public class CandidatesDAO {
    public int registerCandidates(Candidates candidates, Connection connection){
        System.out.println("registerCandidates");

        String sql = "INSERT INTO `Candidates`(`userID`, `birthDate`, `gender`) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, candidates.getUserID());
            preparedStatement.setDate(2, candidates.getBirthDate());
            preparedStatement.setString(3, candidates.getGender().getDisplayName());
            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted == 1){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                int userID = 0;
                if (generatedKeys.next()) {
                    userID = generatedKeys.getInt(1);
                    System.out.println("Thêm được Candidates");
                    return  userID;
                }
                return -1;
            }
            else {
                System.out.println("Không thêm được Candidates");
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public Candidates loginCandidate(Users user){
        System.out.println("loginCandidate");
        Candidates temp = new Candidates(user);
        String sql = "SELECT * FROM `Candidates` WHERE `Candidates`.`userID` = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = HikariDataSource.getConnection();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, temp.getUserID());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int candidateID = resultSet.getInt("candidateID");
                Date birthDate = resultSet.getDate("birthDate");
                String gender = resultSet.getString("gender");

                temp.setCandidateID(candidateID);
                temp.setBirthDate(birthDate);
                temp.setGender(Gender.valueOf(gender.toUpperCase()));
                return temp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
