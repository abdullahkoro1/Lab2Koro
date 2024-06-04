/**
 * Project: Space Game
 * Purpose Details: Space ship in the game
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/20/24
 * Last Date Changed: 5/26/24
 * Revision: 1
 */

public class Ship {

    /**
     * Abdullah Koro
     * private String name;
     * private int health;
     */


    // Store shape type and health and variable types

    private String name;
    private int health;

    // Initiliazing

    public Ship(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Getter and setter methods

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    // method to return information as string

    public String toString() {
        return "Ship{name='" + name + "', health=" + health + "}";
    }
}
