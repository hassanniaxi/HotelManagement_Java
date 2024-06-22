package HotelNexa;

import java.sql.*;

public class DatabaseConnection {
    Connection conn;
    Statement statement;

    public DatabaseConnection() {
        checkingDatabase();
        try {
            // Establishing the connection
            String url = "jdbc:mysql://localhost:3306/hotelnexa_db";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            // Handling connection errors
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public void checkingDatabase() {
        Connection tempConn = null;
        Statement tempStatement = null;
        try {
            // Establishing the initial connection
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "";
            tempConn = DriverManager.getConnection(url, username, password);
            tempStatement = tempConn.createStatement();

            // Checking if the database exists
            ResultSet resultSet = tempStatement.executeQuery("SHOW DATABASES LIKE 'hotelnexa_db'");
            if (!resultSet.next()) {
                // If the database does not exist, create it
                tempStatement.executeUpdate("CREATE DATABASE hotelnexa_db");
                System.out.println("Database 'hotelnexa_db' created.");
            } else {
                System.out.println("Database 'hotelnexa_db' already exists.");
            }
        } catch (SQLException e) {
            // Handling errors during database check and creation
            System.out.println("Error checking or creating the database: " + e.getMessage());
        } finally {
            // Closing resources
            try {
                if (tempStatement != null) tempStatement.close();
                if (tempConn != null) tempConn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new DatabaseConnection();
    }
}
