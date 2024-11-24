package controller;

import Model.Member;
import Model.MembershipCard;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberController {
    private Connection connection;

    public MemberController(Connection connection) {
        this.connection = connection;
    }

    public void addMember(Member member) throws Exception {
        if (member.getName().isEmpty() || member.getContactNo().isEmpty() || member.getAddress().isEmpty() || member.getPassword().isEmpty()) {
            throw new Exception("All fields must be filled!");
        }

        String sql = "INSERT INTO members (name, contactNo, address, password, cardNumber, expiryDate) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, member.getName());
            statement.setString(2, member.getContactNo());
            statement.setString(3, member.getAddress());
            statement.setString(4, member.getPassword());
            statement.setString(5, member.getMembershipCard().getCardNumber());

            // Handle expiryDate (convert to java.sql.Date)
            java.util.Date expiryDate = member.getMembershipCard().getExpiryDate();
            if (expiryDate != null) {
                statement.setDate(6, new java.sql.Date(expiryDate.getTime()));
            } else {
                statement.setNull(6, java.sql.Types.DATE);  // Handle null expiry date
            }

            statement.executeUpdate();
        }
    }

    public void updateMember(Member member) throws Exception {
        if (member.getMemberID() == 0) {
            throw new Exception("No member selected for update!");
        }

        String sql = "UPDATE members SET name=?, contactNo=?, address=?, password=?, cardNumber=?, expiryDate=? WHERE memberID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, member.getName());
            statement.setString(2, member.getContactNo());
            statement.setString(3, member.getAddress());
            statement.setString(4, member.getPassword());
            statement.setString(5, member.getMembershipCard().getCardNumber());

            // Handle expiryDate (convert to java.sql.Date)
            java.util.Date expiryDate = member.getMembershipCard().getExpiryDate();
            if (expiryDate != null) {
                statement.setDate(6, new java.sql.Date(expiryDate.getTime()));
            } else {
                statement.setNull(6, java.sql.Types.DATE);  // Handle null expiry date
            }

            statement.setInt(7, member.getMemberID());
            statement.executeUpdate();
        }
    }

    public void deleteMember(int memberID) throws Exception {
        if (memberID == 0) {
            throw new Exception("No member selected for deletion!");
        }

        String sql = "DELETE FROM members WHERE memberID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, memberID);
            statement.executeUpdate();
        }
    }

    public List<Member> getAllMembers() throws SQLException {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Member member = new Member();
                member.setMemberID(resultSet.getInt("memberID"));
                member.setName(resultSet.getString("name"));
                member.setContactNo(resultSet.getString("contactNo"));
                member.setAddress(resultSet.getString("address"));
                member.setPassword(resultSet.getString("password"));
                member.setMembershipCard(new MembershipCard(resultSet.getString("cardNumber"), resultSet.getDate("expiryDate")));
                members.add(member);
            }
        }
        return members;
    }
}
