/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author AL MUBDIE
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
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
        btnAdminLogin = new rojerusan.RSButtonHover();
        btnMemberLo = new rojerusan.RSButtonHover();
        jLabel1 = new javax.swing.JLabel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        rSLabelImage1 = new rojerusan.RSLabelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdminLogin.setBackground(new java.awt.Color(89, 40, 237));
        btnAdminLogin.setText("ADMIN");
        btnAdminLogin.setColorHover(new java.awt.Color(51, 51, 51));
        btnAdminLogin.setColorTextHover(new java.awt.Color(0, 100, 141));
        btnAdminLogin.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        btnAdminLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdminLoginMouseClicked(evt);
            }
        });
        jPanel1.add(btnAdminLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 50));

        btnMemberLo.setBackground(new java.awt.Color(0, 100, 141));
        btnMemberLo.setText("MEMBER");
        btnMemberLo.setColorHover(new java.awt.Color(51, 51, 51));
        btnMemberLo.setColorTextHover(new java.awt.Color(0, 100, 141));
        btnMemberLo.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        btnMemberLo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMemberLoMouseClicked(evt);
            }
        });
        jPanel1.add(btnMemberLo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, 50));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Source Sans 3 ExtraBold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 191, 125));
        jLabel1.setText("Library Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, 31));

        rSButtonHover1.setBackground(new java.awt.Color(51, 51, 51));
        rSButtonHover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/off.png"))); // NOI18N
        rSButtonHover1.setColorHover(new java.awt.Color(0, 0, 0));
        rSButtonHover1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonHover1MouseClicked(evt);
            }
        });
        jPanel1.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 40, 30));

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg/grunge-brick-wall-with-blue-purple-neon-illumination-abstract-background-vector.jpg"))); // NOI18N
        jPanel1.add(rSLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMemberLoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMemberLoMouseClicked
        // TODO add your handling code here:
        MemberLogin R= new MemberLogin();
        this.hide();
        R.setVisible(true);
    }//GEN-LAST:event_btnMemberLoMouseClicked

    private void btnAdminLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminLoginMouseClicked
        // TODO add your handling code here:
        AdminLogin AR= new AdminLogin();
        this.hide();
        AR.setVisible(true);
    }//GEN-LAST:event_btnAdminLoginMouseClicked

    private void rSButtonHover1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonHover1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_rSButtonHover1MouseClicked

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnAdminLogin;
    private rojerusan.RSButtonHover btnMemberLo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSLabelImage rSLabelImage1;
    // End of variables declaration//GEN-END:variables
}
