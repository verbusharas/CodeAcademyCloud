package lt.verbus;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class App 
{

    public static void main( String[] args ) throws IOException {
        int atkeliaujantisSkaicius = darytiKazka();
        System.out.println(atkeliaujantisSkaicius);
    }

    static int darytiKazka(){
        // kūnas = dalykai kuriuos reikia padaryti iškvietus šį metodą
        // galbūt panaudoti gautus parametrus
        int skaicius;
        skaicius = 2 + 78;
        int skaicius2;
        skaicius2 = skaicius + 4;

        return skaicius2;
    }


}

