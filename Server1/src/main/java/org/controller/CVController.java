package org.controller;

import org.DAO.*;
import org.connectConfig.HikariDataSource;
import org.model.CVs;
import proto.ServerClient;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;

public class CVController {
    public ArrayList<CVs> cvList(ServerClient.UserMetaInfo request) throws Exception {
        CVDAO cvDAO = new CVDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            return cvDAO.readCVList(request, connection);
        } finally {
            if (connection != null) connection.close();
        }
    }

    public CVs cvRead(ServerClient.CVMetaInfo request) throws Exception {
        CVDAO cvDAO = new CVDAO();
        CertificationDAO certificationDAO = new CertificationDAO();
        EducationDAO educationDAO = new EducationDAO();
        WorkExperienceDAO workExperienceDAO = new WorkExperienceDAO();
        SkillDAO skillDAO = new SkillDAO();
        PersonalityDAO personalityDAO= new PersonalityDAO();

        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            CVs cv = cvDAO.readCV(request, connection);

            HashSet<Integer> certificationIDs = certificationDAO.readCertificationIDs(cv.getCVID(), connection);
            if(!certificationIDs.isEmpty()) cv.setCurrentCertifications(certificationIDs);

            HashSet<Integer> educationIDs = educationDAO.readEducationIDs(cv.getCVID(), connection);
            if(!educationIDs.isEmpty()) cv.setCurrentEducations(educationIDs);

            HashSet<Integer> personalityIDs = personalityDAO.readPersonalityIDs(cv.getCVID(), connection);
            if(!personalityIDs.isEmpty())   cv.setCurrentPersonalities(personalityIDs);

            HashSet<Integer> skillIDs = skillDAO.readSkillIDs(cv.getCVID(), connection);
            if(!skillIDs.isEmpty()) cv.setCurrentSkills(skillIDs);

            HashSet<Integer> workExperienceIDs = workExperienceDAO.readWorkExperienceIDs(cv.getCVID(), connection);
            if(!workExperienceIDs.isEmpty())    cv.setCurrentWorkExperiences(workExperienceIDs);

            connection.commit();
            return cv;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public CVs cvUpdate(ServerClient.CVFullInfo request) throws Exception {
        CVDAO cvDAO = new CVDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            CVs cv = cvDAO.updateCV(request, connection);
            connection.commit();
            return cv;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public CVs cvRegister(ServerClient.CVFullInfo request) throws Exception {
        CVDAO cvDAO = new CVDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            CVs cv = cvDAO.registerCV(request, connection);
            connection.commit();
            return cv;
        } finally {
            if (connection != null) connection.close();
        }
    }

    public Boolean cvDelete(ServerClient.CVMetaInfo request) throws Exception {
        CVDAO cvDAO = new CVDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            if (cvDAO.deleteCV(request, connection)) {
                connection.commit();
                return true;
            }
            return false;
        } finally {
            if (connection != null) connection.close();
        }
    }

}
