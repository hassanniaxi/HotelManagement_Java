package HotelNexa;

import java.sql.*;

public class CheckDBTables {
    DatabaseConnection connection = new DatabaseConnection();
    CheckDBTables(){
    }
    public void checking_tables(){
        try {
            // Check if login table exists
            String query = "SHOW TABLES LIKE 'login'";
            ResultSet result = connection.statement.executeQuery(query);
            if (!result.next()) {
                System.out.println("login table is created.");
                query = "CREATE TABLE login (\n" +
                        "    userId VARCHAR(100),\n" +
                        "    Password VARCHAR(50)\n" +
                        ")";
                String query2 = "INSERT INTO login (userId, Password) VALUES ('1','123')";
                connection.statement.executeUpdate(query);
                connection.statement.executeUpdate(query2);
            } else {
                System.out.println("login table already exists.");
            }

            // Check if Room table exists
            String query2 = "SHOW TABLES LIKE 'room'";
            ResultSet result2 = connection.statement.executeQuery(query2);
            if (!result2.next()) {
                query2 = "CREATE TABLE room (\n" +
                        "    roomNumber VARCHAR(20),\n" +
                        "    availability VARCHAR(20),\n" +
                        "    cleaningStatus VARCHAR(20),\n" +
                        "    price VARCHAR(20),\n" +
                        "    bedType VARCHAR(20)\n" +
                        ")";
                connection.statement.executeUpdate(query2);
                System.out.println("Room table created.");
            } else {
                System.out.println("Room table already exists.");
            }

            // Check if Employee table exists
            String query3 = "SHOW TABLES LIKE 'employee'";
            ResultSet result3 = connection.statement.executeQuery(query3);
            if (!result3.next()) {
                query3 = "CREATE TABLE employee (\n" +
                        "    name VARCHAR(100),\n" +
                        "    age VARCHAR(20),\n" +
                        "    gender VARCHAR(10),\n" +
                        "    job VARCHAR(50),\n" +
                        "    salary VARCHAR(50),\n" +
                        "    phone VARCHAR(20),\n" +
                        "    cnic VARCHAR(20),\n" +
                        "    email VARCHAR(200)\n" +
                        ")";
                connection.statement.executeUpdate(query3);
                System.out.println("Employee table created.");
            } else {
                System.out.println("Employee table already exists.");
            }

            // Check if Driver table exists
            String query4 = "SHOW TABLES LIKE 'driver'";
            ResultSet result4 = connection.statement.executeQuery(query4);
            if (!result4.next()) {
                query4 = "CREATE TABLE driver (\n" +
                        "    name VARCHAR(100),\n" +
                        "    age VARCHAR(20),\n" +
                        "    gender VARCHAR(10),\n" +
                        "    carCompany VARCHAR(50),\n" +
                        "    carName VARCHAR(50),\n" +
                        "    availability VARCHAR(20),\n" +
                        "    carLocation VARCHAR(50)\n" +
                        ")";
                connection.statement.executeUpdate(query4);
                System.out.println("Driver table created.");
            } else {
                System.out.println("Driver table already exists.");
            }

            // Check if Customer table exists
            String query5 = "SHOW TABLES LIKE 'customer'";
            ResultSet result5 = connection.statement.executeQuery(query5);
            if (!result5.next()) {
                query5 = "CREATE TABLE customer (\n" +
                        "    id VARCHAR(1000),\n" +
                        "    number VARCHAR(2000),\n" +
                        "    name VARCHAR(200),\n" +
                        "    gender VARCHAR(10),\n" +
                        "    country VARCHAR(100),\n" +
                        "    roomNumber VARCHAR(200),\n" +
                        "    checkedIn VARCHAR(200),\n" +
                        "    deposit VARCHAR(1000),\n" +
                        "    pending VARCHAR(1000)\n" +
                        ")";
                connection.statement.executeUpdate(query5);
                System.out.println("Customer table created.");
            } else {
                System.out.println("Customer table already exists.");
            }
        } catch (SQLException e) {
            System.out.println("Error checking database tables: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new CheckDBTables();
        CheckDBTables check = new CheckDBTables();
        check.checking_tables();
    }
}
