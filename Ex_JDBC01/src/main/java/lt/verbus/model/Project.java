package lt.verbus.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private final int id;
    private final String name;
    private List<Person> executorList;

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
        this.executorList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Person> getExecutorList() {
        return executorList;
    }

    public void addExecutor(Person person) {
        executorList.add(person);
    }

    @Override
    public String toString() {
        String projectInfo = "\n = " + name + " = \n";
        for (int i = 0; i<executorList.size(); i++) {
            projectInfo += i+1 + ". " + executorList.get(i) + "\n";
        }
        return projectInfo;
    }
}
