/**
 * Project: Space Game - MYSQL CRUD
 * Purpose Details: MYSQL CRUD
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 5/27/24
 * Last Date Changed: 6/4/24
 * Revision: 3
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlShipCRUD {

    /**
     * Represents the JDBC URL for connecting to the MySQL database
     *
     */

    /**
     * Abdullah Koro
     * private String JDBC_URL;
     */

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ShipHealth";

    /**
     * Represents the username for connecting to the MySQL database
     */

    /**
     * Abdullah Koro
     * private String USERNAME;
     */

    private static final String USERNAME = "root";

    /**
     * Represents the password for connecting to the MySQL database
     */

    /**
     * Abdullah Koro
     * private String PASSWORD;
     */

    private static final String PASSWORD = "IST888IST888";

    /**
     * Main method to execute CRUD operations on ship health points in the MySQL database
     *
     *
     */
    public static void main(String[] args)
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD))

        {
            // Insert Ship health points
            insertShipHealth(connection, 1, 100);

            // Update Ship health points
            updateShipHealth(connection, 1, 80);

            // Read Ship health points
            int shipHealth = readShipHealth(connection, 1);
            System.out.println("Ship Health: " + shipHealth);

            // Delete Ship health points
            // deleteShipHealth(connection, 1);

        } catch (SQLException e)

        {
            e.printStackTrace();
        }
    }

    /**
     * Inserts ship health points into the MySQL database
     *
     * @param connection   The connection to the MySQL database
     * @param shipId       The ID of the ship
     * @param healthPoints The health points of the ship
     * @throws SQLException If a database access error occurs
     */
    private static void insertShipHealth(Connection connection, int shipId, int healthPoints) throws SQLException
    {

        /**
         * Abdullah Koro
         * private String sql;
         */

        String sql = "INSERT INTO ship_health (ship_id, health_points) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql))

        {
            preparedStatement.setInt(1, shipId);
            preparedStatement.setInt(2, healthPoints);


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0)
            {
                System.out.println("Ship health points inserted successfully");
            } else

            {
                System.out.println("Failed to insert ship health points");
            }
        }
    }

    /**
     * Updates ship health points in the MySQL database
     *
     * @param connection    The connection to the MySQL database
     * @param shipId        The ID of the ship
     * @param newHealthPoints The new health points of the ship
     * @throws SQLException If a database access error occurs
     */
    private static void updateShipHealth(Connection connection, int shipId, int newHealthPoints) throws SQLException
    {

        /**
         * Abdullah Koro
         * private String sql;
         */

        String sql = "UPDATE ship_health SET health_points = ? WHERE ship_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql))

        {
            preparedStatement.setInt(1, newHealthPoints);
            preparedStatement.setInt(2, shipId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0)
            {
                System.out.println("Ship health points updated successfully");
            }

            else

            {
                System.out.println("Failed to update ship health points" +
                        "");
            }
        }
    }

    /**
     * Reads ship health points from the MySQL database
     *
     * @param connection The connection to the MySQL database
     * @param shipId     The ID of the ship
     * @return The health points of the ship
     * @throws SQLException If a database access error occurs
     */



    private static int readShipHealth(Connection connection, int shipId) throws SQLException

    {
        String sql = "SELECT health_points FROM ship_health WHERE ship_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1, shipId);
            try (ResultSet resultSet = preparedStatement.executeQuery())

            {
                if (resultSet.next())

                {
                    return resultSet.getInt("health_points");
                }
            }
        }
        return -1; // Indicate failure
    }

    /**
     * Deletes ship health points from the MySQL database
     *
     * @param connection The connection to the MySQL database
     * @param shipId     The ID of the ship
     * @throws SQLException If a database access error occurs
     */



    private static void deleteShipHealth(Connection connection, int shipId) throws SQLException
    {

        /**
         * Abdullah Koro
         * private String sql;
         */

        String sql = "DELETE FROM ship_health WHERE ship_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, shipId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0)


            {
                System.out.println("Ship health points deleted successfully");
            } else {
                System.out.println("Failed to delete ship health points");
            }
        }
    }
}
