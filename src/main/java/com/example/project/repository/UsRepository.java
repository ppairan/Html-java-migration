package com.example.project.repository;

import com.example.project.model.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Component
public class UsRepository {

    public void addUser(User user){

        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum", "root", "");
            PreparedStatement stm = conn.prepareStatement("insert into itam (vorname,Nachname,CREATED_DATE ) values ( ?, ?,?)");

            stm.setString(1,user.getVorn());
            stm.setString(2,user.getNachn());
            stm.setString(3,user.getDate());

            stm.execute();
            stm.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}
