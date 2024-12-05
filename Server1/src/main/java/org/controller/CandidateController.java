package org.controller;

import org.DAO.CVDAO;
import org.DAO.CandidateDAO;
import org.DAO.UserDAO;
import org.checkerframework.checker.units.qual.C;
import org.connectConfig.HikariDataSource;
import org.model.Candidates;
import org.model.Users;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class CandidateController {
    public Candidates candidateCreate(ServerClient.CandidateFullInfo request) throws Exception {
        UserDAO userDAO = new UserDAO();
        CandidateDAO candidateDAO = new CandidateDAO();
        Users users = null;
        Candidates candidates = null;
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);

            users = userDAO.createUser(request, connection);
            if(users == null)   throw new Exception("Không tạo được User");

            candidates = candidateDAO.createCandidates(users, request, connection);
            if(candidates == null) throw new Exception("Không tạo được Candidate");

            connection.commit();
            return candidates;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Candidates candidateRead (ServerClient.UserMetaInfo request) throws Exception {
        CandidateDAO candidateDAO = new CandidateDAO();
        Candidates candidates;
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            candidates = candidateDAO.readCandidates(request, connection);
            CVDAO cvdao = new CVDAO();
            HashSet<Integer> hashSet = cvdao.readCVIDs(candidates, connection);
            candidates.setCurrentCVs(hashSet);
            return candidates;
        }
        finally {
            if(connection != null)   connection.close();
        }

    }

    public Candidates candidateUpdate (ServerClient.CandidateFullInfo request) throws SQLException {
        CandidateDAO candidateDAO = new CandidateDAO();
        Candidates candidates = new Candidates();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            candidates = candidateDAO.updateCandidates(request, connection);
            connection.commit();
            return candidates;
        }
        finally {
            if(connection != null)   connection.close();
        }
    }

    public ArrayList<Candidates> candidateList() throws SQLException {
        CandidateDAO candidateDAO = new CandidateDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return candidateDAO.readCandidateList(connection);
        }
        finally {
            if (connection != null) connection.close();
        }
    }
}
