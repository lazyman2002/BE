package org.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.DAO.CandidatesDAO;
import org.DAO.RecruitersDAO;
import org.DAO.UsersDAO;
import org.connectConfig.HikariDataSource;
import spark.Session;


import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import static spark.Spark.*;

public class Main {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        port(3000);
        get("/hello", (req, res)->"Hello, world");

        // Đăng ký
        post("/register", (req, res) -> {
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
                if(userID == -1)    return "Không thêm thành công User";
                user.setUserID(userID);
//                user = usersDAO.loginUser(username, password);
                if(isCandidates){
                    CandidatesDAO candidatesDAO = new CandidatesDAO();
                    Candidates candidate = new Candidates(user);
                    candidate.setBirthDate(Date.valueOf(req.queryParams("birthDate")));
                    candidate.setGender(Gender.valueOf(req.queryParams("gender").toUpperCase()));
                    int candidateID = candidatesDAO.registerCandidates(candidate, connection);
                    if(candidateID == -1)   return "Không thêm thành công Candidate";
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
        });

        post("/login", (req, res) -> {
            UsersDAO usersDAO = new UsersDAO();
            String username = req.queryParams("username");
            String password =  req.queryParams("password");
            Users user = usersDAO.loginUser(username, password);
            if(user != null){
                System.out.println(user.toString());
                if(user.isCandidate()){
                    CandidatesDAO candidatesDAO = new CandidatesDAO();
                    Candidates candidate = candidatesDAO.loginCandidate(user);
                    Session session = req.session(true);
                    session.attribute("user", candidate);
                    res.status(200);
// Cần dẫn đến /Candidates
                    res.redirect("http://localhost:3000/hello");
//
                }
                else {
                    RecruitersDAO recruitersDAO = new RecruitersDAO();
                    Recruiters recruiter = recruitersDAO.loginRecruiter(user);
                    Session session = req.session(true);
                    session.attribute("user", recruiter);
                    res.status(200);

// Cần dẫn đến /Recruiters
                    res.redirect("http://localhost:3000/hello");
//
                }
            }
            return 0;
        });
    }
}