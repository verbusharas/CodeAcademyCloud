package lt.verbus.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Project extends BaseEntity{

    private String title;
    private Importance importance;
    private LocalDate startedAt;
    private Integer duration;
    private Map<Integer, Executor> executors = new HashMap<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Map<Integer, Executor> getExecutors() {
        return executors;
    }

    public void setExecutors(Map<Integer, Executor> executors) {
        this.executors = executors;
    }

    @Override
    public String toString() {
        String formattedString = "\n== " + title + "==";
        for (Executor executor : executors.values()) {
            formattedString += "\n" + executor.getFullName();
        }
        formattedString += "\n\n";
        return formattedString;
    }
}
