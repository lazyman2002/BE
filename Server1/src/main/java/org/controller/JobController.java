package org.controller;

import org.DAO.CVDAO;
import org.DAO.JobRequestDAO;
import org.connectConfig.HikariDataSource;
import org.model.Companies;
import org.model.JobRequests;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;

public class JobController {
    public JobRequests jobRequestRead(ServerClient.JobRequestMetaInfo request) throws Exception {
        JobRequestDAO jobRequestDAO = new JobRequestDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);

            JobRequests jobRequest = jobRequestDAO.readJobRequest(request, connection);
            CVDAO cvdao = new CVDAO();
            HashSet<Integer> hashSet = cvdao.readCVIDs(jobRequest, connection);
            jobRequest.setCurrentCVs(hashSet);

            connection.commit();
            return jobRequest;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public JobRequests jobRequestRegister(ServerClient.JobRequestFullInfo request) throws Exception {
        JobRequestDAO jobRequestDAO = new JobRequestDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            JobRequests jobRequest = jobRequestDAO.registerJobRequest(request, connection);
            connection.commit();
            return jobRequest;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public JobRequests jobRequestsUpdate(ServerClient.JobRequestFullInfo request) throws Exception {
        JobRequestDAO jobDAO = new JobRequestDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return jobDAO.updateJob(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean jobDelete(ServerClient.JobRequestMetaInfo request) throws Exception {
        JobRequestDAO jobRequestDAO = new JobRequestDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (jobRequestDAO.deleteJob(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public ArrayList<JobRequests> jobRequestsList() throws Exception {
        JobRequestDAO jobRequestDAO = new JobRequestDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return jobRequestDAO.readJobRequestList(connection);
        }
        finally {
            if (connection != null) connection.close();
        }
    }
}
