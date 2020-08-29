package lt.verbus;

import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class AppMaven01
{

    public static void main( String[] args )
    {
        Faker faker = new Faker();

        for (int i = 1; i <= 100; i++) {
            if (i%10 != 0) {
                System.out.printf("%-22s",  faker.address().streetName());
            } else System.out.println();
        }

        for (int i = 1; i <= 100; i++) {
            if (i%10 != 0) {
                System.out.printf("%22s",  faker.weather().temperatureCelsius());
            } else System.out.println();
        }

        for (int i = 1; i <= 100; i++) {
            if (i%10 != 0) {
                System.out.printf("%-22s",  faker.gameOfThrones().character());
            } else System.out.println();
        }

    }
}
