package lt.verbus;

import java.util.Comparator;

public class ComparatorReceived implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Double.compare(p1.getReceivedMoney(), p2.getReceivedMoney());
    }
}
