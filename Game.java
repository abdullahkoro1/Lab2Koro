/**
 * Project: Lab 1 - Space Game
 * Purpose Details: Enemy
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/20/24
 * Last Date Changed: 5/26/24
 * Revision: 1
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
    }
}
