package org.DAO;
import org.connectConfig.HikariDataSource;
import org.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
    public UsersDAO() {
    }
    public int registerUser(Users user, Connection connection) {
        System.out.println("registerUser");
        String hashedPassword = hashPassword(user.getPassword_hashed());
        user.setPassword_hashed(hashedPassword);

        String sql = "INSERT INTO `Users`(`username`, `password_hashed`, `firstName`, `lastName`, `email`, `isCandidate`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setBoolean(6, user.isCandidate());
            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted == 1){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                int userID = 0;
                if (generatedKeys.next()) {
                    userID = generatedKeys.getInt(1);
                    System.out.println("Thêm được user");
                    return  userID;
                }
                return -1;
            }
            else {
                System.out.println("Không thêm được user");
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

    public Users loginUser(String username, String password) {
        System.out.println("loginUser");
        String sql = "SELECT * FROM `Users` WHERE `Users`.`username` = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = HikariDataSource.getConnection();
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userID = resultSet.getInt("userID");
                String hashedPassword = resultSet.getString("password_hashed");
                String firstName = resultSet.getString("password_hashed");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                Boolean isCandidate = resultSet.getBoolean("isCandidate");
                if(verifyPassword(password, hashedPassword)){
                    return new Users(userID, username, hashedPassword, firstName, lastName, email, isCandidate);
                }
                else {
                    return null;
                }
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

    private String hashPassword(String password) {
        return password;
    }

    private boolean verifyPassword(String password, String hashedPassword) {
        return password.equals(hashedPassword);
    }
}
