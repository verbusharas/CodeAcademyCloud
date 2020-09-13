package lt.verbus.databases;

import lt.verbus.model.Person;
import lt.verbus.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String SQL_URL = "jdbc:mysql://localhost:3306/paskaitos2";
    private static final String SQL_USERNAME = "root";
    private static final String SQL_PASSWORD = "08princeAli";

    private Connection connection = DriverManager.getConnection(SQL_URL, SQL_USERNAME, SQL_PASSWORD);;
    private Statement statement = connection.createStatement();;

    public Database() throws SQLException {
    }

    public static List<Project> getAllProjects() throws SQLException {

        List<Project> projects = new ArrayList<>();
        ResultSet table = null;

        table = statement.executeQuery(Queries.ALL_PROJECTS_AND_EXECUTORS);
        int projectNo = 0;
        while (table.next()) {
            String currentExecutorSurname = table.getString("Pavardė");
            if (table.getInt("Nr") != projectNo) {
               projectNo = table.getInt("Nr");
               String projectName = table.getString("Pavadinimas");
               projects.add(new Project(projectNo, projectName));
           } else {
                projectNo = table.getInt("Nr");
            }
            projects.get(projectNo-1).addExecutor(new Person(currentExecutorSurname));
        }
        return projects;
    }

    public static void addNewPerson(Person person) throws SQLException {
       PreparedStatement preparedStatement = connection.prepareStatement(Queries.ADD_PERSON);
       preparedStatement.setString(1, person.getSurname());
       preparedStatement.executeUpdate();
    }

    public static int getPersonIdBySurname(String surname) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_PERSON_ID_BY_SURNAME);
        preparedStatement.setString(1, surname);
        ResultSet result = preparedStatement.executeQuery();
        result.next();
        return result.getInt("Nr");
    }

    public static void appointPersonToProject(int personId, int projectID, String status, int hours) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(Queries.APPOINT_PERSON_TO_PROJECT);
        preparedStatement.setInt(1, projectID);
        preparedStatement.setInt(2, personId);
        preparedStatement.setString(3, status);
        preparedStatement.setInt(4, hours);
        preparedStatement.executeUpdate();
    }


    public static void closeConnections() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
