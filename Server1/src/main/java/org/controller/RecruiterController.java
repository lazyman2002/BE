package org.controller;

import org.DAO.RecruiterDAO;
import org.DAO.UserDAO;
import org.connectConfig.HikariDataSource;
import org.model.Recruiters;
import org.model.Users;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecruiterController {
    public Recruiters recruiterCreate(ServerClient.RecruiterFullInfo request) throws Exception {
        System.out.println("recruiterCreate");

        UserDAO userDAO = new UserDAO();
        RecruiterDAO recruiterDAO = new RecruiterDAO();
        Users users = null;
        Recruiters recruiters;
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);

            users = userDAO.createUser(request, connection);
            if(users == null)   throw  new Exception("Không tạo được Users");
            
            recruiters = recruiterDAO.createRecruiter(users, request, connection);

            if(recruiters == null)  throw  new Exception("Không tạo được Recruiter");
            connection.commit();
            return recruiters;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Recruiters recruiterRead(ServerClient.UserMetaInfo request) throws SQLException {
        System.out.println("recruitersRead");

        UserDAO userDAO = new UserDAO();
        RecruiterDAO recruiterDAO = new RecruiterDAO();
        Users users = null;
        Recruiters recruiters;
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            recruiters = recruiterDAO.readRecruiter(request, connection);
            return recruiters;
        }finally {
            if(connection!= null)   connection.close();
        }
    }

    public Recruiters recruiterUpdate(ServerClient.RecruiterFullInfo request) throws SQLException {
        System.out.println("recruiterUpdate");

        RecruiterDAO recruiterDAO = new RecruiterDAO();
        Recruiters recruiters;
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            recruiters = recruiterDAO.updateRecruiter(request, connection);
            connection.commit();
            return recruiters;
        }
        finally {
            if(connection != null)  connection.close();
        }
    }

    public ArrayList<Recruiters> recruiterList() throws SQLException {
        System.out.println("recruiterList");

        RecruiterDAO recruiterDAO = new RecruiterDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return recruiterDAO.readRecruiterList(connection);
        }
        finally {
            if (connection != null) connection.close();
        }
    }
}
