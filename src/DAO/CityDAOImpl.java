package DAO;

import model.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CityDAOImpl implements CityDAO {
    private final JdbcMysqlConnection jdbcMysqlConnection;
    private static CityDAOImpl cityDAO;
    private CityDAOImpl() {
        jdbcMysqlConnection = JdbcMysqlConnection.getInstance();
    }

    public static CityDAOImpl getInstance() {
        if (cityDAO == null) cityDAO = new CityDAOImpl();
        return cityDAO;
    }

    @Override
    public List<City> getCities() {
        List<City> cityList = new ArrayList<>();
        String query = "select id, name, region, district, population, foundation from cities";
        try (ResultSet rs = jdbcMysqlConnection.getStmt().executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("region");
                String district = rs.getString("district");
                int population = rs.getInt("population");
                int foundation = rs.getInt("foundation");
                cityList.add(new City(id, name, region, district, population, foundation));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public void addDataToDB(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String[] cities = br.readLine().split(";");
        Set<Integer> ids = new HashSet<>();
        for (City c : getCities()) {
            ids.add(c.id);
        }
        List<City> list = new ArrayList<>();
        for (int i = 0; i < cities.length;) {
            int id = Integer.parseInt(cities[i++]);
            if (ids.contains(id)) {
                i += 5;
                continue;
            }
            String name = cities[i++];
            String region = cities[i++];
            String district = cities[i++];
            int population = Integer.parseInt(cities[i++]);
            int foundation = Integer.parseInt(cities[i++]);
            list.add(new City(id, name, region, district, population, foundation));
        }
        String query = "INSERT INTO cities (id, name, region, district, population, foundation)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = jdbcMysqlConnection.getPreparedStatement(query);
            for (City c : list) {
                preparedStatement.setInt(1, c.id);
                preparedStatement.setString(2, c.name);
                preparedStatement.setString(3, c.region);
                preparedStatement.setString(4, c.district);
                preparedStatement.setInt(5, c.population);
                preparedStatement.setInt(6, c.foundation);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}