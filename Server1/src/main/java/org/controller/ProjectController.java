package org.controller;

import org.DAO.ProjectDAO;
import org.connectConfig.HikariDataSource;
import org.model.Projects;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;

public class ProjectController {
    public ArrayList<Projects> projectList(ServerClient.CVFullInfo request) throws Exception {
        ProjectDAO projectDAO = new ProjectDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return projectDAO.readProjectList(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Projects projectRead(ServerClient.ProjectFullInfo request) throws Exception {
        ProjectDAO projectDAO = new ProjectDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Projects project = projectDAO.readProject(request, connection);
            connection.commit();
            return project;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Projects projectUpdate(ServerClient.ProjectFullInfo request) throws Exception {
        ProjectDAO projectDAO = new ProjectDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Projects project = projectDAO.updateProject(request, connection);
            connection.commit();
            return project;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Projects projectRegister(ServerClient.ProjectFullInfo request) throws Exception {
        ProjectDAO projectDAO = new ProjectDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Projects project = projectDAO.registerProject(request, connection);
            connection.commit();
            return project;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean projectDelete(ServerClient.ProjectFullInfo request) throws Exception {
        ProjectDAO projectDAO = new ProjectDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (projectDAO.deleteProject(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }
}
