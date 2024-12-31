package org.controller;

import org.DAO.CompanyDAO;
import org.DAO.LocationDAO;
import org.DAO.UserDAO;
import org.connectConfig.HikariDataSource;
import org.model.Companies;
import proto.ServerClient;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class CompanyController {
    public ArrayList<Companies> companyList() throws Exception {
        CompanyDAO companyDAO = new CompanyDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return companyDAO.readCompanyList(connection);
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Companies companyRead(ServerClient.CompanyMetaInfo request) throws Exception {
        CompanyDAO companyDAO = new CompanyDAO();
        UserDAO userDAO = new UserDAO();
        LocationDAO locationDAO = new LocationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Companies companies = companyDAO.readCompany(request, connection);
            ArrayList<Integer> locationList = locationDAO.readLocationList(companies, connection);
            companies.setActiveLocations(new HashSet<>(locationList));
            ArrayList<Integer> recruiterList = userDAO.readRecruiterList(companies, connection);
            companies.setActiveRecruiters(new HashSet<>(recruiterList));
            return companies;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Companies companyRegister(ServerClient.CompanyFullInfo request) throws Exception {
        CompanyDAO companyDAO = new CompanyDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Companies companies = companyDAO.registerCompany(request, connection);
            connection.commit();
            return companies;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Companies companyUpdate(ServerClient.CompanyFullInfo request) throws Exception {
        CompanyDAO companyDAO = new CompanyDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Companies companies = companyDAO.updateCompany(request, connection);
            connection.commit();
            return companies;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean companyDelete(ServerClient.CompanyMetaInfo request) throws Exception {
        CompanyDAO companyDAO = new CompanyDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if(companyDAO.deleteCompany(request, connection)){
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if(connection != null)   connection.close();
        }
    }
}
