package lt.verbus.services;

import lt.verbus.model.Convertable;
import lt.verbus.model.ConvertableImpl;
import lt.verbus.model.Executor;
import lt.verbus.model.Project;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableConverter <TargetType extends Convertable>{

    private ResultSet table;
    private String idColumn;
    private String nameColumn;

    public TableConverter(ResultSet table, String idColumn, String nameColumn) {
        this.table = table;
        this.idColumn = idColumn;
        this.nameColumn = nameColumn;
    }

    public List<TargetType> convertToList() throws SQLException {
        List<TargetType> targetedList = new ArrayList<>();
        for (Convertable convertable : convertTableToGenericList())
            targetedList.add((TargetType)convertable);
        return targetedList;
        }


    private List<Convertable> convertTableToGenericList () throws SQLException {
        Set<Convertable> objectSet = new HashSet<>();
        while (table.next()) {
            Integer id = table.getInt(idColumn);
            String name = table.getString(nameColumn);
            objectSet.add(new ConvertableImpl(id, name));
    }
        return new ArrayList<>(objectSet);
    }
}





//    public List<Project> convertToProjectList(ResultSet table) throws SQLException {
//
//        List<? super Project> projects = convertToList(table, "executor_id", "executor_name");
//        int currentProjectId = 0;
//
//        while (table.next()) {
//
//            if (table.getInt("project_id") != currentProjectId) {
//                // if pointer reached row of new project, then add it to the list
//                currentProjectId = table.getInt("project_id");
//                projects.add(new Project(currentProjectId, table.getString("title")));
//            } else {
//                // else - CHECK IF NEEDED
//                currentProjectId = table.getInt("project_id");
//            }
//
//            Executor currentExecutor = new Executor(
//                    table.getInt("executor_id"),
//                    table.getString("full_name"));
//
//            projects.get(currentProjectId - 1).addExecutor(currentExecutor);
//        }
//
//
//        return projects;
//    }

//    public <T extends Convertable> List<T> convertToList(ResultSet table, String idColumn, String nameColumn) throws SQLException {
//        Set<T> objectList = new HashSet<>();
//        while (table.next()) {
//            Integer id = table.getInt(idColumn);
//            String name = table.getString(nameColumn);
//            objectList.add(new T());
//
//        }
//    }


//    public List<TargetType> convertToList(ResultSet table, String idColumn, String nameColumn) throws SQLException {
//        Set<TargetType> objectList = new HashSet<>();
//        while (table.next()) {
//            Integer id = table.getInt(idColumn);
//            String name = table.getString(nameColumn);
//            TargetType tt = createContents(Class<TargetType> ungenerifiedClass)
//            objectList.add(new TargetType(id, name));
//        }
//
//
//
//
//    }