
package View;

import controller.LoginController;
import javax.swing.JOptionPane;

import controller.LoginHandler;


public class MemberLogin extends javax.swing.JFrame {
     private LoginHandler loginHandler;
    private LoginController loginController;
 
    public MemberLogin() {
        initComponents();
        loginController = new LoginController();
        loginHandler = new LoginHandler();
    }

    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPass = new rojerusan.RSPasswordTextPlaceHolder();
        jLabel3 = new javax.swing.JLabel();
        txtUName = new rojerusan.RSMetroTextPlaceHolder();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        btnLogin = new rojerusan.RSMaterialButtonRectangle();
        resetBtn = new rojerusan.RSMaterialButtonRectangle();
        rSLabelImage1 = new rojerusan.RSLabelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Source Sans 3 SemiBold", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 255));
        jLabel9.setText("Hello, Member");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));

        txtPass.setBackground(new java.awt.Color(0, 0, 0));
        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 255, 255)));
        txtPass.setForeground(new java.awt.Color(89, 255, 255));
        txtPass.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        txtPass.setPhColor(new java.awt.Color(89, 255, 255));
        txtPass.setPlaceholder("Enter Password");
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 250, 40));

        jLabel3.setFont(new java.awt.Font("Source Sans 3 SemiBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        txtUName.setBackground(new java.awt.Color(0, 0, 0));
        txtUName.setForeground(new java.awt.Color(89, 255, 255));
        txtUName.setBorderColor(new java.awt.Color(89, 255, 255));
        txtUName.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        txtUName.setPhColor(new java.awt.Color(89, 255, 255));
        txtUName.setPlaceholder("Enter Username");
        jPanel2.add(txtUName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 40));

        jLabel5.setFont(new java.awt.Font("Source Sans 3 SemiBold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 112, 192));
        jLabel6.setFont(new java.awt.Font("Source Sans 3 Black", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 76, 126));
        jLabel6.setText("Sign");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 32, -1, 50));

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setFont(new java.awt.Font("Source Sans 3 Black", 0, 38)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(89, 255, 255));
        jLabel4.setText("In");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 40, -1));

        rSButtonHover1.setBackground(new java.awt.Color(0, 44, 76));
        rSButtonHover1.setText("X");
        rSButtonHover1.setColorHover(new java.awt.Color(51, 51, 51));
        rSButtonHover1.setColorTextHover(new java.awt.Color(89, 255, 255));
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 30));

        btnLogin.setBackground(new java.awt.Color(0, 44, 76));
        btnLogin.setText("login");
        btnLogin.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 112, 38));

        resetBtn.setBackground(new java.awt.Color(67, 150, 209));
        resetBtn.setText("reset");
        resetBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetBtnMouseClicked(evt);
            }
        });
        jPanel2.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 114, 38));

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg/login21.jpg"))); // NOI18N
        jPanel2.add(rSLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        // TODO add your handling code here:
        loginHandler.performLogin(this, txtUName, txtPass, "member");
    }//GEN-LAST:event_btnLoginMouseClicked

    private void resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtnMouseClicked
        // TODO add your handling code here:
        txtUName.setText("");
        txtPass.setText("");
    }//GEN-LAST:event_resetBtnMouseClicked

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
            java.util.logging.Logger.getLogger(MemberLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btnLogin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSLabelImage rSLabelImage1;
    private rojerusan.RSMaterialButtonRectangle resetBtn;
    private rojerusan.RSPasswordTextPlaceHolder txtPass;
    private rojerusan.RSMetroTextPlaceHolder txtUName;
    // End of variables declaration//GEN-END:variables
}
