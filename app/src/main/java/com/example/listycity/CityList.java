package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 * @author Avyaan Gulati
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city This is a candidate city to add
     * @throws IllegalArgumentException if the city already exists in the list
     * @see City
     */

    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();   }
        cities.add(city);   }
    /**
     * This returns a sorted list of cities
     * @return  Return the sorted list */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Check if a city exists in the list
     * @param city The city to check for
     * @return true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Delete a city from the list
     * @param city The city to remove
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Return the number of cities in the list
     * @return The count of cities
     */
    public int countCities() {
        return cities.size();
    }
}
