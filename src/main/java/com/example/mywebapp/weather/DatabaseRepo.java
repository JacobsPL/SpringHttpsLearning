package com.example.mywebapp.weather;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DatabaseRepo {

    Connection connection;

    private final JdbcTemplate jdbc;

    public DatabaseRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public User select(String username) throws SQLException {
        String querry = "SELECT * FROM users WHERE username = ?;";

        return jdbc.query(querry, new ResultSetExtractor<User>() {
            User user = null;

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user = new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("pswrd_unprotected"));
                }
                return user;
            }
        }, username);
    }
}