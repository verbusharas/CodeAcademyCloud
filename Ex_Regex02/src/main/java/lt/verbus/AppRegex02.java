package lt.verbus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppRegex02 {
    private static final String FILE_PATH_1 = "Ex_Regex02\\src\\main\\resources\\pws.txt";
    private static final String FILE_PATH_2 = "Ex_Regex02\\src\\main\\resources\\pws2.txt";

    public static void main(String[] args) throws IOException {
        printSeparator("EXERCISE 2 - VALIDATING EMAIL");
        validateEmail("sarunas@verbus.lt");
        validateEmail("info@sarunas@verbus.lt");
        validateEmail("sarunas@verbus.lt ");
        validateEmail("sa runas@verbus.lt");
        validateEmail("sarunas@verb us.lt");

        printSeparator("EXERCISE 3 - TRANSFORMING COLUMN INTO ROW");
        System.out.println(transformColumnToRow(getColumnFromFile(FILE_PATH_1)));

        printSeparator("EXERCISE 4 - VALIDATING PASSWORD");
        Files.lines(Paths.get(FILE_PATH_2)).forEach(AppRegex02::validatePassword);
    }

    private static void printSeparator(String announcement) {
        System.out.println("........................................");
        System.out.println(announcement);
    }

    public static void validateEmail(String emailToValidate) {
        // Validates if email has exactly 1 'at' sign and no spaces in the address (spaces at ends are allowed)
        String validationRegex = "^" + "[^@ ]*" + "@" + "[^@ ]*" + "$";
        // ^       # Start of string
        //[^@ ]*   # Any number of a character not matching `@` or ' ', including none.
        //@        # Matching exactly one `@`
        //[^@ ]*   # Any number of a character not matching `@` or ' ', including none.
        //$        # End of string
        System.out.printf("%25s %s %s",
                emailToValidate, "** is",
                (emailToValidate.trim().matches(validationRegex) ? "VALID\n" : "NOT VALID\n"));
    }

    public static String getColumnFromFile(String filePath) throws IOException {
        StringBuilder linesFromFile = new StringBuilder();
        Files.lines(Paths.get(filePath))
                .forEach(s -> linesFromFile.append(s).append("\n"));
        return linesFromFile.toString();
    }

    public static String transformColumnToRow(String lines) {
        return lines
                .replaceAll("\n", ",")
                .replaceAll("^", "[")
                .replaceAll(",$", "]");
    }

    public static void validatePassword(String password) {
        //at least 16 characters
        //REGEX: any char >=16 times
        boolean hasLength =
                password.matches("(.){16,}");

        //at least 2 digits
        //REGEX: (any char any times -> digit -> any char any times) >=2 times
        boolean hasDigits =
                password.matches("(.*\\d.*){2,}");

        //at least 2 lowercase and 2 uppercase letters
        //REGEX: (any char any times -> lowercase letter -> any char any times) >=2 times
        //REGEX: (regex)(regex) = logical AND
        //REGEX: (any char any times -> uppercase letter -> any char any times) >=2 times
        boolean hasLowercaseUppercase =
                password.matches("((.*[a-z].*){2,})((.*[A-Z].*){2,})");

        boolean isMedium = hasLowercaseUppercase && hasDigits;
        boolean isStrong = isMedium && hasLength;

        System.out.printf("%s %-18s %s %s", "password ", password, "is",
                (isStrong ? "STRONG\n" : isMedium ? "MEDIUM\n" : "WEAK\n"));
    }


}
