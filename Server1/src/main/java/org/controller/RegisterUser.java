package org.controller;

import org.DAO.CandidatesDAO;
import org.DAO.RecruitersDAO;
import org.DAO.UsersDAO;
import org.connectConfig.HikariDataSource;
import org.model.Candidates;
import org.model.Gender;
import org.model.Recruiters;
import org.model.Users;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class RegisterUser {
    public static Users register(Request req, Response res) {
        UsersDAO usersDAO = new UsersDAO();
        Connection connection = null;
        try {
            connection = HikariDataSource.getConnection();
            connection.setAutoCommit(false);
            String username = req.queryParams("username");
            String password =  req.queryParams("password");
            String email = req.queryParams("email");
            Boolean isCandidates = Boolean.parseBoolean(req.queryParams("isCandidate"));
            Users user = new Users(username, password, isCandidates, email);
            int userID = usersDAO.registerUser(user, connection);
            if(userID == -1) return null;
            user.setUserID(userID);
//                user = usersDAO.loginUser(username, password);
            if(isCandidates){
                CandidatesDAO candidatesDAO = new CandidatesDAO();
                Candidates candidate = new Candidates(user);
                candidate.setBirthDate(Date.valueOf(req.queryParams("birthDate")));
                candidate.setGender(Gender.valueOf(req.queryParams("gender").toUpperCase()));
                int candidateID = candidatesDAO.registerCandidates(candidate, connection);
                if(candidateID == -1) return null;
                candidate.setCandidateID(candidateID);
                System.out.println(candidate.toString());

                connection.commit();
//                  chuyển đến login
//                    candidatesDAO.loginCandidate(candidate);
                return null;
            }
            else {
                RecruitersDAO recruitersDAO = new RecruitersDAO();
                Recruiters recruiter = new Recruiters(user);
                recruiter.setCompaniesID(Integer.parseInt(req.queryParams("companyID")));
                recruiter.setRoleID(Integer.parseInt(req.queryParams("roleID")));
                recruiter.setDepartmentName(req.queryParams("departmentName"));
                int recruiterID = recruitersDAO.registerRecruiters(recruiter, connection);
                recruiter.setRecruiterID(recruiterID);
                System.out.println(recruiter.toString());
                connection.commit();
//                  chuyển đến login
//                    recruitersDAO.loginRecruiter(recruiter);
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
