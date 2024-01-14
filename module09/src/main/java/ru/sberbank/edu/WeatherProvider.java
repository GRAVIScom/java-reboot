package ru.sberbank.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * Weather provider
 */
public class WeatherProvider {
    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    @Value("${apikey}")
    private String apiKey;

    @Autowired
    public WeatherProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


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
