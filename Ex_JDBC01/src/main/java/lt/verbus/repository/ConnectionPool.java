package lt.verbus.repository;

import lt.verbus.config.MySqlConfig;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {

    private static Connection mySqlConnection = null;

    public static Connection getMySqlConnection() throws SQLException, IOException {

        try (InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("db.properties")) {

            Properties properties = new Properties();
            properties.load(input);

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }

        if (mySqlConnection == null) {
            mySqlConnection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password")
                    );
        }
        return mySqlConnection;
        }
    }

    public static void closeConnections() throws SQLException {
        mySqlConnection.close();
    }

}
