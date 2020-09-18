package lt.verbus.services;

import lt.verbus.model.Executor;
import lt.verbus.model.Project;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseService {

    // Iš pažiūros klasė "tightly coupled" tarp Project ir Person tipų
    // Ar verta daryti Generic interface? T.y. DatabaseService<T>
    // bet tada pasimes logika, kaip priskirinėti person to project... ?

    List<Executor> findAllExecutors() throws SQLException;
    List<Project> findAllProjects() throws SQLException;
    void addNewPerson(Executor executor) throws SQLException;
    void appointPersonToProject(Executor executor, Project project) throws SQLException;


}
