/**
 * Project: Space Game
 * Purpose Details: Power up in the game
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/20/24
 * Last Date Changed: 5/26/24
 * Revision: 1
 */

public class PowerUp {


    /**
     * Abdullah Koro
     * private String type;
     */

    // Storing variable and power up type

    private String type;

    // intializing

    public PowerUp(String type) {
        this.type = type;
    }

    // Getter and setter method

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String toString() {
        return "PowerUp{type='" + type + "'}";


    }
}
