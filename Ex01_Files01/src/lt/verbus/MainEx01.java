package lt.verbus;

import java.io.IOException;
import java.util.Map;

public class MainEx01 {

    public static void main(String[] args) throws IOException {
        Map<Integer, Person> people = new ImportService().importPeople("Ex01_Files01/src/databases/people.txt");
        Map<Integer, Payment> transactions = new ImportService().importPayments("Ex01_Files01/src/databases/payment.txt");
        people = updateBalances(people, transactions);
        new ExportService().exportPeople(people, "Ex01_Files01/src/databases/receivers.txt", SortOrder.BY_RECEIVED);
        new ExportService().exportPeople(people, "Ex01_Files01/src/databases/senders.txt", SortOrder.BY_SENT);

    }

    public static Map<Integer, Person> updateBalances(Map<Integer, Person> people, Map<Integer, Payment> transactions) {
        for (Map.Entry entry : transactions.entrySet()) {
            int senderID = ((Payment) entry.getValue()).getSender();
            int receiverID = ((Payment) entry.getValue()).getReceiver();
            if (people.containsKey(senderID) && people.containsKey(receiverID)) {
                people.get(senderID).setTransactionOut(((Payment) entry.getValue()).getAmount());
                people.get(receiverID).setTransactionIn(((Payment) entry.getValue()).getAmount());
            }
        }
        return people;
    }
}
