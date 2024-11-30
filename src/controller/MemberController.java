package controller;

import Model.Member;
import Model.MembershipCard;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Date;
import rojeru_san.complementos.RSTableMetro;
import rojerusan.RSMetroTextPlaceHolder;
import rojerusan.RSPasswordTextPlaceHolder;

public class MemberController {
    private Connection connection;
    private RSMetroTextPlaceHolder txtMemberID, txtMemberName, txtContactNo, txtAddress, txtCardNumber;
    private RSPasswordTextPlaceHolder txtPassword, txtConfirmPassword;
    private RSTableMetro tblMember;
    private JDateChooser expiryDateField;

     // Constructor
    public MemberController(Connection connection, RSMetroTextPlaceHolder txtMemberID, RSMetroTextPlaceHolder txtMemberName, 
                            RSMetroTextPlaceHolder txtContactNo, RSMetroTextPlaceHolder txtAddress, 
                            RSPasswordTextPlaceHolder txtPassword, RSPasswordTextPlaceHolder txtConfirmPassword, 
                            RSMetroTextPlaceHolder txtCardNumber, RSTableMetro tblMember, JDateChooser expiryDateField) {
        this.connection = connection;
        this.txtMemberID = txtMemberID;
        this.txtMemberName = txtMemberName;
        this.txtContactNo = txtContactNo;
        this.txtAddress = txtAddress;
        this.txtPassword = txtPassword;
        this.txtConfirmPassword = txtConfirmPassword;
        this.txtCardNumber = txtCardNumber;
        this.tblMember = tblMember;
        this.expiryDateField = expiryDateField;
    }

    // Add or Update Member
    public void saveMember() {
        try {
            String name = txtMemberName.getText();
            String contactNo = txtContactNo.getText();
            String address = txtAddress.getText();
            String password = new String(txtPassword.getPassword());
            String confirmPassword = new String(txtConfirmPassword.getPassword());
            String cardNumber = txtCardNumber.getText();
            Date expiryDate = expiryDateField.getDate();

            if (isValidInput(name, contactNo, address, password, confirmPassword, cardNumber, expiryDate)) {
                if (validatePassword(password, confirmPassword)) {
                    Member member = new Member(
                        txtMemberID.getText().isEmpty() ? 0 : Integer.parseInt(txtMemberID.getText()), 
                        name, contactNo, address, password, 
                        new MembershipCard(cardNumber, expiryDate)
                    );

                    String sql;
                    if (member.getMemberID() == 0) {
                        sql = "INSERT INTO members (name, contactNo, address, password, cardNumber, expiryDate) VALUES (?, ?, ?, ?, ?, ?)";
                    } else {
                        sql = "UPDATE members SET name=?, contactNo=?, address=?, password=?, cardNumber=?, expiryDate=? WHERE memberID=?";
                    }

                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, member.getName());
                        statement.setString(2, member.getContactNo());
                        statement.setString(3, member.getAddress());
                        statement.setString(4, member.getPassword());
                        statement.setString(5, member.getMembershipCard().getCardNumber());
                        statement.setDate(6, new java.sql.Date(member.getMembershipCard().getExpiryDate().getTime()));
                        
                        if (member.getMemberID() != 0) {
                            statement.setInt(7, member.getMemberID());
                        }

                        statement.executeUpdate();
                    }

                    JOptionPane.showMessageDialog(null, member.getMemberID() == 0 ? "Member added successfully!" : "Member updated successfully!");
                    loadMember();
                    clearFields();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error saving member: " + e.getMessage());
            e.printStackTrace(); // Log the error for debugging
        }
    }

    // Delete Member
    public void deleteMember() {
        try {
            int selectedRow = tblMember.getSelectedRow();
            if (selectedRow < 0) throw new Exception("No member selected!");

            int memberID = Integer.parseInt(tblMember.getValueAt(selectedRow, 0).toString());
            String sql = "DELETE FROM members WHERE memberID=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, memberID);
                statement.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Member deleted successfully!");
            loadMember();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error deleting member: " + e.getMessage());
        }
    }

    // Load Member data into the table
    public void loadMember() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblMember.getModel();
            model.setRowCount(0); // Clear existing rows
            String sql = "SELECT * FROM members";
            try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    model.addRow(new Object[]{
                        resultSet.getInt("memberID"),
                        resultSet.getString("name"),
                        resultSet.getString("contactNo"),
                        resultSet.getString("address"),
                        resultSet.getString("cardNumber"),
                        resultSet.getDate("expiryDate"),
                        resultSet.getString("password")
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading members: " + e.getMessage());
        }
    }

    // Validate password fields
    private boolean validatePassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match!");
            return false;
        
        
        }
        return true;
    }

    // Validate all fields before submitting
    private boolean isValidInput(String name, String contactNo, String address, String password, String confirmPassword, String cardNumber, Date expiryDate) {
        if (name.isEmpty() || contactNo.isEmpty() || address.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || cardNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }
        if (expiryDate == null) {
            JOptionPane.showMessageDialog(null, "Please select an expiry date.");
            return false;
        }
        return true;
    }

    // Clear all fields
    public void clearFields() {
        txtMemberID.setText("");
        txtMemberName.setText("");
        txtContactNo.setText("");
        txtAddress.setText("");
        txtPassword.setText("");
        txtCardNumber.setText("");
        txtConfirmPassword.setText("");
        expiryDateField.setDate(null);
    }

    // Load selected member's data into the fields when clicked
    public void tblMember() {
        int selectedRow = tblMember.getSelectedRow();
        if (selectedRow >= 0) {
            // Get the data from the selected row
            String memberID = tblMember.getValueAt(selectedRow, 0).toString();
            String name = tblMember.getValueAt(selectedRow, 1).toString();
            String contactNo = tblMember.getValueAt(selectedRow, 2).toString();
            String address = tblMember.getValueAt(selectedRow, 3).toString();
            String cardNumber = tblMember.getValueAt(selectedRow, 4).toString();
            Date expiryDate = (Date) tblMember.getValueAt(selectedRow, 5);

            // Set the data into the form fields
            txtMemberID.setText(memberID);
            txtMemberName.setText(name);
            txtContactNo.setText(contactNo);
            txtAddress.setText(address);
            txtCardNumber.setText(cardNumber);
            expiryDateField.setDate(expiryDate);
        }
    }
}