package lt.verbus;

public class Person {
    private int id;
    private String name;
    private String surname;
    private double receivedMoney;
    private double sentMoney;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.receivedMoney = 0;
        this.sentMoney = 0;
    }

    public void transactionIn(double amount) {
        this.receivedMoney = receivedMoney + amount;
    }

    public void transactionOut(double amount) {
        this.sentMoney = sentMoney + amount;
    }

    public double getReceivedMoney() {
        return receivedMoney;
    }

    public double getSentMoney() {
        return sentMoney;
    }

    @Override
    public String toString() {
        return String.format("%d | %20s|   Money received: %.2f   Money sent %.2f", id, (name + " " + surname), receivedMoney, sentMoney);
    }

}
