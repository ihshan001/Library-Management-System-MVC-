package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/librarydb";  
    private static final String DB_USER = "root";  // Your DB username
    private static final String DB_PASS = "";  // Your DB password
    private static Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseConnection() { }

    // Public method to get the single connection instance
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            } catch (SQLException e) {
                throw new SQLException("Error connecting to the database", e);
            }
        }
        return connection;
    }
}
