package org.controller;

import com.google.protobuf.Empty;
import org.DAO.CandidateDAO;
import org.DAO.UserDAO;
import org.connectConfig.HikariDataSource;
import org.eclipse.jetty.server.Authentication;
import org.model.Users;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {
    public Users userRead(ServerClient.UserMetaInfo request) throws SQLException {
        UserDAO userDAO = new UserDAO();
        Users users;
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            users = userDAO.readUser(request, connection);
            return  users;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Users userUpdate(ServerClient.UserFullInfo request) throws SQLException {
        System.out.println("userUpdate");
        UserDAO userDAO = new UserDAO();
        Users users;
        Connection connection = null;

        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            users = userDAO.updateUser(request, connection);
            connection.commit();
            return  users;
        } finally {
            if(connection != null)   connection.close();
        }
    }

    public Boolean userDelete(ServerClient.UserMetaInfo request) throws SQLException {
        UserDAO userDAO = new UserDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if(userDAO.deleteUser(request, connection)){
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if(connection != null)   connection.close();
        }
    }

    public ArrayList<Users> userList() throws SQLException {
        UserDAO userDAO = new UserDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return userDAO.readUserList(connection);
        }
        finally {
            if(connection != null)  connection.close();
        }
    }
}
