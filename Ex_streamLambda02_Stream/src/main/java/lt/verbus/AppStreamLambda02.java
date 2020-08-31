package lt.verbus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class AppStreamLambda02 {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        List<String> people = Files.lines(
                Paths.get("Ex_streamLambda02_Stream\\src\\main\\resources\\people.txt"))
                .map(line -> line.split(", ")[1])
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .collect(Collectors.toList());

       System.out.println(people);
    }
}
