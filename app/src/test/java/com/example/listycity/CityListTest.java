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
        assertTrue(cityList.hasCity(city));
        City newCity = new City("Edmonton", "Alberta");
        assertFalse(cityList.hasCity(newCity));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = mockCity();
        assertTrue(cityList.hasCity(city));
        assertEquals(1, cityList.countCities());
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Kelowna", "British Columbia");
        assertFalse(cityList.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    // LLM Was used to get the testCountCities
    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        cityList.add(new City("Toronto", "Ontario"));
        assertEquals(1, cityList.countCities());

        // Add another city
        cityList.add(new City("Montreal", "Quebec"));
        assertEquals(2, cityList.countCities());
        cityList.add(new City("Halifax", "Nova Scotia"));
        assertEquals(3, cityList.countCities());
    }
}



