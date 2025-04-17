package org.controller;

import org.DAO.AwardDAO;
import org.connectConfig.HikariDataSource;
import org.model.Awards;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AwardController {
    public ArrayList<Awards> awardList(ServerClient.CVFullInfo request) throws Exception {
        AwardDAO awardsDAO = new AwardDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return awardsDAO.readAwardList(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Awards awardRead(ServerClient.AwardFullInfo request) throws Exception {
        AwardDAO awardsDAO = new AwardDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Awards awards = awardsDAO.readAward(request, connection);
            connection.commit();
            return awards;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Awards awardUpdate(ServerClient.AwardFullInfo request) throws Exception {
        AwardDAO awardsDAO = new AwardDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Awards awards = awardsDAO.updateAward(request, connection);
            connection.commit();
            return awards;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Awards awardRegister(ServerClient.AwardFullInfo request) throws Exception {
        AwardDAO awardsDAO = new AwardDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Awards awards = awardsDAO.registerAward(request, connection);
            connection.commit();
            return awards;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean awardDelete(ServerClient.AwardFullInfo request) throws Exception {
        AwardDAO awardsDAO = new AwardDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (awardsDAO.deleteAward(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }
}
