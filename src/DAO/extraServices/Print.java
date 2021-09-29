package DAO.extraServices;

import DAO.CityDAOImpl;
import DAO.JdbcMysqlConnection;
import model.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Print {
    public static void printCities() {
        for (City city : CityDAOImpl.getInstance().getCities()) System.out.println(city);
    }

    protected static void printCities(List<City> cities) {
        for (City city : cities) System.out.println(city);
    }

    protected static void printResultOfQuery(String query) {
        try (ResultSet rs = JdbcMysqlConnection.getInstance().getStmt().executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("name");
                String region = rs.getString("region");
                String district = rs.getString("district");
                int population = rs.getInt("population");
                int foundation = rs.getInt("foundation");
                System.out.println("City{" +
                        "name='" + name + '\'' +
                        ", region='" + region + '\'' +
                        ", district='" + district + '\'' +
                        ", population=" + population +
                        ", foundation=" + foundation +
                        '}');
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}