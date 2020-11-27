package lt.verbus;

/**
 * Hello world!
 */
public class AppRegex01 {
    public static void main(String[] args) {
        String tekstas = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis " +
                "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                "culpa qui officia deserunt mollit anim id est laborum.";

        // 01
        System.out.println("----------------------------");
        String newText = tekstas.replaceAll("\\b[lL][a-z]*", "*****");
        // geresnis \b(e|E)[a-zA-Z]*
        System.out.println(newText);


        // 02
        System.out.println("----------------------------");
        String[] tekstoZodziai = tekstas.split(" ");
        for (String zodis : tekstoZodziai) {
            System.out.println(zodis);
        }

        // 03
        System.out.println("----------------------------");
        // Regex explanation: (?<=regexp) - looks behind, but doesn't use,
        // in other words - finds A preceded by B, or in this case finds SPACE preceded by , OR .
        String[] tekstoSakiniai = tekstas.split("(?<=[,.])[ ]");
        for (String sakinys : tekstoSakiniai) {
            System.out.println(sakinys);
        }

    }
}
