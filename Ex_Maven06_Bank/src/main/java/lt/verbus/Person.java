package lt.verbus;

public class Person {
    private static int counter;
    private final String name;
    private final String surname;
    private final String id;

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = String.valueOf(counter++);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }
}
