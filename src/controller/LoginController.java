package controller;

import Model.AdminModel;
import Model.DatabaseConnection;
import Model.Member;
import java.sql.*;
import javax.swing.JOptionPane;

public class LoginController {

    // Authenticate admin login and return Admin details
    public AdminModel authenticateAdmin(String username, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AdminModel admin = new AdminModel();
                admin.setName(rs.getString("name"));
                admin.setAdminID(rs.getInt("adminID"));
                return admin;  // Return the Admin details
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return null;  // Return null if no match found
    }

    // Authenticate member login and return Member details
    public Member authenticateMember(String username, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM members WHERE name = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Member(
                    rs.getInt("memberID"),
                    rs.getString("name"),
                    rs.getString("contactNo"),
                    rs.getString("address"),
                    rs.getString("password"),
                    null // MembershipCard is not fetched here
                );
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return null;  // Return null if no match found
    }

    // Utility method to handle SQLExceptions (unchanged)
    private void handleSQLException(SQLException e) {
        JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage(),
                                      "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}