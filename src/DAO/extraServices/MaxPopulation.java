package DAO.extraServices;

import DAO.CityDAOImpl;
import model.City;

import java.util.List;

public class MaxPopulation {
    public String getMaxPopulation() {
        int[] arr = new int[]{0,-1}; //arr[0] - indexOfCityWithMaxPopulation, arr[1] - maxPopulation
        List<City> cities = CityDAOImpl.getInstance().getCities();
        for (int i = 0; i < cities.size(); i++) {
            int cur = cities.get(i).getPopulation();
            if (cur > arr[1]) {
                arr[1] = cur;
                arr[0] = i;
            }
        }
        return "[" + arr[0] + "] = " + arr[1];
    }
}