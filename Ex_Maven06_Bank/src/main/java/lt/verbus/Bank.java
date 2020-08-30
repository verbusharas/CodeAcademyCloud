package lt.verbus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private final Map<Person, BankAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void openNewAccount(Person accountHolder, Currency currency) {
        BankAccount newBankAccount = new BankAccount(0.0, currency, accountHolder);
        accounts.put(accountHolder, newBankAccount);
        Log.getLogger().info("New account opened: IBAN: {} for {} {}",
                newBankAccount.getIBAN(),
                newBankAccount.getHolder().getName(),
                newBankAccount.getHolder().getSurname());
    }

    public double getBalance(Person accountHolder) {
        return accounts.get(accountHolder).getBalance();
    }

    public void transferMoney(Person sender, Person receiver, double amount, Currency transferCurrency) {
        BankAccount senderAccount;
        BankAccount receiverAccount;
        try {
            senderAccount = accounts.get(sender);
            receiverAccount = accounts.get(receiver);
        } catch (NullPointerException ex){
            ex.printStackTrace();
            Log.getLogger().error("Requested operation could not be completed, no such person in bank's database!");
            return;
        }

        try {
            Log.getLogger().info("{} {} requested for money transfer operation to {} {} for {} {}...",
                    sender.getName(),
                    sender.getSurname(),
                    receiver.getName(),
                    receiver.getSurname(),
                    amount,
                    transferCurrency);

            senderAccount.withdrawMoney(amount
                    / transferCurrency.getRatioToEur()
                    / senderAccount.getCurrency().getRatioToEur());

            Log.getLogger().info("{} {} successfully withdrawn...",
                    amount / transferCurrency.getRatioToEur() / senderAccount.getCurrency().getRatioToEur(),
                    senderAccount.getCurrency());

            receiverAccount.addMoney(amount
                    / transferCurrency.getRatioToEur()
                    / receiverAccount.getCurrency().getRatioToEur());

            Log.getLogger().info("{} {} successfully transfered.",
                    amount / transferCurrency.getRatioToEur() * receiverAccount.getCurrency().getRatioToEur(),
                    receiverAccount.getCurrency());

        } catch (InsufficientFundsEx insufficientFundsEx) {
            insufficientFundsEx.printStackTrace();
            Log.getLogger().error("The requested operation could not be completed. Insufficient funds ({} {})!",
                    senderAccount.getBalance(),
                    senderAccount.getCurrency());
        }
    }

    public void topUpAccount(Person accountHolder, double amount) {
        BankAccount bankAccount;
        try {
            bankAccount = accounts.get(accountHolder);

            Log.getLogger().info("Looking for {} {} bank account...",
                    accountHolder.getName(),
                    accountHolder.getSurname());

            bankAccount.addMoney(amount);
            Log.getLogger().info("{} {} successfully added to account No. {}",
                    amount,
                    bankAccount.getCurrency(),
                    bankAccount.getIBAN());

        } catch (NullPointerException ex){
            Log.getLogger().error("Requested operation could not be completed, no such person in bank's database!");
        }

    }

    public void printAllAccounts() {
        Log.getLogger().info("----------- LISTING ALL ACTIVE BANK ACCOUNTS ---------");
        for (Map.Entry<Person, BankAccount> account : accounts.entrySet()) {
            Log.getLogger().info("\n{}", account.getValue());
        }
    }


}
