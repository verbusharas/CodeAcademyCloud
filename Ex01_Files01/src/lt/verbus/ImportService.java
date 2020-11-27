package lt.verbus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ImportService {

    public Map<Integer, Person> importPeople(String pathToFile) {
        Map<Integer, Person> people = new HashMap<>();
        try (BufferedReader peopleReader = Files.newBufferedReader(Paths.get(pathToFile))) {
            String line;
            peopleReader.readLine(); //prašokama pirma eilutė su stulpelių pavadinimais
            while ((line = peopleReader.readLine()) != null) {
                String[] argumentsInLine = line.split(", ");
                people.put(Integer.valueOf(argumentsInLine[0]), createPerson(argumentsInLine));
            }
            System.out.println("List of registered people imported successfully. No of entries: " + people.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Map<Integer, Payment> importPayments(String pathToFile) {
        Map<Integer, Payment> transactions = new HashMap<>();
        try (BufferedReader paymentReader = Files.newBufferedReader(Paths.get(pathToFile))) {
            String line;
            paymentReader.readLine(); //prašokama pirma eilutė su stulpelių pavadinimais
            while ((line = paymentReader.readLine()) != null) {
                String[] argumentsInLine = line.split(", ");
                transactions.put(Integer.valueOf(argumentsInLine[0]), createPayment(argumentsInLine));
            }
            System.out.println("List of completed transactions imported successfully. No of entries: " + transactions.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }


    private Person createPerson(String[] argumentsInLine) {
        return new Person(
                Integer.parseInt(argumentsInLine[0]),
                argumentsInLine[1],
                argumentsInLine[2]
        );
    }

    private Payment createPayment(String[] argumentsInLine) {
        return new Payment(
                Integer.parseInt(argumentsInLine[0]),
                Double.parseDouble(argumentsInLine[1]),
                Integer.parseInt(argumentsInLine[2]),
                Integer.parseInt(argumentsInLine[3].trim())
        );
    }
}
