package com.example.project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size()
    private String vorn;
    private String nachn;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVorn() {
        return vorn;
    }

    public void setVorn(String vorn) {
        this.vorn = vorn;
    }

    public String getNachn() {
        return nachn;
    }

    public void setNachn(String nachn) {
        this.nachn = nachn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}

