package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city); assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city); });
    }
    @Test void
    testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = mockCity();

        // Test that the city exists in the list
        assertTrue(cityList.hasCity(city));

        // Test that a city not in the list returns false
        City newCity = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(newCity));
    }

    // Test delete method - successful deletion
    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = mockCity();

        // Verify the city is in the list
        assertTrue(cityList.hasCity(city));
        assertEquals(1, cityList.countCities());

        // Delete the city
        cityList.delete(city);

        // Verify it was removed
        assertFalse(cityList.hasCity(city));
        assertEquals(0, cityList.countCities());
    }

    // Test delete method - exception when city not in list
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");

        // Verify the city is NOT in the list
        assertFalse(cityList.hasCity(city));

        // Try to delete a city that doesn't exist - should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    // Test countCities method
    @Test
    void testCountCities() {
        CityList cityList = new CityList();

        // Empty list should have 0 cities
        assertEquals(0, cityList.countCities());

        // Add one city
        cityList.add(new City("Toronto", "Ontario"));
        assertEquals(1, cityList.countCities());

        // Add another city
        cityList.add(new City("Montreal", "Quebec"));
        assertEquals(2, cityList.countCities());

        // Add a third city
        cityList.add(new City("Halifax", "Nova Scotia"));
        assertEquals(3, cityList.countCities());
    }
}



