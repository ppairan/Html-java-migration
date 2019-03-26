package com.example.project.repository;

import com.example.project.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DbRepository {

    public User findbyid() {
        User user = new User();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "admin", "admin");
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM ITAM WHERE ID = ?");

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setVorn(rs.getString(2));
                user.setNachn(rs.getString(3));
                user.setDate(rs.getString(4));
            }

            stm.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }
        public List <User> findall() {
            ArrayList<User> users = new ArrayList<>();

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "admin", "admin");
                PreparedStatement stm = conn.prepareStatement("SELECT * FROM ITAM");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt(1));
                    u.setVorn(rs.getString(2));
                    u.setNachn(rs.getString(3));
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
}
