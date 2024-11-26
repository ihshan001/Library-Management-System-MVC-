
package controller;
import Model.AdminModel;
import Model.Member;
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
        loginController = new LoginController();
    }

    public void performLogin(JFrame currentFrame, JTextField txtUName, JPasswordField txtPass, String userType) {
        try {
            String username = txtUName.getText();
            String password = new String(txtPass.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Username and password cannot be empty.");
            }

            if ("admin".equalsIgnoreCase(userType)) {
                AdminModel admin = loginController.authenticateAdmin(username, password);
                if (admin != null) {
                    JOptionPane.showMessageDialog(currentFrame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    AdminPage adminPage = new AdminPage();
                    adminPage.setWelcomeMessage(admin.getName() + " (ID: " + admin.getAdminID() + ")");
                    adminPage.setVisible(true);
                    currentFrame.setVisible(false);
                } else {
                    throw new SecurityException("Invalid username or password.");
                }
            } else if ("member".equalsIgnoreCase(userType)) {
                Member member = loginController.authenticateMember(username, password);
                if (member != null) {
                    JOptionPane.showMessageDialog(currentFrame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    MemberPage memberPage = new MemberPage();
                    memberPage.setWelcomeMessage(member.getName() + " (ID: " + member.getMemberID() + ")");
                    memberPage.setVisible(true);
                    currentFrame.setVisible(false);
                } else {
                    throw new SecurityException("Invalid username or password.");
                }
            } else {
                throw new IllegalArgumentException("Invalid user type.");
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
