package DAO.extraServices;

import DAO.JdbcMysqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CitiesByRegion {
    public void getNumberOfCities() {
        String query = "select region, count(name) from cities group by region";
        try (ResultSet rs = JdbcMysqlConnection.getInstance().getStmt().executeQuery(query)) {
            while (rs.next()) {
                String region = rs.getString(1);
                int count = rs.getInt(2);
                System.out.println(region + " - " + count);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}