package org.controller;

import org.DAO.JobRequestDAO;
import org.connectConfig.HikariDataSource;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;

public class ApplyController {
    public Boolean CVApply(ServerClient.JobRequestFullInfo request) throws Exception {
        JobRequestDAO jobRequestDAO = new JobRequestDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (jobRequestDAO.applyCV(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public ArrayList<ServerClient.AppliesInfo> searchCV(ServerClient.JobRequestRestrict request) throws Exception {
        JobRequestDAO jobRequestDAO = new JobRequestDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return jobRequestDAO.searchCV(request, connection);
        }
        finally {
            if (connection != null) connection.close();
        }
    }
}
