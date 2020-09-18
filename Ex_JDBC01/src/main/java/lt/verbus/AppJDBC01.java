package lt.verbus;

import lt.verbus.databases.Database;
import lt.verbus.databases.DatabaseMySql;
import lt.verbus.model.Executor;
import lt.verbus.services.DatabaseService;
import lt.verbus.services.DatabaseServiceImpl;

import java.sql.SQLException;


public class AppJDBC01
{
    public static void main( String[] args ) throws SQLException {

        Database database = DatabaseMySql.getInstance();
        DatabaseService databaseService = new DatabaseServiceImpl(database);

        for (Executor executor : databaseService.findAllExecutors()) {
            System.out.println(executor);
        }
//        DatabaseTemp databaseTemp = DatabaseTemp.getInstance();
//
//        //KLAUSIMAS: Static vs Singleton vs Call singleton everytime
//
//        // 2. Išvesti visus projektus ir juose dirbančius žmones
//        System.out.println(databaseTemp.getAllProjects());
//
//        // 3. Parašyti programą leidžiančią įvesti naujus darbuotojus
//        Executor noob = new Executor("Smetona");
//        databaseTemp.addNewPerson(noob);
//
//        // 4. Papildyti programą galimybe priskirti darbuotoją projektui
//        databaseTemp.appointPersonToProject(noob, 1, "intern",200 );
//
//        System.out.println(databaseTemp.getAllProjects());
//
//        databaseTemp.closeConnections();
    }
}
