/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdi;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashu
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Login() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cncl_login4 = new javax.swing.JButton();
        lgin_login1 = new javax.swing.JButton();
        cncl_login1 = new javax.swing.JButton();
        hv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwd)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 61, 360, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Enter Password to continue");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 21, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        cncl_login4.setText("Change Password");
        cncl_login4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cncl_login4ActionPerformed(evt);
            }
        });

        lgin_login1.setText("Login>>>");
        lgin_login1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgin_login1ActionPerformed(evt);
            }
        });

        cncl_login1.setText("<<<Cancel");
        cncl_login1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cncl_login1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cncl_login1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cncl_login4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lgin_login1)
                .addGap(80, 80, 80))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cncl_login1)
                    .addComponent(cncl_login4)
                    .addComponent(lgin_login1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 136, 360, -1));
        getContentPane().add(hv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 204, -1, -1));

        setSize(new java.awt.Dimension(402, 251));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cncl_login4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cncl_login4ActionPerformed
        ChngPassword cp = new ChngPassword();
        cp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cncl_login4ActionPerformed

    private void lgin_login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgin_login1ActionPerformed
        //Connecting with MySQL for data.
        try{
            Connection con = Connect.getConnection();
            Statement stmt = con.createStatement();
            String qry="Select password FROM password ;";
            ResultSet rs = stmt.executeQuery(qry);
            while(rs.next()){
                hv.setText(rs.getString("password"));
                }
            rs.close();
            stmt.close();
            con.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }

        String pswd=hv.getText();
        String pw= new String(pwd.getPassword());
        if(pw.equals(pswd)){
            Workspace ws = new Workspace();
            ws.setVisible(true);
            this.dispose();
        }else{
            hv.setText("");
            JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD! Try Again.");
        }
        pwd.setText("");
        hv.setText("");
  
    }//GEN-LAST:event_lgin_login1ActionPerformed

    private void cncl_login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cncl_login1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_cncl_login1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cncl_login1;
    private javax.swing.JButton cncl_login4;
    private javax.swing.JLabel hv;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton lgin_login1;
    private javax.swing.JPasswordField pwd;
    // End of variables declaration//GEN-END:variables
}
