package org.DAO;

import org.connectConfig.HikariDataSource;
import org.model.Candidates;
import org.model.Recruiters;
import org.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecruitersDAO {
    public RecruitersDAO() {}

    public int registerRecruiters(Recruiters recruiters, Connection connection){
        System.out.println("registerRecruiters");

        String sql = "INSERT INTO `Recruiters`(`userID`, `companyID`, `roleID`, `departmentName`) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, recruiters.getUserID());
            preparedStatement.setInt(2, recruiters.getCompaniesID());
            preparedStatement.setInt(3, recruiters.getRoleID());
            preparedStatement.setString(4, recruiters.getDepartmentName());
            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted == 1){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                int userID = 0;
                if (generatedKeys.next()) {
                    userID = generatedKeys.getInt(1);
                    System.out.println("Thêm được Recruiter");
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

    public Recruiters loginRecruiter(Users user){
        System.out.println("loginRecruiter");
        Recruiters temp = new Recruiters(user);
        String sql = "SELECT * FROM `Recruiters` WHERE `Recruiters`.`userID` = ?";
        PreparedStatement preparedStatement = null;
        Connection connection = HikariDataSource.getConnection();
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, temp.getUserID());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int recruiterID = resultSet.getInt("recruiterID");
                int companyID = resultSet.getInt("companyID");
                int roleID = resultSet.getInt("roleID");
                String departmentName = resultSet.getString("departmentName");

                temp.setRecruiterID(recruiterID);
                temp.setCompaniesID(companyID);
                temp.setRoleID(roleID);
                temp.setDepartmentName(departmentName);
                return temp;
            }
            else return null;
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
