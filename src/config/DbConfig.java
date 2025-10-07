package config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConfig {

    public static Connection getConnection() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("database.properties"));

            String url = properties.getProperty("DB_URL");
            String user = properties.getProperty("DB_USER");
            String password = properties.getProperty("DB_PASSWORD");

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }
}
