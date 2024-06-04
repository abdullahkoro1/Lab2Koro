/**
 * Project: Space Game
 * Purpose Details: The Player in the game
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/20/24
 * Last Date Changed: 5/26/24
 * Revision: 1
 */

public class Player {

    /**
     * Abdullah Koro
     * private String name;
     */

    // Place to store player and variable type

    private String name;

    // Intializing the player with a name

    public Player(String name) {
        this.name = name;
    }

    // Getter and setter methods

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Method to return the player information as a string

    public String toString() {
        return "Player{name='" + name + "'}";
    }
}
