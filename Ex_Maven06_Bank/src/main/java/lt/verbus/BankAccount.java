package lt.verbus;

import org.apache.commons.lang3.RandomStringUtils;

public class BankAccount {
    private final String IBAN;
    private double balance;
    private Currency currency;
    private Person holder;

    public BankAccount(double initialBalance, Currency currency, Person accountHolder) {
        IBAN = generateAccountNo();
        this.balance = initialBalance;
        this.currency = currency;
        this.holder = accountHolder;
    }

    private String generateAccountNo() {
        return "LT"+ RandomStringUtils.randomNumeric(18);
    }


    public void addMoney(double amount) {
        balance += amount;
    }

    public void withdrawMoney(double amount) throws InsufficientFundsEx {
        if (balance - amount > 0) {
            balance -= amount;
        } else throw new InsufficientFundsEx("Insufficient funds. " +
                "Please top up or choose different amount. " +
                "Current balance: "
                + getBalance()
                + " " + currency);
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Person getHolder() {
        return holder;
    }

    @Override
    public String toString() {
        return "\nBANK ACCOUNT DATA: " +
                "\nAccount holder: " + holder +
                "\nAccount number: " + IBAN +
                "\nCurrent balance: " + balance + " " + currency + "\n";
    }
}
