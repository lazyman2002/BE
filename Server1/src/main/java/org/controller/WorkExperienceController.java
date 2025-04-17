package org.controller;

import org.DAO.WorkExperienceDAO;
import org.connectConfig.HikariDataSource;
import org.model.WorkExperiences;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;

public class WorkExperienceController {

    public ArrayList<WorkExperiences> workExperienceList(ServerClient.CVFullInfo request) throws Exception {
        WorkExperienceDAO workExperienceDAO = new WorkExperienceDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return workExperienceDAO.readWorkExperienceList(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public WorkExperiences workExperienceRead(ServerClient.WorkExperienceFullInfo request) throws Exception {
        WorkExperienceDAO workExperienceDAO = new WorkExperienceDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            WorkExperiences workExperience = workExperienceDAO.readWorkExperience(request, connection);
            connection.commit();
            return workExperience;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public WorkExperiences workExperienceUpdate(ServerClient.WorkExperienceFullInfo request) throws Exception {
        WorkExperienceDAO workExperienceDAO = new WorkExperienceDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            WorkExperiences workExperience = workExperienceDAO.updateWorkExperience(request, connection);
            connection.commit();
            return workExperience;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public WorkExperiences workExperienceRegister(ServerClient.WorkExperienceFullInfo request) throws Exception {
        WorkExperienceDAO workExperienceDAO = new WorkExperienceDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            WorkExperiences workExperience = workExperienceDAO.registerWorkExperience(request, connection);
            connection.commit();
            return workExperience;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean workExperienceDelete(ServerClient.WorkExperienceFullInfo request) throws Exception {
        WorkExperienceDAO workExperienceDAO = new WorkExperienceDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (workExperienceDAO.deleteWorkExperience(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }
}

