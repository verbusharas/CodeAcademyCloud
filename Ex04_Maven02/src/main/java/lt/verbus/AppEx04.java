package lt.verbus;

import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetector;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class AppEx04
{
    public static void main( String[] args )
    {
       final LanguageDetector detector = LanguageDetectorBuilder.fromAllLanguages().build();
        System.out.println("Įvesk porą sakinių, bandysim atspėti kalbą: ");
        Scanner input = new Scanner(System.in);
        String stringToInspect = input.nextLine();
        System.out.println("Ok. Tikriname... Kantrybės...");
       final Language detectedLanguage = detector.detectLanguageOf(stringToInspect);
        System.out.println("Manau, kad įvesto sakinio kalba yra: " + detectedLanguage);
    }
}
