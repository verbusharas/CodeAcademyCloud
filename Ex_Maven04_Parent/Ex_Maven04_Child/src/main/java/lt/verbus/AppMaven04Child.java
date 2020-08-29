package lt.verbus;

import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class AppMaven04Child
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Faker faker = new Faker();
        System.out.println(faker.ancient().god());


    }
}
