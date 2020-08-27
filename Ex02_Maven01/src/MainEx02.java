import com.github.javafaker.Faker;

public class MainEx02 {

    public static void main(String[] args) {
        Faker faker = new Faker();

        String name = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        String streetAddress = faker.address().streetAddress();

        System.out.println(name + "\n" + firstName + "\n" + lastName + "\n" + streetAddress);
    }

}
