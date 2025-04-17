package org.controller;

import org.DAO.CertificationDAO;
import org.connectConfig.HikariDataSource;
import org.model.Certifications;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;

public class CertificationController {
    public ArrayList<Certifications> certificationList(ServerClient.CVFullInfo request) throws Exception {
        CertificationDAO certificationDAO = new CertificationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return certificationDAO.readCertificationList(request, connection);
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Certifications certificationRead(ServerClient.CertificationFullInfo request) throws Exception {
        CertificationDAO certificationDAO = new CertificationDAO();

        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Certifications certifications = certificationDAO.readCertification(request, connection);
            connection.commit();
            return certifications;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Certifications certificationUpdate(ServerClient.CertificationFullInfo request) throws Exception {
        CertificationDAO certificationDAO = new CertificationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Certifications certifications = certificationDAO.updateCertification(request, connection);
            connection.commit();
            return certifications;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Certifications certificationRegister(ServerClient.CertificationFullInfo request) throws Exception {
        CertificationDAO certificationDAO = new CertificationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            Certifications certifications = certificationDAO.registerCertification(request, connection);
            connection.commit();
            return certifications;
        }
        finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean certificationDelete(ServerClient.CertificationFullInfo request) throws Exception {
        CertificationDAO certificationDAO = new CertificationDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (certificationDAO.deleteCertification(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }
}
