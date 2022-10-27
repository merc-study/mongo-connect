import com.mongodb.client.*;
import com.mongodb.MongoCredential;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class app {

    public static void main( String args[] ) {
        
        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("root", "mark1",
                "password".toCharArray());

        MongoClient mongo = MongoClients.create("mongodb://root:password@localhost:27017");
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("comms");
        MongoCollection<Document> collection = database.getCollection("users");
        Document result= collection.find(eq("uname","shreejit")).first();
        System.out.println(result.toJson());
    }
}
