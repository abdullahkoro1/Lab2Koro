/**
 * Project: Lab 1 - Space Game
 * Purpose Details: Obstacle in game, like an object in the space
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/20/24
 * Last Date Changed: 5/26/24
 * Revision: 1
 */

public class Obstacle {

    /**
     * Abdullah Koro
     * private String type;
     */

    // Type of variable and place to store obstacle

    private String type;

    // Initializing the obstacle with a type

    public Obstacle(String type) {
        this.type = type;
    }

    // Getter and setter methods

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    // Method to return the obstacle information as a string

    public String toString() {
        return "Obstacle{type='" + type + "'}";
    }
}
