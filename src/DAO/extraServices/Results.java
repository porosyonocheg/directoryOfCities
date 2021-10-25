package DAO.extraServices;

import DAO.JdbcMysqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Results {

    protected static List<String> getResultOfQuery(String query) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = JdbcMysqlConnection.getInstance().getStmt().executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("name");
                String region = rs.getString("region");
                String district = rs.getString("district");
                int population = rs.getInt("population");
                int foundation = rs.getInt("foundation");
                result.add("City{" +
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
        return result;
    }
}