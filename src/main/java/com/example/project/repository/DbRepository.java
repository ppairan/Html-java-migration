package com.example.project.repository;

import com.example.project.model.User;
import com.example.project.model.tables;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbRepository {

    /*public User findbyid() {
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
    }*/
        public List <User> findall() {
            ArrayList<User> users = new ArrayList<>();

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "root", "");
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

    public List <tables> tableview(){
            ArrayList<tables> t = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "root", "");
//                PreparedStatement stm = conn.prepareStatement("SELECT TABLES FROM Praktikum");
            DatabaseMetaData dmd = conn.getMetaData();
            ResultSet rs1 = dmd.getSchemas();
            while(rs1.next()){

                String ss = rs1.getString(1);
                ResultSet rs2 = dmd.getTables(null,ss,"%",null);
                while(rs2.next()){
                    System.out.println(rs2.getString(3));
                    tables ta =new tables();
                    ta.setName(rs2.getString(3));
                    t.add(ta);
                }

            }
        }catch(SQLException e){
            System.out.println(e);
        }return t;
    }
}



