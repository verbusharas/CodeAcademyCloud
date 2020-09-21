package lt.verbus.services;

import lt.verbus.model.Executor;
import lt.verbus.model.Project;
import lt.verbus.repository.ProjectRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class ProjectService {

    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Map<Integer, Project> findAll() throws SQLException, IOException {
        return projectRepository.findAll();
    }

    public void addNewProject(Project project) {
        projectRepository.save(project);
    }

    public void update(Project project) throws SQLException {
        projectRepository.update(project);
    }


    public void appointExecutorToProject(Executor executor, Project project) throws SQLException {
        projectRepository.appointExecutorToProject(executor, project);
    }


}
