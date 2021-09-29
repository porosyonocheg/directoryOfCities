package DAO.extraServices;

import DAO.CityDAOImpl;
import model.City;

import java.util.List;

public class MaxPopulation {
    public void getMaxPopulation() {
        int maxPopulation = 0, maxIndex = -1;
        List<City> cities = CityDAOImpl.getInstance().getCities();
        for (int i = 0; i < cities.size(); i++) {
            int cur = cities.get(i).population;
            if (cur > maxPopulation) {
                maxPopulation = cur;
                maxIndex = i;
            }
        }
        System.out.println("[" + maxIndex + "] = " + maxPopulation);
    }
}