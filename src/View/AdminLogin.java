/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import controller.LoginController;
import controller.LoginHandler;
import javax.swing.*;
public class AdminLogin extends javax.swing.JFrame {

    
    private LoginController loginController;
    private LoginHandler loginHandler;
    
    public AdminLogin() {
        initComponents();
        
        
        loginHandler = new LoginHandler();
         
    }
    
  
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUName = new rojerusan.RSMetroTextPlaceHolder();
        jLabel3 = new javax.swing.JLabel();
        txtPass = new rojerusan.RSPasswordTextPlaceHolder();
        btnLogin = new rojerusan.RSMaterialButtonRectangle();
        resetBtn = new rojerusan.RSMaterialButtonRectangle();
        jLabel9 = new javax.swing.JLabel();
        back = new rojerusan.RSLabelImage();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        rSLabelImage1 = new rojerusan.RSLabelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setMaximumSize(new java.awt.Dimension(540, 360));
        jPanel1.setMinimumSize(new java.awt.Dimension(540, 360));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonHover1.setBackground(new java.awt.Color(0, 44, 76));
        rSButtonHover1.setText("X");
        rSButtonHover1.setColorHover(new java.awt.Color(51, 51, 51));
        rSButtonHover1.setColorTextHover(new java.awt.Color(89, 255, 255));
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 30));

        jLabel6.setBackground(new java.awt.Color(0, 112, 192));
        jLabel6.setFont(new java.awt.Font("Source Sans 3 Black", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 76, 126));
        jLabel6.setText("Sign");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, 50));

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setFont(new java.awt.Font("Source Sans 3 Black", 0, 38)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(89, 255, 255));
        jLabel4.setText("In");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 40, -1));

        jLabel5.setFont(new java.awt.Font("Source Sans 3 SemiBold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        txtUName.setBackground(new java.awt.Color(0, 0, 0));
        txtUName.setForeground(new java.awt.Color(89, 255, 255));
        txtUName.setBorderColor(new java.awt.Color(89, 255, 255));
        txtUName.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        txtUName.setPhColor(new java.awt.Color(89, 255, 255));
        txtUName.setPlaceholder("Enter Username");
        jPanel1.add(txtUName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 310, 40));

        jLabel3.setFont(new java.awt.Font("Source Sans 3 SemiBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        txtPass.setBackground(new java.awt.Color(0, 0, 0));
        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 255, 255)));
        txtPass.setForeground(new java.awt.Color(89, 255, 255));
        txtPass.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        txtPass.setPhColor(new java.awt.Color(89, 255, 255));
        txtPass.setPlaceholder("Enter Password");
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 310, 40));

        btnLogin.setBackground(new java.awt.Color(67, 150, 209));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.png"))); // NOI18N
        btnLogin.setText("login");
        btnLogin.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 112, 38));

        resetBtn.setBackground(new java.awt.Color(0, 44, 76));
        resetBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 150, 209), 2));
        resetBtn.setText("reset");
        resetBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        resetBtn.setRippleColor(new java.awt.Color(67, 150, 209));
        resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetBtnMouseClicked(evt);
            }
        });
        jPanel1.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 114, 38));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Source Sans 3 SemiBold", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 255));
        jLabel9.setText("Hello, Admin");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 40, 30));

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lock.png"))); // NOI18N
        rSLabelImage2.setText("");
        jPanel1.add(rSLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 390, 280));

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg/login21.jpg"))); // NOI18N
        jPanel1.add(rSLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 340));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtnMouseClicked
        // TODO add your handling code here:
        txtUName.setText("");
        txtPass.setText("");
    }//GEN-LAST:event_resetBtnMouseClicked

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        // TODO add your handling code here:
        loginHandler.performLogin(this, txtUName, txtPass, "admin");
    }//GEN-LAST:event_btnLoginMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        MainForm Ra= new MainForm();
        this.hide();
        Ra.setVisible(true);
    }//GEN-LAST:event_backMouseClicked

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSLabelImage back;
    private rojerusan.RSMaterialButtonRectangle btnLogin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSLabelImage rSLabelImage1;
    private rojerusan.RSLabelImage rSLabelImage2;
    private rojerusan.RSMaterialButtonRectangle resetBtn;
    private rojerusan.RSPasswordTextPlaceHolder txtPass;
    private rojerusan.RSMetroTextPlaceHolder txtUName;
    // End of variables declaration//GEN-END:variables
}
