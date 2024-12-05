package org.controller;

import org.DAO.SkillDAO;
import org.connectConfig.HikariDataSource;
import org.model.Skills;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;

public class SkillController {
    public ArrayList<Skills> skillList(ServerClient.CVMetaInfo request) throws Exception {
        SkillDAO SkillDAO = new SkillDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return SkillDAO.readSkillsList(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Skills skillRead(ServerClient.SkillFullInfo request) throws Exception {
        SkillDAO SkillDAO = new SkillDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Skills skills = SkillDAO.readSkill(request, connection);
            connection.commit();
            return skills;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Skills skillUpdate(ServerClient.SkillFullInfo request) throws Exception {
        SkillDAO SkillDAO = new SkillDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Skills skills = SkillDAO.updateSkill(request, connection);
            connection.commit();
            return skills;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Skills skillRegister(ServerClient.SkillFullInfo request) throws Exception {
        SkillDAO SkillDAO = new SkillDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Skills skills = SkillDAO.registerSkill(request, connection);
            connection.commit();
            return skills;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean skillDelete(ServerClient.SkillFullInfo request) throws Exception {
        SkillDAO SkillDAO = new SkillDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (SkillDAO.deleteSkill(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }

}
