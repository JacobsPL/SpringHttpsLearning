package com.example.mywebapp.weather.service;

import java.util.Date;

public class User {

    int id;
    private String username;
    private String password;
    Date date;

    public User(int id, String username, String password){
        this.id=id;
        this.username=username;
        this.password=password;
    }

    public static boolean checkIfExists(String username){
        final DatabaseRepo databaseRepo;
        User tempUser = databaseRepo.select(username);

        if(tempUser.getUsername() == null){
            return true;
        }
        return false;
    }

    public boolean isUserNull(){
        return this.username == null;
    }


    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
