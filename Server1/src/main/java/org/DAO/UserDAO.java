package org.DAO;

import org.controller.Converter;
import org.model.Branchs;
import org.model.Users;
import proto.ServerClient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public Users createUser(ServerClient.UserFullInfo request, Connection connection) throws Exception {
        System.out.println("createUser");

        StringBuilder sb= new StringBuilder();
        sb.append("INSERT INTO `Users`(`username`, `password_hashed`, `firstName`, `lastName`, `email`) VALUES (?, ?, ?, ?, ?);");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Users users = new Users();
        System.out.println(request);
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            String username = request.getUsername();
            if(username.isEmpty())      return null;
            users.setUsername(username);
            preparedStatement.setString(1, username);

            String password = request.getPasswordHashed();
            if(password.isEmpty())      return  null;
            password = Converter.hashPassword(password);
            users.setPassword_hashed(password);
            preparedStatement.setString(2, password);

            String firstName = request.getFirstname();
            if(!firstName.isEmpty()){
                users.setFirstName(firstName);
                preparedStatement.setString(3, firstName);
            }
            else {
                preparedStatement.setString(3, "");
            }

            String lastname = request.getLastname();
            if(!lastname.isEmpty()){
                users.setLastName(lastname);
                preparedStatement.setString(4, lastname);
            }
            else {
                preparedStatement.setString(4, "");
            }

            String email = request.getLastname();
            if(!email.isEmpty()){
                users.setEmail(email);
                preparedStatement.setString(5, email);
            }
            else {
                preparedStatement.setString(5, "");
            }

            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted == 1){
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
                throw new Exception("Không thêm được Users");
            }
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Users readUser(ServerClient.UserFullInfo request, Connection connection) throws Exception {
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

        if(!request.getUsername().isEmpty()){
            sb.append(" AND `Users`.`username` = ?");
            parameters.add(request.getUsername());
        }

        if(!request.getPasswordHashed().isEmpty()){
            sb.append(" AND `Users`.`password_hashed` = ?");
            parameters.add(request.getPasswordHashed());
        }

        if(!request.getFirstname().isEmpty()){
            sb.append(" AND `Users`.`firstName` = ?");
            parameters.add(request.getFirstname());
        }
        if(!request.getLastname().isEmpty()){
            sb.append(" AND `Users`.`lastName` = ?");
            parameters.add(request.getLastname());
        }
        if(!request.getEmail().isEmpty()){
            sb.append(" AND `Users`.`email` = ?");
            parameters.add(request.getLastname());
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
                Users users = new Users();
                Integer userID = resultSet.getInt("userID");
                String username = resultSet.getString("username");
                String password_hashed = resultSet.getString("password_hashed");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");

                users.setUserID(userID);
                users.setUsername(username);
                users.setPassword_hashed(password_hashed);
                users.setFirstName(firstName);
                users.setLastName(lastName);
                users.setEmail(email);
                return  users;
            }
            else {
                throw new Exception("Không tìm thấy");
            }
        }
        finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        }
    }

    public Users updateUser(ServerClient.UserFullInfo request, Connection connection) throws Exception {
        System.out.println("updateUser");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Users` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try{
            if(!request.getPasswordHashed().isEmpty()){
                sb.append("`Users`.`password_hashed` = ?, ");
                parameters.add(request.getPasswordHashed());
            }

            if(!request.getFirstname().isEmpty()){
                sb.append("`Users`.`firstName` = ?, ");
                parameters.add(request.getFirstname());
            }

            if(!request.getLastname().isEmpty()){
                sb.append("`Users`.`lastName` = ?, ");
                parameters.add(request.getLastname());
            }

            if(!request.getEmail().isEmpty()){
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
                return userDAO.readUser(ServerClient.UserFullInfo
                                                    .newBuilder()
                                                    .setUserID(request.getUserID())
                                                    .build()
                        , connection);
            }
            throw new RuntimeException("Không update thành công");
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }

    }

    public Boolean deleteUser(ServerClient.UserFullInfo request, Connection connection) throws Exception {
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

    public ArrayList<Users> readUserList(Connection connection) throws Exception {
        System.out.println("readUserList");

        String sql = "SELECT * FROM `Users`;";
        ArrayList<Users> usersArrayList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
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

    public ArrayList<Integer> readRecruiterList(Branchs branch, Connection connection) throws Exception {
        System.out.println("readRecruiterList");

        String query = "SELECT userID FROM `Recruiters` WHERE branchID = ?;";
        ArrayList<Integer> recruiterIDs = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, branch.getBranchID()); // Assuming `Companies` has a `getCompanyID` method
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
