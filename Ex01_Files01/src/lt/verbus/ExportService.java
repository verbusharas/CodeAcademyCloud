package lt.verbus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ExportService {
    public void exportReceivers(Map<Integer, Person> people, String pathToFile){
        List<Person> peopleList = new ArrayList<>();
        for (Map.Entry entry : people.entrySet()) {
            peopleList.add((Person)entry.getValue());
        }
        peopleList.sort(new ComparatorReceived());
        Collections.reverse(peopleList);

        try (BufferedWriter peopleWriter = Files.newBufferedWriter(Paths.get(pathToFile))) {
            for (Person p : peopleList) {
                peopleWriter.write(p.toString());
                peopleWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("List of people sorted by -most received money- exported successfully to file: " + pathToFile);
    }
    public void exportSenders(Map<Integer, Person> people, String pathToFile){
        List<Person> peopleList = new ArrayList<>();
        for (Map.Entry entry : people.entrySet()) {
            peopleList.add((Person)entry.getValue());
        }

        peopleList.sort(new ComparatorSent());
        Collections.reverse(peopleList);

        try (BufferedWriter peopleWriter = Files.newBufferedWriter(Paths.get(pathToFile))) {
            for (Person p : peopleList) {
                peopleWriter.write(p.toString());
                peopleWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("List of people sorted by -most sent money- exported successfully to file: " + pathToFile);
    }
}