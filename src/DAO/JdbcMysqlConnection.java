package DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcMysqlConnection {
    private static JdbcMysqlConnection jdbcMysqlConnection;
    private String url;
    private String user;
    private String password;
    private Connection con;
    private Statement stmt;

    private JdbcMysqlConnection() {
        try (FileInputStream fis = new FileInputStream("src/DAO/connection.properties")) {
            Properties p = new Properties();
            p.load (fis);
            url = (String) p.get("jdbc.url");
            user = (String) p.get("jdbc.user");
            password = (String) p.get("jdbc.password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JdbcMysqlConnection getInstance() {
            if (jdbcMysqlConnection == null) {
                jdbcMysqlConnection = new JdbcMysqlConnection();
            }
        return jdbcMysqlConnection;
    }

    public Statement getStmt() {
        return stmt;
    }

    public PreparedStatement getPreparedStatement(String query) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    public void close() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}