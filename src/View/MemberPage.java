/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.DatabaseConnection;
import controller.BookController;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controller.MemberController;
import rojerusan.RSPasswordTextPlaceHolder;
import javax.swing.*;



public class MemberPage extends javax.swing.JFrame {

    private BookController bookController;
    private MemberController memberPageController;
    
    
    
    
    
   

    public MemberPage() {
    initComponents();
    try {
        Connection connection = DatabaseConnection.getConnection();
        
        
        bookController = new BookController(connection, txtTitleSearch, txtAuthorSearch, txtGenreSearch, tblBookSearch) {
            @Override
            public void loadBook() {
                
                super.loadBook();
                
                
            }
        };
        
        
        bookController.loadBook();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error initializing database connection: " + e.getMessage());
    }
}
    
    
    
    public void setWelcomeMessage(String message) {
        lblMemberShow.setText(message);
    }

    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SideBar = new rojerusan.RSPanelImage();
        btnSearchPanel = new rojeru_san.complementos.RSButtonHover();
        btnLogout = new rojeru_san.complementos.RSButtonHover();
        jLabel4 = new javax.swing.JLabel();
        lblMemberShow = new javax.swing.JLabel();
        btnMemberPanel = new rojeru_san.complementos.RSButtonHover();
        btnExit = new rojeru_san.complementos.RSButtonHover();
        panelMainMember = new javax.swing.JTabbedPane();
        memberSearch = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBookSearch = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitleSearch = new rojerusan.RSMetroTextPlaceHolder();
        txtAuthorSearch = new rojerusan.RSMetroTextPlaceHolder();
        txtGenreSearch = new rojerusan.RSMetroTextPlaceHolder();
        btnSearch = new necesario.RSMaterialButtonCircle();
        btnSearchReset = new necesario.RSMaterialButtonCircle();
        imgSearch = new rojerusan.RSLabelImage();
        memberDetails = new javax.swing.JPanel();
        lblMemberName = new javax.swing.JLabel();
        txtMNameC = new rojerusan.RSMetroTextPlaceHolder();
        jLabel5 = new javax.swing.JLabel();
        txtMContactC = new rojerusan.RSMetroTextPlaceHolder();
        lblAddress = new javax.swing.JLabel();
        txtMAddressC = new rojerusan.RSMetroTextPlaceHolder();
        lblcardNo1 = new javax.swing.JLabel();
        txtMPassC = new rojerusan.RSPasswordTextPlaceHolder();
        lblcardNo2 = new javax.swing.JLabel();
        txtMPassC1 = new rojerusan.RSPasswordTextPlaceHolder();
        lblcardNo = new javax.swing.JLabel();
        txtCardNumberC = new rojerusan.RSMetroTextPlaceHolder();
        lblExpiryDate = new javax.swing.JLabel();
        btnUpdateM = new necesario.RSMaterialButtonCircle();
        btnResetM = new necesario.RSMaterialButtonCircle();
        expiryDateField = new rojerusan.RSMetroTextPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SideBar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Images/bg/panelbg.jpg"))); // NOI18N
        SideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearchPanel.setBackground(new java.awt.Color(89, 40, 237));
        btnSearchPanel.setForeground(new java.awt.Color(89, 40, 237));
        btnSearchPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        btnSearchPanel.setText("Search");
        btnSearchPanel.setColorHover(new java.awt.Color(89, 255, 255));
        btnSearchPanel.setColorTextHover(new java.awt.Color(89, 104, 215));
        btnSearchPanel.setFont(new java.awt.Font("Source Sans 3", 1, 18)); // NOI18N
        btnSearchPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchPanelMouseClicked(evt);
            }
        });
        SideBar.add(btnSearchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 150, 37));

        btnLogout.setBackground(new java.awt.Color(0, 0, 81));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        btnLogout.setText("LogOut");
        btnLogout.setColorHover(new java.awt.Color(0, 191, 125));
        btnLogout.setColorTextHover(java.awt.Color.red);
        btnLogout.setFont(new java.awt.Font("Source Sans 3", 1, 18)); // NOI18N
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        SideBar.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 150, 37));

        jLabel4.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(89, 255, 255));
        jLabel4.setText("WelCome");
        SideBar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 30));

        lblMemberShow.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 13)); // NOI18N
        lblMemberShow.setForeground(new java.awt.Color(89, 255, 255));
        SideBar.add(lblMemberShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 36));

        btnMemberPanel.setBackground(new java.awt.Color(89, 40, 237));
        btnMemberPanel.setForeground(new java.awt.Color(89, 40, 237));
        btnMemberPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user12 (2).png"))); // NOI18N
        btnMemberPanel.setText("Member");
        btnMemberPanel.setColorHover(new java.awt.Color(89, 255, 255));
        btnMemberPanel.setColorTextHover(new java.awt.Color(89, 104, 215));
        btnMemberPanel.setFont(new java.awt.Font("Source Sans 3", 1, 18)); // NOI18N
        btnMemberPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMemberPanelMouseClicked(evt);
            }
        });
        SideBar.add(btnMemberPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 150, 37));

        btnExit.setBackground(new java.awt.Color(89, 40, 237));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/off.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setColorHover(new java.awt.Color(0, 191, 125));
        btnExit.setFont(new java.awt.Font("Source Sans 3", 1, 18)); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        SideBar.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 140, -1));

        jPanel1.add(SideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 650));

        memberSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBookSearch.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBookSearch.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        tblBookSearch.setColorBordeFilas(new java.awt.Color(0, 112, 192));
        tblBookSearch.setColorBordeHead(new java.awt.Color(0, 44, 76));
        tblBookSearch.setColorFilasBackgound1(new java.awt.Color(0, 0, 81));
        tblBookSearch.setColorFilasBackgound2(new java.awt.Color(0, 0, 81));
        tblBookSearch.setColorFilasForeground1(new java.awt.Color(89, 255, 255));
        tblBookSearch.setColorFilasForeground2(new java.awt.Color(89, 255, 255));
        tblBookSearch.setColorForegroundHead(new java.awt.Color(89, 255, 255));
        tblBookSearch.setColorSelForeground(new java.awt.Color(0, 0, 0));
        tblBookSearch.setFont(new java.awt.Font("Source Sans 3 Medium", 0, 15)); // NOI18N
        tblBookSearch.setFuenteFilas(new java.awt.Font("Source Sans 3 Light", 1, 15)); // NOI18N
        tblBookSearch.setFuenteFilasSelect(new java.awt.Font("Source Sans 3 Light", 1, 15)); // NOI18N
        tblBookSearch.setFuenteHead(new java.awt.Font("Source Sans 3 SemiBold", 1, 15)); // NOI18N
        tblBookSearch.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblBookSearch.setRowHeight(25);
        jScrollPane4.setViewportView(tblBookSearch);

        memberSearch.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 790, 420));

        jLabel1.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(89, 104, 215));
        jLabel1.setText("Book Title");
        memberSearch.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 100, 36));

        jLabel2.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(89, 104, 215));
        jLabel2.setText("Book Author");
        memberSearch.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 100, 36));

        jLabel3.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(89, 104, 215));
        jLabel3.setText("Book Genre");
        memberSearch.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 100, -1));

        txtTitleSearch.setBackground(new java.awt.Color(0, 0, 81));
        txtTitleSearch.setForeground(new java.awt.Color(89, 255, 255));
        txtTitleSearch.setBorderColor(new java.awt.Color(89, 40, 237));
        txtTitleSearch.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtTitleSearch.setPhColor(new java.awt.Color(89, 255, 255));
        txtTitleSearch.setPlaceholder("Enter Book Name");
        memberSearch.add(txtTitleSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 230, 40));

        txtAuthorSearch.setBackground(new java.awt.Color(0, 0, 81));
        txtAuthorSearch.setForeground(new java.awt.Color(89, 255, 255));
        txtAuthorSearch.setBorderColor(new java.awt.Color(89, 40, 237));
        txtAuthorSearch.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtAuthorSearch.setPhColor(new java.awt.Color(89, 255, 255));
        txtAuthorSearch.setPlaceholder("Enter Author Name");
        memberSearch.add(txtAuthorSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 230, 40));

        txtGenreSearch.setBackground(new java.awt.Color(0, 0, 81));
        txtGenreSearch.setForeground(new java.awt.Color(89, 255, 255));
        txtGenreSearch.setBorderColor(new java.awt.Color(89, 40, 237));
        txtGenreSearch.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtGenreSearch.setPhColor(new java.awt.Color(89, 255, 255));
        txtGenreSearch.setPlaceholder("Enter Genre");
        memberSearch.add(txtGenreSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 230, 40));

        btnSearch.setBackground(new java.awt.Color(89, 40, 237));
        btnSearch.setText("Search");
        btnSearch.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 12)); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        memberSearch.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 60, 50));

        btnSearchReset.setBackground(new java.awt.Color(89, 40, 237));
        btnSearchReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-minus-16.png"))); // NOI18N
        btnSearchReset.setText("Reset");
        btnSearchReset.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 12)); // NOI18N
        btnSearchReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchResetMouseClicked(evt);
            }
        });
        memberSearch.add(btnSearchReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 60, 50));

        imgSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg/1000_F_171744995_u4KjXeKS61D3oxApKNHpJkKV81iA7dSs.jpg"))); // NOI18N
        memberSearch.add(imgSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 670));

        panelMainMember.addTab("tab1", memberSearch);

        lblMemberName.setBackground(new java.awt.Color(255, 255, 255));
        lblMemberName.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblMemberName.setForeground(new java.awt.Color(0, 191, 125));
        lblMemberName.setText("Name");

        txtMNameC.setBackground(new java.awt.Color(0, 0, 81));
        txtMNameC.setForeground(new java.awt.Color(89, 255, 255));
        txtMNameC.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtMNameC.setPhColor(new java.awt.Color(89, 255, 255));
        txtMNameC.setPlaceholder("Name");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 191, 125));
        jLabel5.setText("Contact No.");

        txtMContactC.setBackground(new java.awt.Color(0, 0, 81));
        txtMContactC.setForeground(new java.awt.Color(89, 255, 255));
        txtMContactC.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtMContactC.setPhColor(new java.awt.Color(89, 255, 255));
        txtMContactC.setPlaceholder("Contact Info");

        lblAddress.setBackground(new java.awt.Color(255, 255, 255));
        lblAddress.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(0, 191, 125));
        lblAddress.setText("Address");

        txtMAddressC.setBackground(new java.awt.Color(0, 0, 81));
        txtMAddressC.setForeground(new java.awt.Color(89, 255, 255));
        txtMAddressC.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtMAddressC.setPhColor(new java.awt.Color(89, 255, 255));
        txtMAddressC.setPlaceholder(" Address");

        lblcardNo1.setBackground(new java.awt.Color(255, 255, 255));
        lblcardNo1.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblcardNo1.setForeground(new java.awt.Color(0, 191, 125));
        lblcardNo1.setText("Enter Password");

        txtMPassC.setBackground(new java.awt.Color(0, 0, 81));
        txtMPassC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 2));
        txtMPassC.setForeground(new java.awt.Color(89, 255, 255));
        txtMPassC.setFont(new java.awt.Font("Source Sans 3 Medium", 0, 15)); // NOI18N
        txtMPassC.setPhColor(new java.awt.Color(89, 255, 255));
        txtMPassC.setPlaceholder("Password");

        lblcardNo2.setBackground(new java.awt.Color(255, 255, 255));
        lblcardNo2.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblcardNo2.setForeground(new java.awt.Color(0, 191, 125));
        lblcardNo2.setText("Confirm Password");

        txtMPassC1.setBackground(new java.awt.Color(0, 0, 81));
        txtMPassC1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 2));
        txtMPassC1.setForeground(new java.awt.Color(89, 255, 255));
        txtMPassC1.setFont(new java.awt.Font("Source Sans 3 Medium", 0, 15)); // NOI18N
        txtMPassC1.setPhColor(new java.awt.Color(89, 255, 255));
        txtMPassC1.setPlaceholder("Confirm Password");

        lblcardNo.setBackground(new java.awt.Color(255, 255, 255));
        lblcardNo.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblcardNo.setForeground(new java.awt.Color(0, 191, 125));
        lblcardNo.setText("Card No.");

        txtCardNumberC.setBackground(new java.awt.Color(0, 0, 81));
        txtCardNumberC.setForeground(new java.awt.Color(89, 255, 255));
        txtCardNumberC.setActionCommand("<Not Set>");
        txtCardNumberC.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        txtCardNumberC.setPhColor(new java.awt.Color(89, 255, 255));
        txtCardNumberC.setPlaceholder("CardNumber");

        lblExpiryDate.setBackground(new java.awt.Color(255, 255, 255));
        lblExpiryDate.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 15)); // NOI18N
        lblExpiryDate.setForeground(new java.awt.Color(0, 191, 125));
        lblExpiryDate.setText("Expiry Date");

        btnUpdateM.setBackground(new java.awt.Color(89, 40, 237));
        btnUpdateM.setText("Update");
        btnUpdateM.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 12)); // NOI18N
        btnUpdateM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMMouseClicked(evt);
            }
        });

        btnResetM.setBackground(new java.awt.Color(89, 40, 237));
        btnResetM.setText("Reset");
        btnResetM.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 0, 12)); // NOI18N
        btnResetM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMMouseClicked(evt);
            }
        });

        expiryDateField.setBackground(new java.awt.Color(0, 0, 81));
        expiryDateField.setForeground(new java.awt.Color(89, 255, 255));
        expiryDateField.setActionCommand("<Not Set>");
        expiryDateField.setFont(new java.awt.Font("Source Sans 3 Light", 1, 14)); // NOI18N
        expiryDateField.setPhColor(new java.awt.Color(89, 255, 255));
        expiryDateField.setPlaceholder("CardNumber");

        javax.swing.GroupLayout memberDetailsLayout = new javax.swing.GroupLayout(memberDetails);
        memberDetails.setLayout(memberDetailsLayout);
        memberDetailsLayout.setHorizontalGroup(
            memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberDetailsLayout.createSequentialGroup()
                .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberDetailsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, memberDetailsLayout.createSequentialGroup()
                                    .addComponent(lblcardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(txtCardNumberC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(expiryDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, memberDetailsLayout.createSequentialGroup()
                                    .addComponent(lblcardNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(txtMPassC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblcardNo2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(txtMPassC1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(memberDetailsLayout.createSequentialGroup()
                                .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(memberDetailsLayout.createSequentialGroup()
                                        .addComponent(txtMContactC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtMAddressC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtMNameC, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(memberDetailsLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(btnUpdateM, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnResetM, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        memberDetailsLayout.setVerticalGroup(
            memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberDetailsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberDetailsLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblMemberName))
                    .addComponent(txtMNameC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberDetailsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(memberDetailsLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(txtMContactC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtMAddressC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExpiryDate)
                    .addComponent(txtCardNumberC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expiryDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcardNo2)
                    .addComponent(txtMPassC1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMPassC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcardNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(memberDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateM, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetM, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(290, Short.MAX_VALUE))
        );

        panelMainMember.addTab("tab2", memberDetails);

        jPanel1.add(panelMainMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, -30, 820, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        bookController.searchBook();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnSearchResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchResetMouseClicked
        // TODO add your handling code here:
        bookController.resetSearch();
    }//GEN-LAST:event_btnSearchResetMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        int response = javax.swing.JOptionPane.showConfirmDialog(this, "Do you really want to log out?", "Confirm Logout", javax.swing.JOptionPane.YES_NO_OPTION);

        if (response == javax.swing.JOptionPane.YES_OPTION) {
            MemberLogin memberLogin = new MemberLogin();
            memberLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnSearchPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchPanelMouseClicked
        // TODO add your handling code here:
        panelMainMember.setSelectedIndex(0);
    }//GEN-LAST:event_btnSearchPanelMouseClicked

    private void btnUpdateMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnUpdateMMouseClicked

    private void btnResetMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnResetMMouseClicked

    private void btnMemberPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMemberPanelMouseClicked
        // TODO add your handling code here:
        panelMainMember.setSelectedIndex(1);
    }//GEN-LAST:event_btnMemberPanelMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked

        int response = javax.swing.JOptionPane.showConfirmDialog(this, "Do you really want to exit?", "Exit", javax.swing.JOptionPane.YES_NO_OPTION);

        // Exit if user clicks "Yes"
        if (response == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MemberPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSPanelImage SideBar;
    private rojeru_san.complementos.RSButtonHover btnExit;
    private rojeru_san.complementos.RSButtonHover btnLogout;
    private rojeru_san.complementos.RSButtonHover btnMemberPanel;
    private necesario.RSMaterialButtonCircle btnResetM;
    private necesario.RSMaterialButtonCircle btnSearch;
    private rojeru_san.complementos.RSButtonHover btnSearchPanel;
    private necesario.RSMaterialButtonCircle btnSearchReset;
    private necesario.RSMaterialButtonCircle btnUpdateM;
    private rojerusan.RSMetroTextPlaceHolder expiryDateField;
    private rojerusan.RSLabelImage imgSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblExpiryDate;
    private javax.swing.JLabel lblMemberName;
    private javax.swing.JLabel lblMemberShow;
    private javax.swing.JLabel lblcardNo;
    private javax.swing.JLabel lblcardNo1;
    private javax.swing.JLabel lblcardNo2;
    private javax.swing.JPanel memberDetails;
    private javax.swing.JPanel memberSearch;
    private javax.swing.JTabbedPane panelMainMember;
    private rojeru_san.complementos.RSTableMetro tblBookSearch;
    private rojerusan.RSMetroTextPlaceHolder txtAuthorSearch;
    private rojerusan.RSMetroTextPlaceHolder txtCardNumberC;
    private rojerusan.RSMetroTextPlaceHolder txtGenreSearch;
    private rojerusan.RSMetroTextPlaceHolder txtMAddressC;
    private rojerusan.RSMetroTextPlaceHolder txtMContactC;
    private rojerusan.RSMetroTextPlaceHolder txtMNameC;
    private rojerusan.RSPasswordTextPlaceHolder txtMPassC;
    private rojerusan.RSPasswordTextPlaceHolder txtMPassC1;
    private rojerusan.RSMetroTextPlaceHolder txtTitleSearch;
    // End of variables declaration//GEN-END:variables
}
