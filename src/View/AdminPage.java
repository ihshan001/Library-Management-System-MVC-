package View;

import controller.MemberController;
import controller.BookController;
import Model.Member;
import Model.Book;
import Model.DatabaseConnection;
import Model.MembershipCard;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AdminPage extends javax.swing.JFrame {

     private MemberController memberController;
     private BookController bookController;

    public AdminPage() {
        initComponents();
        
        
       try {
            // Initialize controllers with the shared connection
            Connection connection = DatabaseConnection.getConnection();
            this.memberController = new MemberController(connection);
            this.bookController = new BookController(connection);
            

            // Load the member table on initialization
            loadMemberTable();
            loadBookTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error initializing database connection: " + e.getMessage());
        }
    }

    
    


   // Method to load all members into the table
private void loadMemberTable() {
    try {
        DefaultTableModel model = (DefaultTableModel) tblMember.getModel();
        model.setRowCount(0); // Clear existing rows
        List<Member> members = memberController.getAllMembers();
        for (Member member : members) {
            model.addRow(new Object[]{
                member.getMemberID(), 
                member.getName(), 
                member.getContactNo(), 
                member.getAddress(), 
                member.getMembershipCard().getCardNumber(),
                member.getMembershipCard().getExpiryDate(),  // Add expiryDate
                member.getPassword()  // Add password
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading members: " + e.getMessage());
    }
}
// Method to load all books into the table
    private void loadBookTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
            model.setRowCount(0); // Clear existing rows
            List<Book> books = bookController.getAllBooks();
            for (Book book : books) {
                model.addRow(new Object[]{book.getBookID(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getPublishedYear()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage());
        }
    }

    private void addMember() {
        try {
            String name = txtMemberName.getText();
            String contactNo = txtContactNo.getText();
            String address = txtAddress.getText();
            String password = new String(txtPassword.getPassword());
            String confirmPassword = new String(txtConfirmPassword.getPassword());
            String cardNumber = txtCardNumber.getText();
            java.util.Date expiryDate = expiryDateField.getDate();  // Use java.util.Date for expiryDate

            if (validatePassword(password, confirmPassword)) {
                // Ensure the expiryDate is not null before passing it
                if (expiryDate != null) {
                    Member member = new Member(0, name, contactNo, address, password, new MembershipCard(cardNumber, expiryDate));
                    memberController.addMember(member);
                    JOptionPane.showMessageDialog(this, "Member added successfully!");
                    loadMemberTable();
                    resetFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Please select an expiry date!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding member: " + e.getMessage());
        }
    }

// Update Member Button
    private void updateMember() {
        try {
            int selectedRow = tblMember.getSelectedRow();
            if (selectedRow < 0) {
                throw new Exception("No member selected!");
            }

            int memberID = Integer.parseInt(tblMember.getValueAt(selectedRow, 0).toString());
            String name = txtMemberName.getText();
            String contactNo = txtContactNo.getText();
            String address = txtAddress.getText();
            String password = new String(txtPassword.getPassword());
            String confirmPassword = new String(txtConfirmPassword.getPassword());
            String cardNumber = txtCardNumber.getText();
            java.util.Date expiryDate = expiryDateField.getDate();  // Use java.util.Date for expiryDate

            if (validatePassword(password, confirmPassword)) {
                // Ensure the expiryDate is not null before passing it
                if (expiryDate != null) {
                    Member member = new Member(memberID, name, contactNo, address, password, new MembershipCard(cardNumber, expiryDate));
                    memberController.updateMember(member);
                    JOptionPane.showMessageDialog(this, "Member updated successfully!");
                    loadMemberTable();
                    resetFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Please select an expiry date!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating member: " + e.getMessage());
        }
    }
    
    private void memberMouse() {
    int selectedRow = tblMember.getSelectedRow();
    if (selectedRow >= 0) {
        // Get member ID
        int memberID = Integer.parseInt(tblMember.getValueAt(selectedRow, 0).toString());

        // Populate text fields with the selected member's details
        txtMemberID.setText(tblMember.getValueAt(selectedRow, 0).toString());
        txtMemberName.setText(tblMember.getValueAt(selectedRow, 1).toString());
        txtContactNo.setText(tblMember.getValueAt(selectedRow, 2).toString());
        txtAddress.setText(tblMember.getValueAt(selectedRow, 3).toString());
        txtCardNumber.setText(tblMember.getValueAt(selectedRow, 4).toString());
        
        // Get expiry date and set it in the date picker
        String expiryDateStr = tblMember.getValueAt(selectedRow, 5).toString();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date expiryDate = dateFormat.parse(expiryDateStr);
            expiryDateField.setDate(expiryDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // Set password (if needed)
        txtPassword.setText(tblMember.getValueAt(selectedRow, 6).toString());
    }
    }

// Delete Member Button
    private void deleteMember() {
        try {
            int selectedRow = tblMember.getSelectedRow();
            if (selectedRow < 0) {
                throw new Exception("No member selected!");
            }

            int memberID = Integer.parseInt(tblMember.getValueAt(selectedRow, 0).toString());
            memberController.deleteMember(memberID);
            JOptionPane.showMessageDialog(this, "Member deleted successfully!");
            loadMemberTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting member: " + e.getMessage());
        }
    }

// Method to validate password fields
    private boolean validatePassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return false;
        }
        return true;
    }

    // Method to reset all input fields
    private void resetFields() {
            txtMemberID.setText("");
            txtMemberName.setText("");
            txtContactNo.setText("");
            txtAddress.setText("");
            txtPassword.setText("");
            txtCardNumber.setText("");
            txtConfirmPassword.setText("");
            expiryDateField.setDate(null);
    }
    
     // Add Book Button
    private void addBook() {
        try {
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String genre = txtGenre.getText();
            Date publishedYear = yearPublished.getDate();

            if (title.isEmpty() || author.isEmpty() || genre.isEmpty() || publishedYear == null) {
                JOptionPane.showMessageDialog(this, "All fields must be filled!");
                return;
            }

            Book book = new Book(0, title, author, genre, publishedYear);
            bookController.addBook(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            loadBookTable();
            resetFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding book: " + e.getMessage());
        }
    }

    // Update Book Button
    private void updateBook() {
        try {
            int selectedRow = tblBook.getSelectedRow();
            if (selectedRow < 0) throw new Exception("No book selected!");

            int bookID = Integer.parseInt(tblBook.getValueAt(selectedRow, 0).toString());
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String genre = txtGenre.getText();
            Date publishedYear = yearPublished.getDate();

            if (title.isEmpty() || author.isEmpty() || genre.isEmpty() || publishedYear == null) {
                JOptionPane.showMessageDialog(this, "All fields must be filled!");
                return;
            }

            Book book = new Book(bookID, title, author, genre, publishedYear);
            bookController.updateBook(book);
            JOptionPane.showMessageDialog(this, "Book updated successfully!");
            loadBookTable();
            resetFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating book: " + e.getMessage());
        }
    }

    // Delete Book Button
    private void deleteBook() {
        try {
            int selectedRow = tblBook.getSelectedRow();
            if (selectedRow < 0) throw new Exception("No book selected!");

            int bookID = Integer.parseInt(tblBook.getValueAt(selectedRow, 0).toString());
            bookController.deleteBook(bookID);
            JOptionPane.showMessageDialog(this, "Book deleted successfully!");
            loadBookTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting book: " + e.getMessage());
        }
    }

    // Method to reset all input fields
    private void resetBookFields() {
        txtTitle.setText("");
        txtAuthor.setText("");
        txtGenre.setText("");
        yearPublished.setDate(null);
    }

    
    // Method to handle when a table row is clicked for updating or deleting
    private void bookMouse() {
        try {
            int selectedRow = tblBook.getSelectedRow();
            if (selectedRow < 0) return;

            txtTitle.setText(tblBook.getValueAt(selectedRow, 1).toString());
            txtAuthor.setText(tblBook.getValueAt(selectedRow, 2).toString());
            txtGenre.setText(tblBook.getValueAt(selectedRow, 3).toString());
            yearPublished.setDate((Date) tblBook.getValueAt(selectedRow, 4));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading book details: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imgPanel = new rojerusan.RSPanelImage();
        jPanel2 = new javax.swing.JPanel();
        btnMember = new rojeru_san.complementos.RSButtonHover();
        btnBook = new rojeru_san.complementos.RSButtonHover();
        btnLogout = new rojeru_san.complementos.RSButtonHover();
        btnExit = new rojeru_san.complementos.RSButtonHover();
        panelTab = new javax.swing.JTabbedPane();
        panelMember = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblMemberName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblcardNo = new javax.swing.JLabel();
        lblExpiryDate = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        expiryDateField = new com.toedter.calendar.JDateChooser();
        txtMemberID = new rojerusan.RSMetroTextPlaceHolder();
        txtMemberName = new rojerusan.RSMetroTextPlaceHolder();
        txtContactNo = new rojerusan.RSMetroTextPlaceHolder();
        txtAddress = new rojerusan.RSMetroTextPlaceHolder();
        txtCardNumber = new rojerusan.RSMetroTextPlaceHolder();
        btnAdd = new rojerusan.RSButtonMetro();
        btnUpdate = new rojerusan.RSButtonMetro();
        btnDelete = new rojerusan.RSButtonMetro();
        btnReset = new rojerusan.RSButtonMetro();
        txtPassword = new rojerusan.RSPasswordTextPlaceHolder();
        txtConfirmPassword = new rojerusan.RSPasswordTextPlaceHolder();
        lblcardNo1 = new javax.swing.JLabel();
        lblcardNo2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMember = new rojeru_san.complementos.RSTableMetro();
        backGroundImage = new rojerusan.RSLabelImage();
        panelBook = new javax.swing.JPanel();
        lblBookID = new javax.swing.JLabel();
        lblMemberName1 = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblYearPublished = new javax.swing.JLabel();
        lblGenre = new javax.swing.JLabel();
        btnAddBook = new rojerusan.RSButtonMetro();
        btnUpdateBook = new rojerusan.RSButtonMetro();
        btnDeleteBook = new rojerusan.RSButtonMetro();
        btnResetBook = new rojerusan.RSButtonMetro();
        yearPublished = new com.toedter.calendar.JDateChooser();
        txtBookID = new rojerusan.RSMetroTextPlaceHolder();
        txtTitle = new rojerusan.RSMetroTextPlaceHolder();
        txtAuthor = new rojerusan.RSMetroTextPlaceHolder();
        txtGenre = new rojerusan.RSMetroTextPlaceHolder();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBook = new rojeru_san.complementos.RSTableMetro();
        imgBackBook = new rojerusan.RSLabelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgPanel.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/bg/panelbg.jpg"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 115, 230));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        btnMember.setBackground(new java.awt.Color(0, 0, 81));
        btnMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-user (1).jpg"))); // NOI18N
        btnMember.setText("Member");
        btnMember.setColorHover(new java.awt.Color(0, 44, 76));
        btnMember.setFont(new java.awt.Font("Source Sans 3", 1, 18)); // NOI18N
        btnMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMemberMouseClicked(evt);
            }
        });
        jPanel2.add(btnMember);

        btnBook.setBackground(new java.awt.Color(89, 40, 237));
        btnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/book.png"))); // NOI18N
        btnBook.setText("Book");
        btnBook.setColorHover(new java.awt.Color(0, 44, 76));
        btnBook.setFont(new java.awt.Font("Source Sans 3", 1, 18)); // NOI18N
        btnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookMouseClicked(evt);
            }
        });
        jPanel2.add(btnBook);

        btnLogout.setBackground(new java.awt.Color(0, 0, 81));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        btnLogout.setText("LogOut");
        btnLogout.setFont(new java.awt.Font("Source Sans 3", 1, 18)); // NOI18N
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        jPanel2.add(btnLogout);

        btnExit.setBackground(new java.awt.Color(89, 40, 237));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/off.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setColorHover(new java.awt.Color(0, 44, 76));
        btnExit.setFont(new java.awt.Font("Source Sans 3", 1, 18)); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        jPanel2.add(btnExit);

        javax.swing.GroupLayout imgPanelLayout = new javax.swing.GroupLayout(imgPanel);
        imgPanel.setLayout(imgPanelLayout);
        imgPanelLayout.setHorizontalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPanelLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        imgPanelLayout.setVerticalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(imgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        panelMember.setBackground(new java.awt.Color(37, 70, 240));
        panelMember.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 191, 125));
        jLabel1.setText("MemberID");
        panelMember.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, 31));

        lblMemberName.setBackground(new java.awt.Color(255, 255, 255));
        lblMemberName.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblMemberName.setForeground(new java.awt.Color(89, 40, 237));
        lblMemberName.setText("Full Name");
        panelMember.add(lblMemberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 39, 108, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(89, 40, 237));
        jLabel3.setText("Contact No.");
        panelMember.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 108, 31));

        lblcardNo.setBackground(new java.awt.Color(255, 255, 255));
        lblcardNo.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblcardNo.setForeground(new java.awt.Color(0, 191, 125));
        lblcardNo.setText("Card No.");
        panelMember.add(lblcardNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 108, 20));

        lblExpiryDate.setBackground(new java.awt.Color(255, 255, 255));
        lblExpiryDate.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblExpiryDate.setForeground(new java.awt.Color(0, 191, 125));
        lblExpiryDate.setText("Expiry Date");
        panelMember.add(lblExpiryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 229, 108, -1));

        lblAddress.setBackground(new java.awt.Color(255, 255, 255));
        lblAddress.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(0, 191, 125));
        lblAddress.setText("Address");
        panelMember.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 99, 108, -1));

        expiryDateField.setBackground(new java.awt.Color(0, 0, 81));
        expiryDateField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 2));
        expiryDateField.setFont(new java.awt.Font("Source Sans 3 Medium", 0, 15)); // NOI18N
        panelMember.add(expiryDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 230, 40));

        txtMemberID.setBackground(new java.awt.Color(0, 0, 81));
        txtMemberID.setForeground(new java.awt.Color(89, 255, 255));
        txtMemberID.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtMemberID.setPhColor(new java.awt.Color(89, 255, 255));
        txtMemberID.setPlaceholder("Auto Generated");
        panelMember.add(txtMemberID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 40, 30));

        txtMemberName.setBackground(new java.awt.Color(0, 0, 81));
        txtMemberName.setForeground(new java.awt.Color(89, 255, 255));
        txtMemberName.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtMemberName.setPhColor(new java.awt.Color(89, 255, 255));
        txtMemberName.setPlaceholder("Enter Full Name");
        panelMember.add(txtMemberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 230, -1));

        txtContactNo.setBackground(new java.awt.Color(0, 0, 81));
        txtContactNo.setForeground(new java.awt.Color(89, 255, 255));
        txtContactNo.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtContactNo.setPhColor(new java.awt.Color(89, 255, 255));
        txtContactNo.setPlaceholder("Enter Contact Info");
        panelMember.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 230, 40));

        txtAddress.setBackground(new java.awt.Color(0, 0, 81));
        txtAddress.setForeground(new java.awt.Color(89, 255, 255));
        txtAddress.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtAddress.setPhColor(new java.awt.Color(89, 255, 255));
        txtAddress.setPlaceholder("Enter Address");
        panelMember.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 230, -1));

        txtCardNumber.setBackground(new java.awt.Color(0, 0, 81));
        txtCardNumber.setForeground(new java.awt.Color(89, 255, 255));
        txtCardNumber.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtCardNumber.setPhColor(new java.awt.Color(89, 255, 255));
        txtCardNumber.setPlaceholder("Enter CardNumber");
        panelMember.add(txtCardNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 230, -1));

        btnAdd.setText("Add");
        btnAdd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        panelMember.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, 28));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 81));
        btnUpdate.setText("Update");
        btnUpdate.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        panelMember.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, 28));

        btnDelete.setText("Delete");
        btnDelete.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        panelMember.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, 28));

        btnReset.setBackground(new java.awt.Color(0, 0, 81));
        btnReset.setText("Reset");
        btnReset.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        panelMember.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, -1, 28));

        txtPassword.setBackground(new java.awt.Color(0, 0, 81));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 2));
        txtPassword.setForeground(new java.awt.Color(89, 255, 255));
        txtPassword.setFont(new java.awt.Font("Source Sans 3 Medium", 0, 15)); // NOI18N
        txtPassword.setPhColor(new java.awt.Color(89, 255, 255));
        txtPassword.setPlaceholder("Enter Password");
        panelMember.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 230, 40));

        txtConfirmPassword.setBackground(new java.awt.Color(0, 0, 81));
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 2));
        txtConfirmPassword.setForeground(new java.awt.Color(89, 255, 255));
        txtConfirmPassword.setFont(new java.awt.Font("Source Sans 3 Medium", 0, 15)); // NOI18N
        txtConfirmPassword.setPhColor(new java.awt.Color(89, 255, 255));
        txtConfirmPassword.setPlaceholder("Confirm Password");
        panelMember.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 230, 40));

        lblcardNo1.setBackground(new java.awt.Color(255, 255, 255));
        lblcardNo1.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblcardNo1.setForeground(new java.awt.Color(0, 191, 125));
        lblcardNo1.setText("Enter Password");
        panelMember.add(lblcardNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 108, 31));

        lblcardNo2.setBackground(new java.awt.Color(255, 255, 255));
        lblcardNo2.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblcardNo2.setForeground(new java.awt.Color(89, 40, 237));
        lblcardNo2.setText("Confirm Password");
        panelMember.add(lblcardNo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 169, 140, -1));

        tblMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MemberID", "Name", "ContactNo", "Address", "CardNo", "ExpiryDate", "Password"
            }
        ));
        tblMember.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        tblMember.setColorBordeFilas(new java.awt.Color(0, 112, 192));
        tblMember.setColorBordeHead(new java.awt.Color(0, 44, 76));
        tblMember.setColorFilasBackgound1(new java.awt.Color(0, 0, 81));
        tblMember.setColorFilasBackgound2(new java.awt.Color(0, 0, 81));
        tblMember.setColorFilasForeground1(new java.awt.Color(89, 255, 255));
        tblMember.setColorFilasForeground2(new java.awt.Color(89, 255, 255));
        tblMember.setColorForegroundHead(new java.awt.Color(0, 191, 125));
        tblMember.setColorSelForeground(new java.awt.Color(0, 0, 0));
        tblMember.setFont(new java.awt.Font("Source Sans 3 Medium", 0, 15)); // NOI18N
        tblMember.setFuenteFilas(new java.awt.Font("Source Sans 3 Light", 1, 15)); // NOI18N
        tblMember.setFuenteFilasSelect(new java.awt.Font("Source Sans 3 Light", 1, 15)); // NOI18N
        tblMember.setFuenteHead(new java.awt.Font("Source Sans 3 SemiBold", 1, 15)); // NOI18N
        tblMember.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblMember.setRowHeight(25);
        tblMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMemberMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblMember);
        if (tblMember.getColumnModel().getColumnCount() > 0) {
            tblMember.getColumnModel().getColumn(5).setHeaderValue("ExpiryDate");
            tblMember.getColumnModel().getColumn(6).setResizable(false);
            tblMember.getColumnModel().getColumn(6).setHeaderValue("Password");
        }

        panelMember.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 830, 190));

        backGroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg/abstract-blue-dark-gradient-wallpaper-preview.jpg"))); // NOI18N
        panelMember.add(backGroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -70, 890, 630));

        panelTab.addTab("tab1", panelMember);

        panelBook.setBackground(new java.awt.Color(0, 191, 125));
        panelBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBookID.setBackground(new java.awt.Color(89, 40, 237));
        lblBookID.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblBookID.setForeground(new java.awt.Color(89, 255, 255));
        lblBookID.setText("BookID");
        panelBook.add(lblBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 20));

        lblMemberName1.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblMemberName1.setForeground(new java.awt.Color(89, 104, 215));
        lblMemberName1.setText("Title");
        panelBook.add(lblMemberName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 40, 20));

        lblAuthor.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblAuthor.setForeground(new java.awt.Color(89, 104, 215));
        lblAuthor.setText("Author");
        panelBook.add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 50, 20));

        lblYearPublished.setBackground(new java.awt.Color(89, 40, 237));
        lblYearPublished.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblYearPublished.setForeground(new java.awt.Color(89, 255, 255));
        lblYearPublished.setText("YearPublished");
        panelBook.add(lblYearPublished, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 108, -1));

        lblGenre.setBackground(new java.awt.Color(89, 40, 237));
        lblGenre.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblGenre.setForeground(new java.awt.Color(89, 255, 255));
        lblGenre.setText("Genre");
        panelBook.add(lblGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 50, 20));

        btnAddBook.setBackground(new java.awt.Color(89, 40, 237));
        btnAddBook.setText("Add");
        btnAddBook.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAddBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddBookMouseClicked(evt);
            }
        });
        panelBook.add(btnAddBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, 28));

        btnUpdateBook.setBackground(new java.awt.Color(0, 0, 81));
        btnUpdateBook.setText("Update");
        btnUpdateBook.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUpdateBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateBookMouseClicked(evt);
            }
        });
        panelBook.add(btnUpdateBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 28));

        btnDeleteBook.setBackground(new java.awt.Color(89, 40, 237));
        btnDeleteBook.setText("Delete");
        btnDeleteBook.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeleteBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteBookMouseClicked(evt);
            }
        });
        panelBook.add(btnDeleteBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, 28));

        btnResetBook.setBackground(new java.awt.Color(0, 0, 81));
        btnResetBook.setText("Reset");
        btnResetBook.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnResetBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetBookMouseClicked(evt);
            }
        });
        panelBook.add(btnResetBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, 28));

        yearPublished.setBackground(new java.awt.Color(0, 0, 81));
        yearPublished.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 40, 237), 2));
        yearPublished.setForeground(new java.awt.Color(89, 255, 255));
        yearPublished.setFont(new java.awt.Font("Source Sans 3 Medium", 0, 15)); // NOI18N
        panelBook.add(yearPublished, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 230, 40));

        txtBookID.setBackground(new java.awt.Color(0, 0, 81));
        txtBookID.setForeground(new java.awt.Color(89, 255, 255));
        txtBookID.setBorderColor(new java.awt.Color(89, 40, 237));
        txtBookID.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtBookID.setPhColor(new java.awt.Color(89, 255, 255));
        txtBookID.setPlaceholder("Auto Generated");
        panelBook.add(txtBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 40, 30));

        txtTitle.setBackground(new java.awt.Color(0, 0, 81));
        txtTitle.setForeground(new java.awt.Color(89, 255, 255));
        txtTitle.setBorderColor(new java.awt.Color(89, 40, 237));
        txtTitle.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtTitle.setPhColor(new java.awt.Color(89, 255, 255));
        txtTitle.setPlaceholder("Enter a Genre");
        panelBook.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 230, 40));

        txtAuthor.setBackground(new java.awt.Color(0, 0, 81));
        txtAuthor.setForeground(new java.awt.Color(89, 255, 255));
        txtAuthor.setBorderColor(new java.awt.Color(89, 40, 237));
        txtAuthor.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtAuthor.setPhColor(new java.awt.Color(89, 255, 255));
        txtAuthor.setPlaceholder("Enter Book Title");
        panelBook.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 230, 40));

        txtGenre.setBackground(new java.awt.Color(0, 0, 81));
        txtGenre.setForeground(new java.awt.Color(89, 255, 255));
        txtGenre.setBorderColor(new java.awt.Color(89, 40, 237));
        txtGenre.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtGenre.setPhColor(new java.awt.Color(89, 255, 255));
        txtGenre.setPlaceholder("Enter Author Name");
        panelBook.add(txtGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 230, 40));

        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "BookID", "Title", "Author", "Genre", "YearPublished"
            }
        ));
        tblBook.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        tblBook.setColorBordeFilas(new java.awt.Color(0, 112, 192));
        tblBook.setColorBordeHead(new java.awt.Color(0, 44, 76));
        tblBook.setColorFilasBackgound1(new java.awt.Color(0, 0, 81));
        tblBook.setColorFilasBackgound2(new java.awt.Color(0, 0, 81));
        tblBook.setColorFilasForeground1(new java.awt.Color(89, 255, 255));
        tblBook.setColorFilasForeground2(new java.awt.Color(89, 255, 255));
        tblBook.setColorForegroundHead(new java.awt.Color(89, 255, 255));
        tblBook.setColorSelForeground(new java.awt.Color(0, 0, 0));
        tblBook.setFont(new java.awt.Font("Source Sans 3 Medium", 0, 15)); // NOI18N
        tblBook.setFuenteFilas(new java.awt.Font("Source Sans 3 Light", 1, 15)); // NOI18N
        tblBook.setFuenteFilasSelect(new java.awt.Font("Source Sans 3 Light", 1, 15)); // NOI18N
        tblBook.setFuenteHead(new java.awt.Font("Source Sans 3 SemiBold", 1, 15)); // NOI18N
        tblBook.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblBook.setRowHeight(25);
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBook);

        panelBook.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 820, 230));

        imgBackBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg/1000_F_171744995_u4KjXeKS61D3oxApKNHpJkKV81iA7dSs.jpg"))); // NOI18N
        panelBook.add(imgBackBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 920, 560));

        panelTab.addTab("tab2", panelBook);

        jPanel1.add(panelTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMemberMouseClicked
        // TODO add your handling code here:
        panelTab.setSelectedIndex(0);
    }//GEN-LAST:event_btnMemberMouseClicked

    private void btnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseClicked
        // TODO add your handling code here:
        panelTab.setSelectedIndex(1);
    }//GEN-LAST:event_btnBookMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        addMember();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        updateMember();
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        deleteMember();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        resetFields();
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitMouseClicked

    private void tblMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMemberMouseClicked
        // TODO add your handling code here:
        memberMouse();
    }//GEN-LAST:event_tblMemberMouseClicked

    private void tblBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBookMouseClicked

    private void btnResetBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetBookMouseClicked
        // TODO add your handling code here:
        resetBookFields();
    }//GEN-LAST:event_btnResetBookMouseClicked

    private void btnDeleteBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteBookMouseClicked
        // TODO add your handling code here:
        deleteBook();
    }//GEN-LAST:event_btnDeleteBookMouseClicked

    private void btnUpdateBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateBookMouseClicked
        // TODO add your handling code here:
        updateBook();
    }//GEN-LAST:event_btnUpdateBookMouseClicked

    private void btnAddBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddBookMouseClicked
        // TODO add your handling code here:
        addBook();
    }//GEN-LAST:event_btnAddBookMouseClicked

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
     try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    //</editor-fold>

    /* Create and display the AdminPage form */
    java.awt.EventQueue.invokeLater(() -> {
        new AdminPage().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSLabelImage backGroundImage;
    private rojerusan.RSButtonMetro btnAdd;
    private rojerusan.RSButtonMetro btnAddBook;
    private rojeru_san.complementos.RSButtonHover btnBook;
    private rojerusan.RSButtonMetro btnDelete;
    private rojerusan.RSButtonMetro btnDeleteBook;
    private rojeru_san.complementos.RSButtonHover btnExit;
    private rojeru_san.complementos.RSButtonHover btnLogout;
    private rojeru_san.complementos.RSButtonHover btnMember;
    private rojerusan.RSButtonMetro btnReset;
    private rojerusan.RSButtonMetro btnResetBook;
    private rojerusan.RSButtonMetro btnUpdate;
    private rojerusan.RSButtonMetro btnUpdateBook;
    private com.toedter.calendar.JDateChooser expiryDateField;
    private rojerusan.RSLabelImage imgBackBook;
    private rojerusan.RSPanelImage imgPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblBookID;
    private javax.swing.JLabel lblExpiryDate;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblMemberName;
    private javax.swing.JLabel lblMemberName1;
    private javax.swing.JLabel lblYearPublished;
    private javax.swing.JLabel lblcardNo;
    private javax.swing.JLabel lblcardNo1;
    private javax.swing.JLabel lblcardNo2;
    private javax.swing.JPanel panelBook;
    private javax.swing.JPanel panelMember;
    private javax.swing.JTabbedPane panelTab;
    private rojeru_san.complementos.RSTableMetro tblBook;
    private rojeru_san.complementos.RSTableMetro tblMember;
    private rojerusan.RSMetroTextPlaceHolder txtAddress;
    private rojerusan.RSMetroTextPlaceHolder txtAuthor;
    private rojerusan.RSMetroTextPlaceHolder txtBookID;
    private rojerusan.RSMetroTextPlaceHolder txtCardNumber;
    private rojerusan.RSPasswordTextPlaceHolder txtConfirmPassword;
    private rojerusan.RSMetroTextPlaceHolder txtContactNo;
    private rojerusan.RSMetroTextPlaceHolder txtGenre;
    private rojerusan.RSMetroTextPlaceHolder txtMemberID;
    private rojerusan.RSMetroTextPlaceHolder txtMemberName;
    private rojerusan.RSPasswordTextPlaceHolder txtPassword;
    private rojerusan.RSMetroTextPlaceHolder txtTitle;
    private com.toedter.calendar.JDateChooser yearPublished;
    // End of variables declaration//GEN-END:variables
}