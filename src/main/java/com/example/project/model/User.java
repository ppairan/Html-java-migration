package com.example.project.model;

public class User {

    private Integer id;
    private String vorn;
    private String nachn;
    private String date;

    public User(){

    }

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

