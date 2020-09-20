package lt.verbus.repository;

import lt.verbus.config.MySqlConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

    private static Connection mySqlConnection = null;

    public static Connection getMySqlConnection() throws SQLException {
        if (mySqlConnection == null) {
            mySqlConnection = DriverManager.getConnection(
                    MySqlConfig.SQL_URL,
                    MySqlConfig.SQL_USERNAME,
                    MySqlConfig.SQL_PASSWORD);
        }
        return mySqlConnection;
    }

    public static void closeConnections() throws SQLException {
        mySqlConnection.close();
    }

}
