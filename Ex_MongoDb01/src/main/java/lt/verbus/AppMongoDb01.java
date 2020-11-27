package lt.verbus;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import lt.verbus.model.User;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class AppMongoDb01 {


    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = mongoClient.getDatabase("LocalDatabase");
        MongoCollection<Document> collection = mongoDatabase.getCollection("LocalCollection");

        printAllUsers(collection);

        User user1 = new User.Builder(1)
                .withName("Peter")
                .withSurname("Griffin")
                .withEmail("petergriffin@family.com")
                .atAddress("Quahog")
                .withPassword("louis999")
                .build();

        User user2 = new User.Builder(2)
                .withName("Louis")
                .withSurname("Griffin")
                .withEmail("louisGriffin@family.com")
                .atAddress("Quahog")
                .withPassword("loveis")
                .build();


        collection.insertOne(makeDocument(user1));
        collection.insertOne(makeDocument(user2));

        printAllUsers(collection);

        collection.updateOne(eq("id", 1),
                Updates.set("address", "Quahog 10"));

        printAllUsers(collection);
        Document document = collection.find(eq("email", "petergriffin@family.com")).first();
        document.get("name");



//        collection.drop();
    }


    public static Document makeDocument(User user) {
        return new Document()
                .append("id", user.getId())
                .append("name", user.getName())
                .append("surname", user.getSurname())
                .append("email", user.getEmail())
                .append("address", user.getAddress())
                .append("password", user.getPassword());
    }


    public static <T> void printAllUsers(MongoCollection<T> collection) {
        for (T t : collection.find()) {
            System.out.println(t);
        }
    }




}
