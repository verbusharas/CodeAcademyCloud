package lt.verbus.databases;

import lt.verbus.config.MySqlConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMySql implements Database {

    private static DatabaseMySql databaseMySql;
    private static Connection connection = null;

    private DatabaseMySql() throws SQLException {
        connection = DriverManager.getConnection(
                MySqlConfig.SQL_URL,
                MySqlConfig.SQL_USERNAME,
                MySqlConfig.SQL_PASSWORD);
    }


    public static DatabaseMySql getInstance() throws SQLException {
        if (databaseMySql == null)
            databaseMySql = new DatabaseMySql();
        return databaseMySql;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() throws SQLException {
            connection.close();
        }
    }
