package DAO.extraServices;

import DAO.CityDAOImpl;
import model.City;
import java.util.Collections;
import java.util.List;

import static DAO.extraServices.Print.printCities;
import static DAO.extraServices.Print.printResultOfQuery;

public class Sorts {
    public void lexicographicSort() {
        List<City> cities = CityDAOImpl.getInstance().getCities();
        Collections.sort(cities, (c1, c2) -> c1.name.compareToIgnoreCase(c2.name));
        printCities(cities);
    }

    public void lexicographicSortInSQL() {
        printResultOfQuery( "select name, region, district, population, foundation from cities order by name");
    }

    public void districtAndNameSort() {
        List<City> cities = CityDAOImpl.getInstance().getCities();
        Collections.sort(cities, (o1, o2) -> {
            if (o1.district.equals(o2.district)) {
                return o1.name.compareTo(o2.name);
            }
            return o1.district.compareTo(o2.district);
        });
        printCities(cities);
    }

    public void districtAndNameSortInSQL() {
        printResultOfQuery("select name, region, district, population, foundation from cities order by district, name collate utf8_bin");
    }
}