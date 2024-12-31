package org.DAO;

import org.controller.Converter;
import org.model.Companies;
import org.model.Users;
import proto.ServerClient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public Users createUser(ServerClient.CandidateFullInfo request, Connection connection) throws Exception {
        System.out.println("createUser");

        StringBuilder sb= new StringBuilder();
        sb.append("INSERT INTO `Users`(`username`, `password_hashed`, `firstName`, `lastName`, `email`, `googleToken`, `googleTokenExpiration`) VALUES (?, ?, ?, ?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Users users = new Users();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            if(request.getUser().getUserID() != 0)  return null;

            String username = request.getUser().getUsername();
            if (username.isEmpty() || username.isEmpty()) {
                return null;
            }
            users.setUsername(username);
            preparedStatement.setString(1, username);

            String password = request.getUser().getPassword();
            if(password.isEmpty() || password.isEmpty()){
                return  null;
            }
            password = Converter.hashPassword(password);
            users.setPassword_hashed(password);
            preparedStatement.setString(2, password);

            String firstName = request.getUser().getFirstname();
            if(!firstName.isEmpty() && !firstName.isEmpty()){
                users.setFirstName(firstName);
                preparedStatement.setString(3, firstName);
            }
            else {
                preparedStatement.setString(3, "firstName");
            }

            String lastname = request.getUser().getLastname();
            if(!lastname.isEmpty() && !lastname.isEmpty()){
                users.setLastName(lastname);
                preparedStatement.setString(4, lastname);
            }
            else {
                preparedStatement.setString(4, "lastname");
            }

            String email = request.getUser().getLastname();
            if(!email.isEmpty() && !email.isEmpty()){
                users.setEmail(email);
                preparedStatement.setString(5, email);
            }
            else {
                preparedStatement.setString(5, "email");
            }

            String googleToken = request.getUser().getGoogleToken();
            if(!googleToken.isEmpty() && !googleToken.isEmpty()){
                users.setGoogleToken(googleToken);
                preparedStatement.setString(6, googleToken);
            }else{
                preparedStatement.setString(6, "googleToken");
            }

            Timestamp timestamp = Converter.protoToTimeStamp(request.getUser().getGoogleTokenExpiration());
            if(timestamp.getTime() != 0){
                users.setGoogleTokenExpiration(timestamp);
                Date date = new Date(timestamp.getTime());
                preparedStatement.setDate(7, date);
            }
            else {
                preparedStatement.setDate(7, Date.valueOf("1970-01-01"));
            }
            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted == 1){
                System.out.println("1");
                resultSet = preparedStatement.getGeneratedKeys();
                Integer userID;
                if (resultSet.next()) {
                    userID = resultSet.getInt(1);
                    users.setUserID(userID);
                    System.out.println("Thêm được Users");
                    return users;
                }
                throw new Exception("Thêm được nhưng không tìm được Users");
            }
            else {
                System.out.println("Không thêm được Users");
                return null;
            }
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Users createUser(ServerClient.RecruiterFullInfo request, Connection connection) throws SQLException {
        System.out.println("createUser");

        StringBuilder sb= new StringBuilder();
        sb.append("INSERT INTO `Users`(`username`, `password_hashed`, `firstName`, `lastName`, `email`, `googleToken`, `googleTokenExpiration`) VALUES (?, ?, ?, ?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Users users = new Users();
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            if(request.getUser().getUserID() != 0)  return null;

            String username = request.getUser().getUsername();
            if (username.isEmpty() || username.isEmpty()) {
                return null;
            }
            users.setUsername(username);
            preparedStatement.setString(1, username);

            String password = request.getUser().getPassword();
            if(password.isEmpty() || password.isEmpty()){
                return  null;
            }
            password = Converter.hashPassword(password);
            users.setPassword_hashed(password);
            preparedStatement.setString(2, password);

            String firstName = request.getUser().getFirstname();
            if(!firstName.isEmpty() && !firstName.isEmpty()){
                users.setFirstName(firstName);
                preparedStatement.setString(3, firstName);
            }
            else {
                preparedStatement.setString(3, "firstName");
            }

            String lastname = request.getUser().getLastname();
            if(!lastname.isEmpty() && !lastname.isEmpty()){
                users.setLastName(lastname);
                preparedStatement.setString(4, lastname);
            }
            else {
                preparedStatement.setString(4, "lastname");
            }

            String email = request.getUser().getLastname();
            if(!email.isEmpty() && !email.isEmpty()){
                users.setEmail(email);
                preparedStatement.setString(5, email);
            }
            else {
                preparedStatement.setString(5, "email");
            }

            String googleToken = request.getUser().getGoogleToken();
            if(!googleToken.isEmpty() && !googleToken.isEmpty()){
                users.setGoogleToken(googleToken);
                preparedStatement.setString(6, googleToken);
            }else{
                preparedStatement.setString(6, "googleToken");
            }

            Timestamp timestamp = Converter.protoToTimeStamp(request.getUser().getGoogleTokenExpiration());
            if(timestamp.getTime() != 0){
                users.setGoogleTokenExpiration(timestamp);
                Date date = new Date(timestamp.getTime());
                preparedStatement.setDate(7, date);
            }
            else {
                preparedStatement.setDate(7, Date.valueOf("1970-01-01"));
            }
            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted == 1){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                Integer userID;
                if (generatedKeys.next()) {
                    userID = generatedKeys.getInt(1);
                    users.setUserID(userID);
                    System.out.println("Thêm được Users");
                    return users;
                }
                return null;
            }
            else {
                System.out.println("Không thêm được Users");
                return null;
            }
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Users readUser(ServerClient.UserMetaInfo request, Connection connection) throws SQLException {
        System.out.println("readUser");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Users` WHERE 1 = 1");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();

        if(request.getUserID() != 0){
            sb.append(" AND `Users`.`userID` = ?");
            parameters.add(request.getUserID());
        }
        if(!request.getUsername().isEmpty() && !request.getUsername().isEmpty()){
            sb.append(" AND `Users`.`username` = ?");
            parameters.add(request.getUsername());
        }
        if(!request.getPassword().isEmpty() && !request.getPassword().isEmpty()){
            sb.append(" AND `Users`.`password_hashed` = ?");
            parameters.add(request.getPassword());
        }
        try {
            sb.append(";");
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer userID = resultSet.getInt("userID");
                String username = resultSet.getString("username");
                String password_hashed = resultSet.getString("password_hashed");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");

                Users user = new Users(userID,
                        username,
                        password_hashed,
                        firstName,
                        lastName,
                        email, request.getIsCandidate());
                return  user;
            }
            else {
                return null;
            }
        }
        finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Users updateUser(ServerClient.UserFullInfo request, Connection connection) throws SQLException {
        System.out.println("updateUser");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Users` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try{
            if(request.getPassword() != null && !request.getPassword().isEmpty() && !request.getPassword().isEmpty()){
                sb.append("`Users`.`password_hashed` = ?, ");
                parameters.add(request.getPassword());
            }
            if(request.getFirstname() != null && !request.getFirstname().isEmpty() && !request.getFirstname().isEmpty()){
                sb.append("`Users`.`firstName` = ?, ");
                parameters.add(request.getFirstname());
            }
            if(request.getLastname() != null && !request.getLastname().isEmpty() && !request.getLastname().isEmpty()){
                sb.append("`Users`.`lastName` = ?, ");
                parameters.add(request.getLastname());
            }
            if(request.getEmail() != null && !request.getEmail().isEmpty() && !request.getEmail().isEmpty()){
                sb.append("`Users`.`email` = ?, ");
                parameters.add(request.getEmail());
            }

            if(request.getUserID() == 0)    throw new RuntimeException("Không có UserID");
            sb.setLength(sb.length()-2);
            sb.append(" WHERE `Users`.`userID` = ?;");
            parameters.add(request.getUserID());

            String sql =sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated >0 ){
                UserDAO userDAO = new UserDAO();
                return userDAO.readUser(Converter.userFullToMeta(request), connection);
            }
            throw new RuntimeException("Không update thành công");
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }

    }

    public Boolean deleteUser(ServerClient.UserMetaInfo request, Connection connection) throws SQLException {
        System.out.println("deleteUser");

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM `Users` WHERE `Users`.`userID` = ?;");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getUserID());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                return true;
            }
            return false;
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public ArrayList<Users> readUserList(Connection connection) throws SQLException {
        System.out.println("readUserList");

        String sql = "SELECT * FROM `Users`;";
        ArrayList<Users> usersArrayList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Users users = new Users();

                if(resultSet.getInt("userID") == 0){
                    throw new RuntimeException("userID sai");
                }
                users.setUserID(resultSet.getInt("userID"));

                String username = resultSet.getString("username");
                users.setUsername(username != null ? username : "");

                String password_hashed = resultSet.getString("password_hashed");
                users.setPassword_hashed(password_hashed != null ? password_hashed : "");

                String firstName = resultSet.getString("firstName");
                users.setFirstName(firstName != null ? firstName : "");

                String lastName = resultSet.getString("lastName");
                users.setLastName(lastName != null ? lastName : "");

                String email = resultSet.getString("email");
                users.setEmail(email != null ? email : "");
                usersArrayList.add(users);
            }
            return usersArrayList;
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   resultSet.close();
        }
    }

    public ArrayList<Integer> readRecruiterList(Companies companies, Connection connection) throws Exception {
        System.out.println("readRecruiterList");

        String query = "SELECT userID FROM `Recruiters` WHERE companyID = ?;";
        ArrayList<Integer> recruiterIDs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, companies.getCompaniesID()); // Assuming `Companies` has a `getCompanyID` method
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                recruiterIDs.add(resultSet.getInt("userID"));
            }

            return recruiterIDs;
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }
}
