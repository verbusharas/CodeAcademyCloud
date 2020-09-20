package lt.verbus.repository;

import lt.verbus.config.QueriesMySql;
import lt.verbus.model.Executor;
import lt.verbus.model.Importance;
import lt.verbus.model.Project;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ProjectRepository implements CrudRepository<Integer, Project> {

    private final Connection connection;
    private final Statement statement;
    private PreparedStatement preparedStatement;
    private final ExecutorRepository executorRepository;

    public ProjectRepository(Connection connection) throws SQLException {
        this.connection = ConnectionPool.getMySqlConnection();
        this.statement = connection.createStatement();
        this.executorRepository = new ExecutorRepository(connection);
    }

    @Override
    public Map<Integer, Project> findAll() throws SQLException {
        ResultSet table = statement.executeQuery(QueriesMySql.ALL_PROJECTS_AND_EXECUTORS);
        Map<Integer, Project> projects = new HashMap<>();
        ExecutorRepository executorRepository = new ExecutorRepository(connection);

        while (table.next()) {
            Project project = new Project();
            project.setId(table.getInt("project_id"));
            project.setTitle(table.getString("title"));
            project.setImportance(Importance.valueOf(table.getString("importance")));
            project.setStartedAt(table.getDate("started_at").toLocalDate());
            project.setDuration(table.getInt("duration"));
            Map<Integer, Executor> projectExecutors = executorRepository.findAllByProject(project);
            project.setExecutors(projectExecutors);
            projects.put(project.getId(), project);
        }

        return projects;
    }

    @Override
    public Project findById(Integer id) {
        // not implemented yet
        return null;
    }

    @Override
    public void save(Project project) {
        // not implemented yet
    }

    @Override
    public void update(Project project) throws SQLException {
        preparedStatement = connection.prepareStatement(QueriesMySql.UPDATE_PROJECT);
        preparedStatement.setString(1, project.getTitle());
        preparedStatement.setString(2, project.getImportance().toString());
        preparedStatement.setString(3, project.getStartedAt().toString());
        preparedStatement.setInt(4, project.getDuration());
        preparedStatement.setInt(5, project.getId());
        preparedStatement.executeUpdate();

        Map<Integer, Executor> projectExecutors = project.getExecutors();
        Map<Integer, Executor> projectExecutorsInRepo = executorRepository.findAllByProject(project);

        for (Executor executor : projectExecutors.values()) {
            if (projectExecutorsInRepo.get(executor.getId()) == null) {
                appointExecutorToProject(executor, project);
            }
        }
    }

    public void appointExecutorToProject(Executor executor, Project project) throws SQLException {
        preparedStatement = connection.prepareStatement(QueriesMySql.APPOINT_EXECUTOR_TO_PROJECT);
        preparedStatement.setInt(1, project.getId());
        System.out.println(project.getId());
        preparedStatement.setInt(2, executor.getId());
        System.out.println(executor.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Project project) {
        // not implemented yet
    }

}
