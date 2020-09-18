package lt.verbus.model;

public class ConvertableImpl implements Convertable {

    private Integer id;
    private String name;

    public ConvertableImpl(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
