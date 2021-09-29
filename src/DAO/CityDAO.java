package DAO;

import model.City;

import java.io.IOException;
import java.util.List;

public interface CityDAO {
    List<City> getCities();
    void addDataToDB(String file) throws IOException;
}