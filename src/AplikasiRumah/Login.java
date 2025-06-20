/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiRumah;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

/**
 *
 * @author Asus
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
     public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            // Sebaiknya tangani exception dengan lebih spesifik
            // atau log errornya, melempar RuntimeException bisa menghentikan aplikasi
            System.err.println("Error hashing password: " + e.getMessage());
            // throw new RuntimeException("Error hashing password", e);
            return null; // Atau kembalikan null jika hashing gagal agar bisa ditangani
        }
    }
     
     private void attemptLogin() {
        String username = usernameField.getText().trim();
        // Cara yang benar dan lebih aman untuk mendapatkan password dari JPasswordField
        String password = new String(passwordField.getPassword());

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username tidak boleh kosong!", "Login Error", JOptionPane.ERROR_MESSAGE);
            usernameField.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password tidak boleh kosong!", "Login Error", JOptionPane.ERROR_MESSAGE);
            passwordField.requestFocus();
            return;
        }

        String hashedPassword = hashPassword(password);
        if (hashedPassword == null) {
            // Hashing gagal, tampilkan error (hashPassword sudah print error)
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan internal saat memproses password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Pastikan Anda memiliki kelas koneksi yang berfungsi di package AplikasiRumah
            // Jika belum ada, Anda perlu membuatnya atau mengadaptasi dari project lain.
            // Contoh: conn = AplikasiRumah.KoneksiDB.connect();
            // Untuk sekarang, saya akan asumsikan Anda punya kelas bernama 'KoneksiRumah'
            // di package 'AplikasiRumah' dengan metode statis 'connect()'
             conn = AplikasiRumah.koneksi.getConnection(); // Sesuaikan dengan implementasi koneksi Anda

            // ⚠️ SESUAIKAN NAMA TABEL DAN KOLOM DI BAWAH INI!
            // Gantilah 'karyawan' dengan nama tabel karyawan Anda.
            // Gantilah 'USERNAME_KOLOM' dengan nama kolom untuk username di tabel Anda.
            // Gantilah 'PASSWORD_KOLOM_HASH' dengan nama kolom untuk password (yang sudah di-hash) di tabel Anda.
            String sql = "SELECT * FROM karyawan WHERE (`Id karyawan`) = ? AND password = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword); // Bandingkan dengan password yang sudah di-hash

            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Login berhasil
                // Contoh: simpan informasi user yang login jika diperlukan
                // String namaUserLogin = rs.getString("NAMA_LENGKAP_KOLOM");
                // UserSession.getInstance().setLoggedInUser(username, namaUserLogin); // Jika ada manajemen sesi
                
                UserSession.setUserLogin(rs.getString("Id karyawan"));
                JOptionPane.showMessageDialog(this, "Berhasil Login!"); // Pesan sukses

                AdminPage ADMIN = new AdminPage(); // Atau halaman yang sesuai
                ADMIN.setVisible(true);
                this.dispose(); // Tutup jendela login
            } else {
                // Login gagal
                JOptionPane.showMessageDialog(this, "Username atau Kata Sandi Salah", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal Login! Terjadi kesalahan database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) { // Menangkap error jika koneksi.getConnection() gagal atau masalah lain
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan umum: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameField.setBackground(new java.awt.Color(255, 237, 228));
        usernameField.setBorder(null);
        usernameField.setOpaque(false);
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 246, 290, 28));

        passwordField.setBackground(new java.awt.Color(255, 237, 228));
        passwordField.setBorder(null);
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 290, 28));

        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 130, 34));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Login.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        // TODO add your handling code here:
       attemptLogin();
    }//GEN-LAST:event_loginButtonMouseClicked

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
       attemptLogin();
    }//GEN-LAST:event_passwordFieldActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
