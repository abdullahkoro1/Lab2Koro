/**
 * Project: Space Game - Mongo CRUD
 * Purpose Details: Mongo CRUD
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/27/24
 * Last Date Changed: 6/4/24
 * Revision: 3
 */
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class MongoShipCRUD {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public MongoShipCRUD(String collection){
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("ShipHealth");
        this.collection = database.getCollection(collection);
    }

    /**
     * Inserts ship health points into the MongoDB collection
     *
     * @param shipId      The ID of the ship
     * @param healthPoints The health points of the ship
     *
     */

    public void insertShipHealth(int shipId, int healthPoints) {
        try {
            Document shipDocument = new Document("ship_id", shipId)
                    .append("health_points", healthPoints);
            collection.insertOne(shipDocument);
            System.out.println("Ship health points inserted successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Updates ship health points in the MongoDB collection
     *
     * @param shipId      The ID of the ship
     * @param newHealthPoints The new health points of the ship
     */
    public void updateShipHealth(int shipId, int newHealthPoints)
    {

        try {
            Document filter = new Document("ship_id", shipId);
            Document update = new Document("$set", new Document("health_points", newHealthPoints));
            collection.updateOne(filter, update);
            System.out.println("Ship health points updated successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Reads ship health points from the MongoDB collection
     *
     * @param shipId      The ID of the ship
     * @return The health points of the ship
     */
    public int readShipHealth(int shipId)

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
     * @param shipId      The ID of the ship
     *
     */
    public void deleteShipHealth(int shipId)
    {

        Document filter = new Document("ship_id", shipId);
        collection.deleteOne(filter);

        System.out.println("Ship health points deleted successfully");
    }
}