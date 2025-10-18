package com.example.mywebapp.weather.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {

    DatabaseRepo repo;

    public UserService(DatabaseRepo repo){
        this.repo = repo;
    }

    public boolean checkIfExists(String username) throws SQLException {
        try{
            repo.select(username);
            return true;
        }catch (EmptyResultDataAccessException exception){
            return false;
        }
    }
}
