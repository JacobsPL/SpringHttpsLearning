package com.example.mywebapp.weather.models;

import java.util.Date;

public class User {

    int id;
    private final String username;
    private String password;
    Date date;

    public User(int id, String username, String password){
        this.id=id;
        this.username=username;
        this.password=password;
    }


    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
