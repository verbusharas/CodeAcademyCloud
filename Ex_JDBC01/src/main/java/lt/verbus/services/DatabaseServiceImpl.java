package lt.verbus.services;

import lt.verbus.databases.Database;
import lt.verbus.databases.QueriesMySql;
import lt.verbus.model.Executor;
import lt.verbus.model.Project;

import java.sql.*;
import java.util.List;

public class DatabaseServiceImpl implements DatabaseService {

    private Database database;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public DatabaseServiceImpl(Database database) throws SQLException {
        this.database = database;
        connection = database.getConnection();
        statement = connection.createStatement();
    }

    @Override
    public List<Executor> findAllExecutors() throws SQLException {
        ResultSet table = statement.executeQuery(QueriesMySql.ALL_EXECUTORS);
        TableConverter<Executor> tableConverter = new TableConverter<>(table,"id", "full_name");
        List<Executor> executorList = tableConverter.convertToList();
        statement.close();
        return executorList;
    }

    @Override
    public List<Project> findAllProjects() throws SQLException {
        ResultSet table = statement.executeQuery(QueriesMySql.ALL_PROJECTS_AND_EXECUTORS);
        TableConverter<Project> tableConverter = new TableConverter<>(table,"id", "title");
        List<Project> projectList = tableConverter.convertToList();
        statement.close();
        return projectList;
    }

    @Override
    public void addNewPerson(Executor executor) throws SQLException {
//        preparedStatement = connection.prepareStatement(QueriesMySql.ADD_EXECUTOR);
//        preparedStatement.setLong(1, executor.getId());
//        preparedStatement.setString(2, executor.getFullName());
//        preparedStatement.executeUpdate();
//        preparedStatement.close();
    }

    @Override
    public void appointPersonToProject(Executor executor, Project project) throws SQLException {
//        preparedStatement = connection.prepareStatement(QueriesMySql.APPOINT_PERSON_TO_PROJECT);
//        preparedStatement.setInt(1, project.getId());
//        preparedStatement.setInt(2, executor.getId());
//        preparedStatement.executeUpdate();
//        preparedStatement.close();
    }


}
