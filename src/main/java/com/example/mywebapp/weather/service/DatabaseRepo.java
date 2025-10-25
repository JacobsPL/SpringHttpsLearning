package com.example.mywebapp.weather.service;


import com.example.mywebapp.weather.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class DatabaseRepo {

    private final JdbcTemplate jdbc;

    public DatabaseRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public User select(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?;";
        return jdbc.query(query, rs -> {
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("pswrd_unprotected"));

            }
            return null;
        },username);
    }

    public void insetIntoUser(String username, String password){
        String querry = "INSERT INTO users (username,pswrd_unprotected) values(?,?);";
        jdbc.update(querry);
    }

    public void updateUserPassword(String newPassword, String username){
        String querry = "UPDATE users SET pswrd_unprotected = ? WHERE username = ?;";
        jdbc.update(querry);
    }
}