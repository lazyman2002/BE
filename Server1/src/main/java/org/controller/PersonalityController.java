package org.controller;

import org.DAO.PersonalityDAO;
import org.connectConfig.HikariDataSource;
import org.model.Personalities;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;

public class PersonalityController {

    public ArrayList<Personalities> personalityList(ServerClient.CVMetaInfo request) throws Exception {
        PersonalityDAO personalityDAO = new PersonalityDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return personalityDAO.readPersonalityList(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Personalities personalityRead(ServerClient.PersonalityFullInfo request) throws Exception {
        PersonalityDAO personalityDAO = new PersonalityDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Personalities personality = personalityDAO.readPersonality(request, connection);
            connection.commit();
            return personality;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Personalities personalityUpdate(ServerClient.PersonalityFullInfo request) throws Exception {
        PersonalityDAO personalityDAO = new PersonalityDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Personalities personality = personalityDAO.updatePersonality(request, connection);
            connection.commit();
            return personality;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Personalities personalityRegister(ServerClient.PersonalityFullInfo request) throws Exception {
        PersonalityDAO personalityDAO = new PersonalityDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Personalities personality = personalityDAO.registerPersonality(request, connection);
            connection.commit();
            return personality;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean personalityDelete(ServerClient.PersonalityFullInfo request) throws Exception {
        PersonalityDAO personalityDAO = new PersonalityDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (personalityDAO.deletePersonality(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }
}
