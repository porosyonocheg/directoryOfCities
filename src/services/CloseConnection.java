package services;

import DAO.JdbcMysqlConnection;

public class CloseConnection {
    public static void close() {
        JdbcMysqlConnection.getInstance().close();
    }
}