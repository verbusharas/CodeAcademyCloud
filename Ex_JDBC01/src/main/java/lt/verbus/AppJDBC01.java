package lt.verbus;

import lt.verbus.model.Executor;
import lt.verbus.model.Project;
import lt.verbus.repository.ConnectionPool;
import lt.verbus.repository.ExecutorRepository;
import lt.verbus.repository.ProjectRepository;
import lt.verbus.services.ExecutorService;
import lt.verbus.services.ProjectService;

import java.io.IOException;
import java.sql.SQLException;


public class AppJDBC01
{
    public static void main( String[] args ) throws SQLException, IOException {

        ExecutorRepository executorRepository = new ExecutorRepository(ConnectionPool.getMySqlConnection());
        ProjectRepository projectRepository = new ProjectRepository(ConnectionPool.getMySqlConnection());

        ExecutorService executorService = new ExecutorService(executorRepository);
        ProjectService projectService = new ProjectService(projectRepository);

        // 1. Išvesti visų darbuotojų vardus ir pavardes
        System.out.println(executorService.findAll());

        // 2. Išvesti visus projektus ir juose dirbančius žmones
        System.out.println(projectService.findAll());

        // 3. Parašyti programą leidžiančią įvesti naujus darbuotojus
        Executor intern = new Executor();
        intern.setFullName("Antanas Smetona");
        intern.setQualification("Data Scientist");
        intern.setEducation("Vilnius Tech");
        intern = executorService.addNewExecutor(intern);

        System.out.println(executorService.findAll());

        // 4. Papildyti programą galimybe priskirti darbuotoją projektui
        Project project = projectService.findAll().get(1);
        projectService.appointExecutorToProject(intern, project);

        System.out.println(projectService.findAll());

        // destroy
        ConnectionPool.closeConnections();



    }
}
