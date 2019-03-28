package com.example.project.Services;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class AppService {


    public String server() {
        boolean b = false;
        try {

            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "root", "");
            conn.close();
            b = true;
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);

        }
        if(b) return "true";

        return "false";

    }
}
