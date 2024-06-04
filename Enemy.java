/**
 * Project: Lab 1 - Space Game
 * Purpose Details: Enemy
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/20/24
 * Last Date Changed: 5/26/24
 * Revision: 1
 */

public class Enemy {

    /**
     * Abdullah Koro
     * private String type;
     * private int strength;
     **/


  // Type of variable and place to store the type and strength of the enemy

    private String type;
    private int strength;

    // Constructor to initialize the enemy with a type and strength

    public Enemy(String type, int strength)
    {
        this.type = type;
        this.strength = strength;
    }

    // Getter and setter methods

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Method to return the enemy information as a stringg

    public String toString() {
        return "Enemy{type='" + type + "', strength=" + strength + "}";


    }
}
