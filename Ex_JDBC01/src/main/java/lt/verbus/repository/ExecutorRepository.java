package lt.verbus.repository;

import lt.verbus.config.QueriesMySql;
import lt.verbus.model.Executor;
import lt.verbus.model.Project;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ExecutorRepository implements CrudRepository<Integer, Executor> {

    private final Connection connection;
    private final Statement statement;
    private PreparedStatement preparedStatement;

    public ExecutorRepository(Connection connection) throws SQLException {
        this.connection = ConnectionPool.getMySqlConnection();
        this.statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
    }

    @Override
    public Map<Integer, Executor> findAll() throws SQLException {
        ResultSet table = statement.executeQuery(QueriesMySql.ALL_EXECUTORS);
        Map<Integer, Executor> executors = convertTableToMap(table);
        return executors;
    }

    public Map<Integer, Executor> findAllByProject(Project project) throws SQLException {
        preparedStatement = connection.prepareStatement(QueriesMySql.ALL_EXECUTORS_BY_PROJECT);
        preparedStatement.setInt(1, project.getId());
        ResultSet table = preparedStatement.executeQuery();
        Map<Integer, Executor> executors = convertTableToMap(table);
        return executors;
    }

    private Map<Integer, Executor> convertTableToMap(ResultSet table) throws SQLException {
        Map<Integer, Executor> executors = new HashMap<>();
        while (table.next()) {
            Executor executor = new Executor();
            executor.setId(table.getInt("id"));
            executor.setFullName(table.getString("full_name"));
            executor.setQualification(table.getString("qualification"));
            executor.setEducation(table.getString("education"));
            executors.put(executor.getId(), executor);
        }
        return executors;
    }

    @Override
    public Executor findById(Integer id) {
        // not implemented yet
        return null;
    }

    @Override
    public void save(Executor executor) throws SQLException {
        preparedStatement = connection.prepareStatement(QueriesMySql.ADD_EXECUTOR);
        preparedStatement.setString(1, executor.getFullName());
        preparedStatement.setString(2, executor.getQualification());
        preparedStatement.setString(3, executor.getEducation());
        preparedStatement.execute();
    }

    @Override
    public void update(Executor executor) throws SQLException {
        preparedStatement = connection.prepareStatement(QueriesMySql.UPDATE_EXECUTOR);
        preparedStatement.setString(1, executor.getFullName());
        preparedStatement.setString(2, executor.getQualification());
        preparedStatement.setString(3, executor.getEducation());
        preparedStatement.setInt(4, executor.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Executor executor) {
        // not implemented yet
    }

    public int getLastId() throws SQLException {
        ResultSet table = statement.executeQuery(QueriesMySql.ALL_EXECUTORS);
        table.last();
        return table.getInt("id");
    }

}
