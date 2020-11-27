package lt.verbus;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */

public class AppMaven06
{
    private static final Logger LOG = LogManager.getLogger(AppMaven06.class);
    public static void main( String[] args )
    {

        Person petras = new Person("Petras", "Petraitis");
        Person jonas = new Person("Jonas", "Jonaitis");
        Person antanas = new Person("Antanas", "Antanaitis");

        Bank CitadeleBank = new Bank();
        CitadeleBank.openNewAccount(petras, Currency.EUR);
        CitadeleBank.openNewAccount(jonas, Currency.USD);

        CitadeleBank.topUpAccount(petras, 120);
        CitadeleBank.topUpAccount(petras, 30);
        CitadeleBank.topUpAccount(antanas, 60);
        CitadeleBank.topUpAccount(jonas, 50);
        CitadeleBank.transferMoney(petras, jonas, 27.30, Currency.DKK);

        CitadeleBank.printAllAccounts();
    }
}
