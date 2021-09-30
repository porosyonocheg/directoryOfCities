package services;


import DAO.CityDAOImpl;
import model.City;

import java.util.List;

public class Print {
    public static void printListOfStrings(List<String> result) {
        for (String s : result) System.out.println(s);
    }

    public static void printListofCities(List<City> cities) {
        for (City c : cities) System.out.println(c.toString());
    }
    public static void printListOfCities() {
        for (City city : CityDAOImpl.getInstance().getCities()) System.out.println(city);
    }
    public static void printString(String s) {
        System.out.println(s);
    }
}