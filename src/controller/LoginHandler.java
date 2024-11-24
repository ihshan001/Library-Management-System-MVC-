/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import View.AdminPage;
import View.MemberPage;
import javax.swing.*;
/**
 *
 * @author AL MUBDIE
 */
public class LoginHandler {
    private LoginController loginController;

    public LoginHandler() {
        loginController = new LoginController(); // Initialize LoginController
    }

    // Perform login for admin or member based on userType
    public void performLogin(JFrame currentFrame, JTextField txtUName, JPasswordField txtPass, String userType) {
        try {
            // Get username and password
            String username = txtUName.getText();
            String password = new String(txtPass.getPassword());

            // Validate input fields
            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Username and password cannot be empty.");
            }

            // Authenticate user based on userType
            boolean isAuthenticated;
            if ("admin".equalsIgnoreCase(userType)) {
                isAuthenticated = loginController.authenticateAdmin(username, password);
            } else if ("member".equalsIgnoreCase(userType)) {
                isAuthenticated = loginController.authenticateMember(username, password);
            } else {
                throw new IllegalArgumentException("Invalid user type.");
            }

            // Handle authentication result
            if (isAuthenticated) {
                JOptionPane.showMessageDialog(currentFrame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Open appropriate page
                JFrame nextPage = "admin".equalsIgnoreCase(userType) ? new AdminPage() : new MemberPage();
                nextPage.setVisible(true);
                currentFrame.setVisible(false);
            } else {
                throw new SecurityException("Invalid username or password.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(currentFrame, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (SecurityException e) {
            JOptionPane.showMessageDialog(currentFrame, e.getMessage(), "Authentication Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(currentFrame, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
