package org.controller;

import org.DAO.JobRequestDAO;
import org.DAO.BranchDAO;
import org.DAO.UserDAO;
import org.connectConfig.HikariDataSource;
import org.model.Branchs;
import org.model.Locations;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class BranchController {
    public ArrayList<Branchs> branchList() throws Exception {
        BranchDAO BranchDAO = new BranchDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return BranchDAO.readBranchList(connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Branchs branchRead(ServerClient.BranchFullInfo request) throws Exception {
        BranchDAO BranchDAO = new BranchDAO();
        UserDAO userDAO = new UserDAO();
        JobRequestDAO jobRequestDAO = new JobRequestDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Branchs locations = BranchDAO.readBranch(request, connection);
            ArrayList<Integer> map = jobRequestDAO.readJobRequestIDs(locations, connection);
            locations.setActiveJobs(new HashSet<>(map));

            ArrayList<Integer> recruiterList = userDAO.readRecruiterList(locations, connection);
            locations.setActiveRecruiters(new HashSet<>(recruiterList));
            connection.commit();
            return locations;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Branchs branchUpdate(ServerClient.BranchFullInfo request) throws Exception {
        BranchDAO branchDAO = new BranchDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Branchs locations = branchDAO.updateBranch(request, connection);
            connection.commit();
            return locations;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Branchs branchRegister(ServerClient.BranchFullInfo request) throws Exception {
        BranchDAO BranchDAO = new BranchDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Branchs locations = BranchDAO.registerBranch(request, connection);
            connection.commit();
            return locations;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean branchDelete(ServerClient.BranchFullInfo request) throws Exception {
        BranchDAO BranchDAO = new BranchDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (BranchDAO.deleteBranch(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }
}
