package org.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.controller.LoginUser;
import org.controller.RegisterCompany;
import org.controller.RegisterUser;
import org.controller.UpdateCompany;
import org.model.Users;

import static spark.Spark.*;

public class Main {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        port(3000);
        get("/hello", (req, res)->"Hello, world");

//      Đăng ký người dùng
        post("/user/register", (req, res) -> {
//            Check User
            Users user = RegisterUser.register(req, res);
            if(user == null){
                res.redirect("/hello");
            }
            else {
                res.redirect("/hello2");
            }
            return user;
        });
//      Đăng nhập người dùng
        post("/user/login", (req, res) -> {
            Users user = LoginUser.login(req, res);
            return 0;
        });


//      Đăng ký công ty
        post("/company/register", (req, res) -> {
            System.out.println("/company/register");
            RegisterCompany registerCompany = new RegisterCompany();
            registerCompany.registerCompany(req, res);
            return 1;
        });
//      Chỉnh sửa công ty
        post("/company/update", (req, res) ->{
            System.out.println("/company/update");
            UpdateCompany updateCompany = new UpdateCompany();
            updateCompany.updateCompany(req, res);
            return 1;
        });
    }

}