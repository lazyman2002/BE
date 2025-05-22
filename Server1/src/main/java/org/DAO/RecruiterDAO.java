package org.DAO;

import org.controller.Converter;
import org.model.Recruiters;
import org.model.Users;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecruiterDAO {
    public Recruiters createRecruiter(Users users, ServerClient.RecruiterFullInfo request, Connection connection) throws Exception {
        System.out.println("createRecruiter");

        StringBuilder sb= new StringBuilder();
        sb.append("INSERT INTO `Recruiters`(`userID`, `branchID`, `roleName`, `roleLevel`, `departmentName`) VALUES (?, ? , ?, ?, ?)");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Recruiters recruiters = new Recruiters(users);
        try {
            String sql = sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, users.getUserID());

            if(request.getBranchID() == 0) {
                preparedStatement.setInt(2, 1);
            }
            else {
                recruiters.setBranchID(request.getBranchID());
                preparedStatement.setInt(2, request.getBranchID());
            }

            if(!request.getRoleName().isEmpty()){
                recruiters.setRoleName(request.getRoleName());
                preparedStatement.setString(3, request.getRoleName());
            }
            else preparedStatement.setString(3, "");


            if(request.getRoleLevel() == 0){
                preparedStatement.setInt(4, 999);
            }
            else {
                recruiters.setRoleLevel(request.getRoleLevel());
                preparedStatement.setInt(4, request.getRoleLevel());
            }

            if(!request.getDepartmentName().isEmpty() && !request.getDepartmentName().isEmpty()){
                recruiters.setDepartmentName(request.getDepartmentName());
                preparedStatement.setString(5, request.getDepartmentName());
            }
            else preparedStatement.setString(5, "");

            int rowsInserted = preparedStatement.executeUpdate();

            if(rowsInserted == 1){
                System.out.println("ok");
                return recruiters;
            }
            else throw new Exception("Recruiter không thêm thành công ");
        }
        finally {
            if(resultSet != null)    resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }


    }

    public Recruiters readRecruiter(ServerClient.UserFullInfo request, Connection connection) throws Exception {
        System.out.println("readRecruiter");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Recruiters` WHERE 1 = 1 ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Recruiters recruiters = null;
        UserDAO userDAO = new UserDAO();

        try {
            if(request.getUserID() == 0)    throw new RuntimeException("UserID không hợp lệ");
            Users users = userDAO.readUser(request, connection);
            recruiters = new Recruiters(users);

            sb.append(" AND `Recruiters`.`userID` = ?;");
            String sql = sb.toString();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, request.getUserID());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.isLast()) {
                    Integer branchID = resultSet.getInt("branchID");
                    Integer roleLevel = resultSet.getInt("roleLevel");
                    String roleName = resultSet.getString("roleName");
                    String departmentName = resultSet.getString("departmentName");
                    Boolean validated = resultSet.getBoolean("validated");

                    recruiters.setBranchID(branchID);
                    recruiters.setRoleLevel(roleLevel);
                    recruiters.setDepartmentName(departmentName);
                    recruiters.setRoleName(roleName);
                    recruiters.setValidated(validated);
                    return recruiters;
                } else {
                    throw new IllegalStateException("Query nhiều kết quả");
                }
            }
            else throw new RuntimeException("Không query được");
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public Recruiters updateRecruiter(ServerClient.RecruiterFullInfo request, Connection connection) throws Exception {
        System.out.println("updateRecruiter");

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE `Recruiters` SET ");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> parameters = new ArrayList<>();
        try {
            if(request.getBranchID() != 0){
                sb.append("`Recruiters`.`branchID` = ?, ");
                parameters.add(request.getBranchID());
            }

            if(request.getRoleLevel() != 0){
                sb.append("`Recruiters`.`roleLevel` = ?, ");
                parameters.add(request.getRoleLevel());
            }

            if(!request.getDepartmentName().isEmpty()){
                sb.append("`Recruiters`.`departmentName` = ?, ");
                parameters.add(request.getDepartmentName());
            }

            if(!request.getRoleName().isEmpty()){
                sb.append("`Recruiters`.`roleName` = ?, ");
                parameters.add(request.getRoleName());
            }

            sb.append("`Recruiters`.`validated` = ?, ");
            parameters.add(request.getValidated());

            sb.setLength(sb.length()-2);
            if(request.getUser().getUserID() != 0){
                sb.append(" WHERE `Recruiters`.`userID` = ?;");
                parameters.add(request.getUser().getUserID());
            }
            else {
                throw new RuntimeException("Không có UserID");
            }

            String sql =sb.toString();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated > 0){
                RecruiterDAO recruiterDAO = new RecruiterDAO();
                return recruiterDAO.readRecruiter(request.getUser(), connection);
            }
            throw new RuntimeException("Không update thành công");
        }finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }

    public ArrayList<Recruiters> readRecruiterList(Connection connection) throws Exception {
        System.out.println("readRecruiterLost");

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `Recruiters`;");
        ArrayList<Recruiters>   arrayList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            UserDAO userDAO = new UserDAO();
            preparedStatement = connection.prepareStatement(sb.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer userID = resultSet.getInt("userID");
                Recruiters recruiters = new Recruiters(userDAO.readUser(ServerClient.UserFullInfo
                                                                            .newBuilder()
                                                                            .setUserID(userID)
                                                                            .build()
                        , connection));

                Integer branchID = resultSet.getInt("branchID");
                recruiters.setBranchID(branchID);

                Integer roleLevel = resultSet.getInt("roleLevel");
                recruiters.setRoleLevel(roleLevel);

                String departmentName = resultSet.getString("departmentName");
                recruiters.setDepartmentName(departmentName != null ? departmentName : "");

                String roleName = resultSet.getString("roleName");
                recruiters.setRoleName(roleName != null ? roleName : "");

                Boolean validated = resultSet.getBoolean("validated");
                recruiters.setValidated(validated);
                arrayList.add(recruiters);
            }
            return  arrayList;
        }
        finally {
            if(resultSet != null)   resultSet.close();
            if(preparedStatement != null)   preparedStatement.close();
        }
    }
}
