package DAO.extraServices;

import DAO.JdbcMysqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitiesByRegion {
    public List<String> getNumberOfCities() {
        List<String> result = new ArrayList<>();
        String query = "select region, count(name) from cities group by region";
        try (ResultSet rs = JdbcMysqlConnection.getInstance().getStmt().executeQuery(query)) {
            while (rs.next()) {
                String region = rs.getString(1);
                int count = rs.getInt(2);
                result.add(region + " - " + count);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}