package com.example.mywebapp.weather;

import java.util.Date;

public class User {

    int id;
    String username;
    String password;
    Date date;

    public User(int id, String username, String password){
        this.id=id;
        this.username=username;
        this.password=password;
    }
}
