package DAO.extraServices;

import DAO.CityDAOImpl;
import model.City;
import java.util.Collections;
import java.util.List;

public class Sorts {
    public List<City> lexicographicSort() {
        List<City> cities = CityDAOImpl.getInstance().getCities();
        Collections.sort(cities, (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return cities;
    }

    public List<String> lexicographicSortInSQL() {
        return Results.getResultOfQuery(( "select name, region, district, population, foundation from cities order by name"));
    }

    public List<City> districtAndNameSort() {
        List<City> cities = CityDAOImpl.getInstance().getCities();
        Collections.sort(cities, (o1, o2) -> {
            if (o1.getDistrict().equals(o2.getDistrict())) {
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getDistrict().compareTo(o2.getDistrict());
        });
        return cities;
    }

    public List<String> districtAndNameSortInSQL() {
        return Results.getResultOfQuery("select name, region, district, population, foundation from cities order by district, name collate utf8_bin");
    }
}