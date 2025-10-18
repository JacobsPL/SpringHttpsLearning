package com.example.mywebapp.weather.service;

import com.example.mywebapp.weather.models.User;
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

    public boolean authoriseUser(String login, String password) throws SQLException{

        if(checkIfExists(login)) {
            return true;
        }
        User tempUser = repo.select(login);
        boolean ok = tempUser.getUsername().equals(login) && tempUser.getPassword().equals(password);

        if (ok) {
            return true;
        } else {
            return false;
        }
    }

    public void changePassword(String newPassword, String login){
        repo.updateUserPassword(newPassword,login);
    }
}
