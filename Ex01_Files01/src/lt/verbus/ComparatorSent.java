package lt.verbus;

import java.util.Comparator;

public class ComparatorSent implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Double.compare(p1.getSentMoney(), p2.getSentMoney());
    }
}
