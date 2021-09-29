package services;

import DAO.CityDAOImpl;

import java.io.IOException;

public class AddDataFromFile {

    public static void add(String file) throws IOException {
        CityDAOImpl.getInstance().addDataToDB(file);
    }
}