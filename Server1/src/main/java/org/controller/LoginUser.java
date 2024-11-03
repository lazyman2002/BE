package org.controller;

import org.DAO.CandidatesDAO;
import org.DAO.RecruitersDAO;
import org.DAO.UsersDAO;
import org.model.Candidates;
import org.model.Recruiters;
import org.model.Users;
import spark.Request;
import spark.Response;
import spark.Session;

public class LoginUser {
    public static Users login(Request req, Response res) {
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
        return null;
    }
}
