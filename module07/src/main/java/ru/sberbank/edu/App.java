package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WeatherCache weatherCache = new WeatherCache(new WeatherProvider());
        WeatherInfo weatherInfo1 = weatherCache.getWeatherInfo("Moscow");
        System.out.println(weatherInfo1.getDescription());
    }
}
