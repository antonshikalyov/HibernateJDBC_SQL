package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDriver {
    private static final String URL = "jdbc:mysql://localhost:3306/db_shop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;

    public DBDriver() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()){
                System.out.println("Соединение с БД установлено!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить драйвер!");
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
