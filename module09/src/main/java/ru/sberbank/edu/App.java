package ru.sberbank.edu;

import Config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        WeatherCache cache = context.getBean(WeatherCache.class);

        WeatherInfo weatherInfo = cache.getWeatherInfo("Moscow");
        System.out.println("Weather=" + weatherInfo);
    }
}
