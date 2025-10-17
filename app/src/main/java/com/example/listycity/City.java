package com.example.listycity;
/**
 * This is a class that defines a City.
 * @author Avyaan Gulati  */
public class City implements Comparable<City> {
    private String city;
    private String province;
    /**
     * Constructs a City object with the specified city name and province
     * @param city The name of the city
     * @param province The name of the province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     *gets the name of a city
     * @return city as an object
     */

    public String getCity() {
        return this.city;
    }
    /**
     *gets the name of a province
     * @return province as an object
     */
    public String getProvince() {
        return this.province;
    }

/**
 * Compares this city to another city
  * @param o The other City object to compare to
  * @return int
 * */

    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCity());

    }
}



