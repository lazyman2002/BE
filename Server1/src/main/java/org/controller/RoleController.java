package org.controller;

import org.DAO.RoleDAO;
import org.connectConfig.HikariDataSource;
import org.model.Roles;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;


public class RoleController {
    public ArrayList<Roles> roleList(ServerClient.CompanyMetaInfo request) throws Exception {
        RoleDAO roleDAO = new RoleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return roleDAO.readRoleList(request, connection);
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Roles roleRead(ServerClient.RoleFullInfo request) throws Exception {
        RoleDAO roleDAO = new RoleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Roles roles = roleDAO.readRole(request, connection);
            connection.commit();
            return roles;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Roles rolesUpdate(ServerClient.RoleFullInfo request) throws Exception{
        RoleDAO roleDAO = new RoleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Roles roles =  roleDAO.updateRole(request, connection);
            connection.commit();
            return roles;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Roles roleRegister(ServerClient.RoleFullInfo request) throws Exception {
        RoleDAO roleDAO = new RoleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Roles roles = roleDAO.registerRole(request, connection);
            connection.commit();
            return roles;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean roleDelete(ServerClient.RoleFullInfo request) throws Exception {
        RoleDAO roleDAO = new RoleDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (roleDAO.deleteRole(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }
}
