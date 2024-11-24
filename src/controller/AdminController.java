package controller;

import Model.AdminModel;
import Model.DatabaseConnection;
import Model.AdminModel;
import java.sql.*;
import javax.swing.JOptionPane;

public class AdminController {
    
    // Method to register admin
    public boolean registerAdmin(AdminModel adminModel) {
        // Validate that all fields are filled
        if (adminModel.getName().isEmpty() || adminModel.getUsername().isEmpty() || adminModel.getAddress().isEmpty() || 
            adminModel.getContactNo().isEmpty() || adminModel.getPassword().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if passwords match
        if (!adminModel.getPassword().equals(adminModel.getConfirmPassword())) {
            JOptionPane.showMessageDialog(null, "Passwords do not match", "Password Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Prepare SQL query to insert the admin data into the database
        String sql = "INSERT INTO admin (name, username, address, contactno, password) VALUES (?, ?, ?, ?, ?)";

        // Use the DatabaseConnection class to get the connection
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, adminModel.getName());
            stmt.setString(2, adminModel.getUsername());
            stmt.setString(3, adminModel.getAddress());
            stmt.setString(4, adminModel.getContactNo());
            stmt.setString(5, adminModel.getPassword());

            // Execute the update
            int result = stmt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Admin registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Registration failed. Please try again.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while registering: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
