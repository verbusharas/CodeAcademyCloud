package lt.verbus.model;

public class Executor implements Convertable{

    private final Integer id;
    private final String fullName;

    public Executor(Integer id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return fullName;
    }


    @Override
    public String toString() {
        return fullName;
    }
}
