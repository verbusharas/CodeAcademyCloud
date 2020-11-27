package lt.verbus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiFunction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<String> upes = new ArrayList<>(Arrays.asList("Neris", "Nevezis", "Sventoji", "Nemunas", "Ula"));
        ArrayList<String> miestai = new ArrayList<>(Arrays.asList("Vilnius", "Kaunas", "Marijampole", "Siauliai", "Klaipeda"));

        BiFunction<ArrayList<String>, ArrayList<String>, ArrayList<String>> merger;
        merger = (list1, list2) -> {
            list1.addAll(list2);
            Collections.sort(list1);
            return list1;
        };

        System.out.println(merger.apply(upes, miestai));
    }
}
