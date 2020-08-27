package lt.verbus;

public class Payment {
    private final int id;
    private final double amount;
    private final int sender;
    private final int receiver;

    public Payment (int id, double amount, int sender, int receiver) {
        this.id = id;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public int getSender() {
        return sender;
    }

    public int getReceiver() {
        return receiver;
    }
}
