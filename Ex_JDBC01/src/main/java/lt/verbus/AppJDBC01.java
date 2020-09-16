package lt.verbus;

import lt.verbus.databases.Database;
import lt.verbus.model.Person;

import java.sql.SQLException;


public class AppJDBC01
{
    public static void main( String[] args ) throws SQLException {

        Database database = Database.getInstance();

        //KLAUSIMAS: Static vs Singleton vs Call singleton everytime

        // 2. Išvesti visus projektus ir juose dirbančius žmones
        System.out.println(database.getAllProjects());

        // 3. Parašyti programą leidžiančią įvesti naujus darbuotojus
        Person noob = new Person("Smetona");
        database.addNewPerson(noob);

        // 4. Papildyti programą galimybe priskirti darbuotoją projektui
        database.appointPersonToProject(noob, 1, "intern",200 );

        System.out.println(database.getAllProjects());

        database.closeConnections();
    }
}
