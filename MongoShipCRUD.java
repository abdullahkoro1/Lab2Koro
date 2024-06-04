/**
 * Project: Space Game - Mongo CRUD
 * Purpose Details: Mongo CRUD
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/27/24
 * Last Date Changed: 6/3/24
 * Revision: 2
 */
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class MongoShipCRUD {

    /**
     * Main method to execute CRUD operations on ship health points in the MongoDB database
     *
     */

    public static void main(String[] args)
    {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017"))

        {
            MongoDatabase database = mongoClient.getDatabase("ShipHealth");

            MongoCollection<Document> collection = database.getCollection("ship_health");

            // Insert Ship health points

            insertShipHealth(collection, 1, 100);

            // Update Ship health points

            updateShipHealth(collection, 1, 80);

            // Read Ship health points

            int shipHealth = readShipHealth(collection, 1);

            System.out.println("Ship Health: " + shipHealth);

            // Delete Ship health points

            deleteShipHealth(collection, 1);

        }
    }

    /**
     * Inserts ship health points into the MongoDB collection
     *
     *
     * @param collection  The MongoDB collection for ship health points
     *
     * @param shipId      The ID of the ship
     *
     * @param healthPoints The health points of the ship
     *
     */

    private static void insertShipHealth(MongoCollection<Document> collection, int shipId, int healthPoints) {
        Document shipDocument = new Document("ship_id", shipId)


                .append("health_points", healthPoints);

        collection.insertOne(shipDocument);

        System.out.println("Ship health points inserted successfully");
    }

    /**
     * Updates ship health points in the MongoDB collection
     *
     * @param collection  The MongoDB collection for ship health points
     * @param shipId      The ID of the ship
     * @param newHealthPoints The new health points of the ship
     */
    private static void updateShipHealth(MongoCollection<Document> collection, int shipId, int newHealthPoints)
    {
        Document filter = new Document("ship_id", shipId);
        Document update = new Document("$set", new Document("health_points", newHealthPoints));

        collection.updateOne(filter, update);

        System.out.println("Ship health points updated successfully");
    }

    /**
     * Reads ship health points from the MongoDB collection
     *
     * @param collection The MongoDB collection for ship health points
     * @param shipId      The ID of the ship
     * @return The health points of the ship
     */
    private static int readShipHealth(MongoCollection<Document> collection, int shipId)
    {
        Document filter = new Document("ship_id", shipId);

        Document shipDocument = collection.find(filter).first();
        if (shipDocument != null)
        {

            return shipDocument.getInteger("health_points");
        }
        return -1; // Indicate failure


    }

    /**
     * Deletes ship health points from the MongoDB collection
     *
     * @param collection The MongoDB collection for ship health points
     * @param shipId      The ID of the ship
     *
     */
    private static void deleteShipHealth(MongoCollection<Document> collection, int shipId)
    {
        Document filter = new Document("ship_id", shipId);
        collection.deleteOne(filter);

        System.out.println("Ship health points deleted successfully");
    }
}
