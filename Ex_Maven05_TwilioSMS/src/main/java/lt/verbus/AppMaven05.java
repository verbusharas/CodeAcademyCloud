package lt.verbus;

import com.github.javafaker.Faker;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * Hello world!
 *
 */
public class AppMaven05
{

    public static final String ACCOUNT_SID = "ACc27610f69a1a4542adad910e992b1c62";
    public static final String AUTH_TOKEN = "f772780ea18b84aeaaf81c278c9a28b3";
    public static final String ROBOT_NR = "+12566394293";
    public static final String CHARLIE_NR = "+37061598420";
    public static final String PANDA_NR = "+4591868205";

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Faker faker = new Faker();
        String smsText = "\n___________" +
                "\n__________________" +
                "\n|| MANO ROBOTAS || " +
                "\n|| SIUNČIA TAU ||" +
                "\n__________________" +
                "\nRandom citata iš " +
                "\nRICK AND MORTY: " +
                "\n \"" + faker.rickAndMorty().quote() + "\"" +
                "\n__________________" +
                "\n Random GYVŪNAS:" +
                "\n" + faker.animal().name().toUpperCase();

        Message message = Message
                .creator(new PhoneNumber(CHARLIE_NR), // to
                        new PhoneNumber(ROBOT_NR), // from
                        smsText)
                .create();

//        Message messageCopy = Message
//                .creator(new PhoneNumber(CHARLIE_NR), // to
//                        new PhoneNumber(ROBOT_NR), // from
//                        smsText)
//                .create();

        System.out.println("Originali sms: " + message.getSid());
//        System.out.println("Kopija sms: " + messageCopy.getSid());
    }
}
