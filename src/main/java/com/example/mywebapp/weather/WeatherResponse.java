package com.example.mywebapp.weather;

import com.example.mywebapp.weather.jsonresponse.Coord;
import com.example.mywebapp.weather.jsonresponse.Main;
import com.example.mywebapp.weather.jsonresponse.Weather;

import java.util.List;

public class WeatherResponse {

    private Coord coord;
    private Main main;
    private String name;
    private List<Weather> weather;

    public Main getMain() {return main;}
    public String getName() {return name;}
    public Coord getCoord() {return coord;}
    public List<Weather> getWeather() {return weather;}

}
