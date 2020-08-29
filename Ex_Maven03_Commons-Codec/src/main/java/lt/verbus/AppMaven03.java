package lt.verbus;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 */
public class AppMaven03 {
    private static Scanner input;
    private static Map<String, String> users;

    public static void main(String[] args) {

        input = new Scanner(System.in);
        users = new HashMap<>();

        while (true) {
            printMenu();
            switch (input.nextLine()) {
                case "1":
                    fireRegistration();
                    break;
                case "2":
                    fireLogin();
                    break;
                default:
                    System.out.println("Tokio pasirinkimo meniu nėra");
            }
        }

    }

    public static void printMenu() {
        String[] menuItems = {"registruotis", "prisijungti"};
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println("[" + (i + 1) + "] " + menuItems[i]);
        }
    }

    public static void fireRegistration() {
        String username;
        String password;

        System.out.println();
        System.out.println(":: REGISTRACIJA ::");
        System.out.println();

        while (true) {
            System.out.println("Įvesk vartotojo vardą: ");
            username = input.nextLine();
            if (!users.containsKey(username)) {
                break;
            } else {
                System.out.println("Vartotojas tokiu vardu jau egzistuoja!");
            }
        }

        while (true) {
            System.out.println("Įvesk slaptažodį:");
            password = input.nextLine();
            System.out.println("Pakartok slaptažodį:");
            if (input.nextLine().equals(password)) {
                break;
            } else {
                System.out.println("Slaptažodžiai nesutampa!");
            }
        }

        users.put(username, DigestUtils.sha256Hex(password));
        System.out.println();
        System.out.println(":: Vartotojo " + username + " registracija sėkminga! ::");
        System.out.println();

    }


    public static void fireLogin() {
        String username;
        String password;
        int triesRemaining = 3;

        System.out.println();
        System.out.println(":: PRISIJUNGIMAS ::");
        System.out.println();

        while (true) {
            System.out.println("Įvesk vartotojo vardą: ");
            username = input.nextLine();
            if (!users.containsKey(username)) {
                System.out.println("Vartotojas tokiu vardu neegzistuoja!");
            } else break;
        }

        while (triesRemaining > 0) {
            System.out.println("Įvesk slaptažodį:");
            if (users.get(username)
                    .equals(DigestUtils.sha256Hex(input.nextLine()))) {
                System.out.println("PRISIJUNGIMAS SĖKMINGAS. LABAS " + username.toUpperCase());
                System.out.println(users.get(username));
                System.out.println();
                break;
            } else {
                System.out.println("Neteisingas slaptažodis. Liko bandymų: " + --triesRemaining);
            }
        }


    }

}
