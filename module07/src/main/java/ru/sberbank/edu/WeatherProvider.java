package ru.sberbank.edu;

import org.springframework.web.client.RestTemplate;

public class WeatherProvider {

    private static final String apiKey = "4ee05183c01965c7857d71d9ef4005e4";
    private static final String url = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}";
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    public WeatherInfo get(String city) {
        return restTemplate.getForObject(url, WeatherInfo.class, city, apiKey);
    }
}
