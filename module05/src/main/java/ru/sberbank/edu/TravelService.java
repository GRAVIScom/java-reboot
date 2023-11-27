package ru.sberbank.edu;

import java.util.ArrayList;
import java.util.List;

/**
 * Travel Service.
 */
public class TravelService {

    // do not change type
    private final List<CityInfo> cities = new ArrayList<>();
    private final int earthRadius = 6372795;

    /**
     * Append city info.
     *
     * @param cityInfo - city info
     * @throws IllegalArgumentException if city already exists
     */
    public void add(CityInfo cityInfo) {
        boolean cityExists = cities.stream()
                .anyMatch(city -> city.getName().equals(cityInfo.getName()));
        if (cityExists){
            throw new IllegalArgumentException("city" + cityInfo.getName() + "already exists in list");
        }
        else {
            cities.add(cityInfo);
        }
    }

    /**
     * remove city info.
     *
     * @param cityName - city name
     * @throws IllegalArgumentException if city doesn't exist
     */
    public void remove(String cityName) {
        boolean cityExists = cities.stream()
                .anyMatch(city -> city.getName().equals(cityName));
        if (cityExists){
            cities.removeIf(city -> city.getName().equals(cityName));
        }
        else {
            throw new IllegalArgumentException("city" + cityName + "not exists in list");
        }

    }

    /**
     * Get cities names.
     */
    public List<String> citiesNames() {
        return cities.stream().map(CityInfo::getName).toList();
    }

    /**
     * Get distance in kilometers between two cities.
     * https://www.kobzarev.com/programming/calculation-of-distances-between-cities-on-their-coordinates/
     *
     * @param srcCityName  - source city
     * @param destCityName - destination city
     * @throws IllegalArgumentException if source or destination city doesn't exist.
     */
    public int getDistance(String srcCityName, String destCityName) {
        CityInfo firstCity = cities.stream()
                .filter(cityInfo -> srcCityName.equals(cityInfo.getName()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

        CityInfo secondCity = cities.stream()
                .filter(cityInfo -> destCityName.equals(cityInfo.getName()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

        double cl1 = Math.cos(firstCity.getPosition().getLatitude());
        double sl1 = Math.sin(firstCity.getPosition().getLatitude());

        double cl2 = Math.cos(secondCity.getPosition().getLatitude());
        double sl2 = Math.sin(secondCity.getPosition().getLatitude());
        double delta = firstCity.getPosition().getLongitude() - secondCity.getPosition().getLongitude() ;
        double cdelta = Math.cos(delta);
        double sdelta = Math.sin(delta);

        // вычисления длины большого круга
        double y = Math.sqrt( Math.pow(cl2 * sdelta,2) + Math.pow(cl1 * sl2 - sl1 * cl2 * cdelta,2));
        double x = sl1 * sl2 + cl1 * cl2 * cdelta;

        double ad = Math.atan2(y, x);
        double dist = ad * earthRadius/1000.0;

        return (int)Math.ceil(dist);
    }

    /**
     * Get all cities near current city in radius.
     *
     * @param cityName - city
     * @param radius   - radius in kilometers for search
     * @throws IllegalArgumentException if city with cityName city doesn't exist.
     */
    public List<String> getCitiesNear(String cityName, int radius) {
        return cities.stream().filter(f -> ((this.getDistance(cityName, f.getName()) <= radius) && (!f.getName().equals(cityName)))).map(CityInfo::getName).toList();
    }
}
