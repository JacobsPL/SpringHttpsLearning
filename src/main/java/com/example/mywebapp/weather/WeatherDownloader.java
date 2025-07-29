package com.example.mywebapp.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class WeatherDownloader {

    private final RestTemplate restTemplate = new RestTemplate();
    private WeatherResponse cachedResponse;
    private final String apiKey = "9f3061db64e985f0cb61bfd1a67db8e7";
    private String city = "Warsaw";

    public WeatherResponse getWeatherCached(String city){
        if (cachedResponse == null){
            cachedResponse = getWeatherForCity(city);
        }
        return cachedResponse;
    }
    private WeatherResponse getWeatherForCity(String city){

        URI baseUri = UriComponentsBuilder
                .fromHttpUrl("https://api.openweathermap.org/data/2.5/weather")
                .queryParam("q",city)
                .queryParam("appid", apiKey)
                .queryParam("units","metric")
                .queryParam("lang","pl")
                .build()
                .toUri();
        return restTemplate.getForObject(baseUri, WeatherResponse.class);
    }

    public void refreshCache(String city){
        cachedResponse = getWeatherCached(city);
    }
}
