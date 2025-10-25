package com.example.mywebapp.weather.Controllers;

import com.example.mywebapp.weather.service.DatabaseRepo;
import com.example.mywebapp.weather.WeatherDownloader;
import com.example.mywebapp.weather.WeatherResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WeatherController {

    private final WeatherDownloader weatherDownloader;
    private final DatabaseRepo databaseRepo;

    public WeatherController(WeatherDownloader weatherDownloader, DatabaseRepo databaseRepo) {
        this.weatherDownloader = weatherDownloader;
        this.databaseRepo = databaseRepo;
    }

    @GetMapping("/weather/city")
    public String city(@RequestParam String city, Model model) {
        weatherDownloader.getWeatherCached(city); // TUTAJ ZAPAMIETUJE PIERWSZE MIASTO, POTRZEBNY BĘDZIE JAKIŚ RETURN KTÓRY RESETUJE CACHE
        model.addAttribute("city",city);
        return "weather";
    }

    @GetMapping("/weather")
    public String showInputPage() {
        return "weatherInput";
    }

    @GetMapping("/weather/temp")
    @ResponseBody
    public String temp(@RequestParam String city){
        WeatherResponse response = weatherDownloader.getWeatherCached(city);
        return "Temperatura: " + response.getMain().getTemp() +
                "<br>Temperatura odczuwalna: "+ response.getMain().getFeels_like() +
                "<br>Temperatura minimalna w trakcie dnia: "+ response.getMain().getTemp_min() +
                "<br>Temperatura maxymalna w trakcie dnia: "+ response.getMain().getTemp_max();
    }

    @GetMapping("/weather/pressure")
    @ResponseBody
    public String pressure(@RequestParam String city){
        WeatherResponse response = weatherDownloader.getWeatherCached(city);
        return "Ciśnienie w "+city+" wynosi: " + response.getMain().getPressure() + " hPa"+
                "<br>Ciśnienie nad poziomem morza: "+ response.getMain().getGrnd_level() + " hPa";
    }

    @GetMapping("/weather/wind")
    @ResponseBody
    public String wind(@RequestParam String city){
        WeatherResponse response = weatherDownloader.getWeatherCached(city);
        return "Średnia prędkość wiatru: " + response.getMain().getPressure();
    }
}

// API dla POGODY https://api.openweathermap.org/data/2.5/weather?q=Warsaw&appid=9f3061db64e985f0cb61bfd1a67db8e7&units=metric