package com.example.mywebapp.weather;


import java.sql.*;

public class DataBaseControler {

    Connection connection;


    private final String dataBaseUrl = "jdbc:postgresql://localhost:5432/weather_db";
    private final String userName = "app_user";
    private final String passWord = "debian";

    public void connectDatabase(String dataBaseUrl, String userName, String passWord) throws SQLException {

       connection = DriverManager.getConnection(dataBaseUrl,userName,passWord);
            if (connection != null){
                System.out.println("Database connected [OK]");
            }else{
                System.out.println("Database connection error [ERROR]");
            }

    }

    public void closeDatabaseConnection() throws SQLException{
        connection.close();
    }

    public User select(int id) throws SQLException {

        String querry = "SELECT * FROM users WHERE id = ?;";
        PreparedStatement stmt = connection.prepareStatement(querry);
        stmt.setInt(1, id);
        User user = null;
        try (ResultSet resultSet = stmt.executeQuery()) {
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("pswrd_unprotected"));
            }
        }
        return user;
    }

    public void select (String username){
        Statement statement;
        ResultSet resultSet;


    }




}
