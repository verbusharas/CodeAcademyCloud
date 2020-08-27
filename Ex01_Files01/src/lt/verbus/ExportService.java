package lt.verbus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class ExportService {

    public void exportPeople(Map<Integer, Person> people, String pathToFile, SortOrder order) {
        List<Person> peopleList = new ArrayList<>();
        for (Map.Entry entry : people.entrySet()) {
            peopleList.add((Person) entry.getValue());
        }

        switch (order) {
            case BY_RECEIVED: peopleList.sort(new ComparatorReceived()); break;
            case BY_SENT: peopleList.sort(new ComparatorSent()); break;
        }

        Collections.reverse(peopleList);

        try (BufferedWriter peopleWriter = Files.newBufferedWriter(Paths.get(pathToFile))) {
            for (Person p : peopleList) {
                peopleWriter.write(p.toString());
                peopleWriter.newLine();
            }
            System.out.println("List of people sorted by " + order.getSuccessText() + " and exported successfully to file: " + pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}