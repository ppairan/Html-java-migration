package com.example.project.repository;

import com.example.project.model.Table;
import com.example.project.model.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 //CREATE TABLE praktikum(ID Integer(5) NOT NULL AUTO_INCREMENT, vorname VARCHAR(20) NOT NULL,Nachname VARCHAR(20) NOT NULL,CREATED_DATE DATETIME DEFAULT CURRENT_TIMESTAMP ,PRIMARY KEY (USER_ID)); <-- Copy & Paste für PHPMYADMIN
@Component
public class AppRepository {

    public List<User> findall() {
        ArrayList<User> users = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "root", "");
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM ITAM");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1)-14);
                u.setVorname(rs.getString(2));
                u.setNachname(rs.getString(3));
                u.setDate(rs.getString(4));
                users.add(u);
            }

            stm.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    public void addUser(User user) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "root", "");
            PreparedStatement stm = conn.prepareStatement("insert into itam (vorname,Nachname ) values ( ?, ?)");

            stm.setString(1, user.getVorname());
            stm.setString(2, user.getNachname());


            stm.execute();
            stm.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public List<Table> tableview() {
        ArrayList<Table> t = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "root", "");
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                Table ta = new Table();
                ta.setName(rs.getString(3));
                t.add(ta);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return t;
    }
}



