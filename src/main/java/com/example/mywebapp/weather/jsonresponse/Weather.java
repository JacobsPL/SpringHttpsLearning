package com.example.mywebapp.weather.jsonresponse;

public class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String getMain() {
        return main;
    }

    public int getId() {
        return id;
    }
}
