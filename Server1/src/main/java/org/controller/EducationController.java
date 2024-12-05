package org.controller;

import org.DAO.EducationDAO;
import org.connectConfig.HikariDataSource;
import org.model.Educations;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;

public class EducationController {
    public ArrayList<Educations> educationList(ServerClient.CVMetaInfo request) throws Exception {
        EducationDAO educationDAO = new EducationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return educationDAO.readEducationList(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Educations educationRead(ServerClient.EducationFullInfo request) throws Exception {
        EducationDAO educationDAO = new EducationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Educations educations = educationDAO.readEducation(request, connection);
            connection.commit();
            return educations;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Educations educationUpdate(ServerClient.EducationFullInfo request) throws Exception {
        EducationDAO educationDAO = new EducationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Educations educations = educationDAO.updateEducation(request, connection);
            connection.commit();
            return educations;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Educations educationRegister(ServerClient.EducationFullInfo request) throws Exception {
        EducationDAO educationDAO = new EducationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Educations educations = educationDAO.registerEducation(request, connection);
            connection.commit();
            return educations;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean educationDelete(ServerClient.EducationFullInfo request) throws Exception {
        EducationDAO educationDAO = new EducationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (educationDAO.deleteEducation(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }

}
