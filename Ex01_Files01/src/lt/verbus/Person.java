package lt.verbus;

public class Person {
    private final int id;
    private final String name;
    private final String surname;
    private double receivedMoney;
    private double sentMoney;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.receivedMoney = 0;
        this.sentMoney = 0;
    }

    public void setTransactionIn(double amount) {
        this.receivedMoney = receivedMoney + amount;
    }

    public void setTransactionOut(double amount) {
        this.sentMoney = sentMoney + amount;
    }

    public double getReceivedMoney() {
        return receivedMoney;
    }

    public double getSentMoney() {
        return sentMoney;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%d | %20s|   Money received: %.2f   Money sent %.2f", id, (name + " " + surname), receivedMoney, sentMoney);
    }

}
