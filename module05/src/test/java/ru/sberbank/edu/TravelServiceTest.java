package ru.sberbank.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TravelServiceTest {

    @Test
    void add() {
        TravelService travelService = new TravelService();
        travelService.add( new CityInfo("Санкт-Петербург", new GeoPosition("55(12'152'')","44(13'216'')")));
        assertEquals( travelService.citiesNames().get(0),"Санкт-Петербург");
    }

    @Test
    void remove() {
        TravelService travelService = new TravelService();
        travelService.add( new CityInfo("Санкт-Петербург", new GeoPosition("55(12'152'')","44(13'216'')")));
        travelService.add( new CityInfo("Москва", new GeoPosition("55(45'07'')","77(11'916'')")));
        travelService.remove("Москва");
        assertEquals( travelService.citiesNames().get(0),"Санкт-Петербург");
    }

    @Test
    void citiesNames() {
        TravelService travelService = new TravelService();
        travelService.add( new CityInfo("Санкт-Петербург", new GeoPosition("55(12'152'')","44(13'216'')")));
        travelService.add( new CityInfo("Москва", new GeoPosition("55(45'07'')","77(11'916'')")));
        List<String> cityNames = travelService.citiesNames();

        Assertions.assertTrue(cityNames.contains("Москва"));
        Assertions.assertTrue(cityNames.contains("Санкт-Петербург"));
    }

    @Test
    void getDistance() {
        TravelService travelService = new TravelService();
        travelService.add( new CityInfo("Санкт-Петербург", new GeoPosition("55(12'152'')","44(13'216'')")));
        travelService.add( new CityInfo("Москва", new GeoPosition("55(45'07'')","77(11'916'')")));

        assertEquals( travelService.getDistance("Санкт-Петербург","Москва" ),2071 );
    }

    @Test
    void getCitiesNear() {
        TravelService travelService = new TravelService();
        travelService.add( new CityInfo("Санкт-Петербург", new GeoPosition("55(12'152'')","44(13'216'')")));
        travelService.add( new CityInfo("Москва", new GeoPosition("55(45'07'')","77(11'916'')")));
        travelService.add( new CityInfo("Новосибирск", new GeoPosition("55(45'07'')","77(11'916'')")));
        assertEquals( travelService.getCitiesNear("Москва",100).get(0),"Новосибирск");
    }
}