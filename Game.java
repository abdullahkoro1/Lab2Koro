import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * Project: Lab 1 - Space Game
 * Purpose Details: Enemy
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/20/24
 * Last Date Changed: 6/4/24
 * Revision: 2
 */

public class Game {

    public static void main(String[] args) {

        // Instances of game objects
        Player player = new Player("Player1");
        Ship ship = new Ship("Falcon", 100);
        Obstacle obstacle = new Obstacle("Asteroid");
        PowerUp powerUp = new PowerUp("Shield");
        Enemy enemy = new Enemy("Alien", 50);

        // Printing the values of each object
        System.out.println(player);
        System.out.println(ship);
        System.out.println(obstacle);
        System.out.println(powerUp);
        System.out.println(enemy);

        MongoShipCRUD mongoship = new MongoShipCRUD("ship_health");
        mongoship.insertShipHealth(1, 100);
        // Update Ship health points
        mongoship.updateShipHealth(1, 80);
        // Read Ship health points
        int shipHealth = mongoship.readShipHealth(1);
        System.out.println("Ship Health: " + shipHealth);
        // Delete Ship health points
        //mongoship.deleteShipHealth(1);
    }
}