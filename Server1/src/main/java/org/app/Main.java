package org.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import static spark.Spark.get;

public class Main {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        get("/hello", (req, res)->"Hello, world");
    }
}