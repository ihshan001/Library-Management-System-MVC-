package controller;

import Model.DatabaseConnection;
import java.sql.*;
import javax.swing.JOptionPane;

public class LoginController {

    // Method to authenticate admin login
    public boolean authenticateAdmin(String username, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;  // Admin found with matching username and password
            } else {
                return false;  // Invalid login credentials
            }
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    // Method to authenticate member login
    public boolean authenticateMember(String username, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM members WHERE name = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;  // Member found with matching username and password
            } else {
                return false;  // Invalid login credentials
            }
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    // Utility method to handle SQLExceptions
    private void handleSQLException(SQLException e) {
        JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage(),
                                      "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
