package org.controller;

import org.DAO.JobRequestDAO;
import org.DAO.LocationDAO;
import org.connectConfig.HikariDataSource;
import org.model.JobRequests;
import org.model.Locations;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class LocationController {
    public ArrayList<Locations> locationList() throws Exception {
        LocationDAO locationDAO = new LocationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return locationDAO.readLocationList(connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Locations locationRead(ServerClient.LocationMetaInfo request) throws Exception {
        LocationDAO locationDAO = new LocationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Locations locations = locationDAO.readLocation(request, connection);
            JobRequestDAO jobRequestDAO = new JobRequestDAO();
            ConcurrentHashMap<Integer, Boolean> map = jobRequestDAO.readJobRequestIDs(locations, connection);
            locations.setCurrentJobRequest(map);
            connection.commit();
            return locations;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Locations locationUpdate(ServerClient.LocationFullInfo request) throws Exception {
        LocationDAO locationDAO = new LocationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Locations locations = locationDAO.updateLocation(request, connection);
            connection.commit();
            return locations;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Locations locationRegister(ServerClient.LocationFullInfo request) throws Exception {
        LocationDAO locationDAO = new LocationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Locations locations = locationDAO.registerLocation(request, connection);
            connection.commit();
            return locations;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean locationDelete(ServerClient.LocationMetaInfo request) throws Exception {
        LocationDAO locationDAO = new LocationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (locationDAO.deleteLocation(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }
}
