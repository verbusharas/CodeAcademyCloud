package lt.verbus.services;

import lt.verbus.databases.Database;
import lt.verbus.databases.QueriesMySql;
import lt.verbus.model.Executor;

import java.sql.*;
import java.util.List;

public class ExecutorCrudService implements CrudService<Executor>{

    private Database database;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public ExecutorCrudService(Database database) throws SQLException {
        this.database = database;
        connection = database.getConnection();
        statement = connection.createStatement();
    }

    @Override
    public List<Executor> findAll() throws SQLException {
        ResultSet table = statement.executeQuery(QueriesMySql.ALL_EXECUTORS);
        TableConverter<Executor> tableConverter = new TableConverter<>(table,"id", "full_name");
        List<Executor> executorList = tableConverter.convertToList();
        statement.close();
        return executorList;
    }

    @Override
    public void save(Executor executor) {

    }

    @Override
    public void update(Executor executor, String[] params) {

    }

    @Override
    public void delete(Executor executor) {

    }
}
