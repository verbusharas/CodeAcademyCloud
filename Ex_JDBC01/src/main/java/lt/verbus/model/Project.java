package lt.verbus.model;

import java.util.ArrayList;
import java.util.List;

public class Project implements Convertable{

    private final Integer id;
    private final String title;
    private List<Executor> executorList;

    public Project(Integer id, String title) {
        this.id = id;
        this.title = title;
        this.executorList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return title;
    }

    public List<Executor> getExecutorList() {
        return executorList;
    }

    public void addExecutor(Executor executor) {
        executorList.add(executor);
    }

    @Override
    public String toString() {
        String projectInfo = "\n = " + title + " = \n";
        for (int i = 0; i<executorList.size(); i++) {
            projectInfo += i+1 + ". " + executorList.get(i) + "\n";
        }
        return projectInfo;
    }


}
