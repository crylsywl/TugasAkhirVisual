/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiRumah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Asus
 */
public class PenjualanRumah extends javax.swing.JFrame {
    public String nik, client, kk, npwp, asuransi, gaji, alamat;
    public String idkaryawan, namaKaryawan;
    public String tipe, lb, lt, kt, km, lantai, listrik, air, desk, harga;

    /**
     * Creates new form PenjualanRumah
     */
    public PenjualanRumah() {
        initComponents();
        aktif();
    }
    
    public void itemTerpilihclient(){ 
        Popupdataclient cli = new Popupdataclient(); 
        cli.client= this;  
        nikLabel.setText(nik);
        clientLabel.setText(client);
        kkLabel.setText(kk);
        npwpLabel.setText(npwp);
        asuransiLabel.setText(asuransi);
        gajiLabel.setText(gaji);
        alamatLabel.setText(alamat);
    }
    public void itemTerpilihrumah(){ 
        Popupdatarumah rmh = new Popupdatarumah(); 
        rmh.rumah= this;  
        tipeLabel.setText(tipe);
        luasBLabel.setText(lb);
        luasTLabel.setText(lt);
        kamarTLabel.setText(kt);
        kamarMLabel.setText(km);
        lantaiLabel.setText(lantai);
        listrikLabel.setText(listrik);
        airLabel.setText(air);
        deskripsiLabel.setText(desk);
        try {
            long hargaLong = Long.parseLong(harga.replaceAll("[^\\d]", ""));
            NumberFormat formatter = NumberFormat.getInstance(new Locale("id", "ID"));
            String hargaFormatted = formatter.format(hargaLong);
            hargaLabel.setText(hargaFormatted);
        } catch (NumberFormatException e) {
            hargaLabel.setText("Format salah");
        }
        
    }
//    public void itemTerpilihKaryawan(){ 
//        Popupdatakaryawan cli = new Popupdatakaryawan(); 
//        cli.karyawan= this;  
//        idKaryawanLabel.setText(idkaryawan);
//        namaKaryawanLabel.setText(namaKaryawan);
//    }
    
private void simpanDataTransaksi() {
    // Validasi data terisi
    if (nikLabel.getText().isEmpty() || tipeLabel.getText().isEmpty() || idKaryawanLabel.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap lengkapi semua data sebelum menyimpan!");
        return;
    }

    try (Connection koneksiDB = koneksi.getConnection()) {
        // 1. Ambil ID Client dari database berdasarkan NIK
        String queryClient = "SELECT `Id Client` FROM client WHERE `NIK` = ?";
        PreparedStatement psClient = koneksiDB.prepareStatement(queryClient);
        psClient.setString(1, nikLabel.getText());
        ResultSet hasilClient = psClient.executeQuery();

        String idClient = null;
        if (hasilClient.next()) {
            idClient = hasilClient.getString("Id Client"); // Menggunakan getString
        } else {
            JOptionPane.showMessageDialog(this, "Data client tidak ditemukan!");
            return;
        }

        // 2. Ambil ID Rumah dari database berdasarkan Tipe
        String queryRumah = "SELECT `Id Rumah`, `Harga Rumah`, `Total Bonus` FROM tipe_rumah WHERE `Tipe` = ?";
        PreparedStatement psRumah = koneksiDB.prepareStatement(queryRumah);
        psRumah.setString(1, tipeLabel.getText());
        ResultSet hasilRumah = psRumah.executeQuery();

        String idRumah = null;
        double hargaRumah = 0;
        double totalBonus = 0;
        
        if (hasilRumah.next()) {
            idRumah = hasilRumah.getString("Id Rumah"); // Menggunakan getString
            hargaRumah = hasilRumah.getDouble("Harga Rumah");
            totalBonus = hasilRumah.getDouble("Total Bonus");
        } else {
            JOptionPane.showMessageDialog(this, "Data rumah tidak ditemukan!");
            return;
        }

        // 3. Simpan transaksi ke database
        String querySimpan = "INSERT INTO transaksi (client_id, tipe_rumah_id, karyawan_id, harga_rumah, total_bonus) " +
                           "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement psSimpan = koneksiDB.prepareStatement(querySimpan);
        psSimpan.setString(1, idClient); // Menggunakan setString
        psSimpan.setString(2, idRumah);  // Menggunakan setString
        psSimpan.setString(3, idKaryawanLabel.getText()); // Langsung menggunakan String
        psSimpan.setDouble(4, hargaRumah);
        psSimpan.setDouble(5, totalBonus);
        
        int barisTerpengaruh = psSimpan.executeUpdate();
        
        if (barisTerpengaruh > 0) {
            JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan transaksi!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error database: " + e.getMessage());
    }
}

    protected void aktif(){
//    cariClientField.requestFocus();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gajiLabel = new javax.swing.JLabel();
        asuransiLabel = new javax.swing.JLabel();
        kkLabel = new javax.swing.JLabel();
        npwpLabel = new javax.swing.JLabel();
        clientLabel = new javax.swing.JLabel();
        nikLabel = new javax.swing.JLabel();
        listrikLabel = new javax.swing.JLabel();
        lantaiLabel = new javax.swing.JLabel();
        kamarMLabel = new javax.swing.JLabel();
        luasTLabel = new javax.swing.JLabel();
        kamarTLabel = new javax.swing.JLabel();
        luasBLabel = new javax.swing.JLabel();
        tipeLabel = new javax.swing.JLabel();
        airLabel = new javax.swing.JLabel();
        hargaLabel = new javax.swing.JLabel();
        idKaryawanLabel = new javax.swing.JLabel();
        namaKaryawanLabel = new javax.swing.JLabel();
        simpanButton = new javax.swing.JLabel();
        cariKaryawanButton = new javax.swing.JLabel();
        cariRumahButton = new javax.swing.JLabel();
        cariClientButton = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        alamatLabel = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        deskripsiLabel = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gajiLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(gajiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 300, 160, 27));

        asuransiLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(asuransiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 275, 160, 27));

        kkLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(kkLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 227, 160, 27));

        npwpLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(npwpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 252, 160, 27));

        clientLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(clientLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 200, 160, 27));

        nikLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(nikLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 173, 160, 27));

        listrikLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(listrikLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 320, 160, 25));

        lantaiLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(lantaiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 298, 160, 25));

        kamarMLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(kamarMLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 272, 160, 25));

        luasTLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(luasTLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 224, 160, 25));

        kamarTLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(kamarTLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 250, 160, 25));

        luasBLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(luasBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 198, 160, 25));

        tipeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tipeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 173, 160, 25));

        airLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(airLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 346, 160, 25));

        hargaLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        getContentPane().add(hargaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 476, 240, 20));

        idKaryawanLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(idKaryawanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 130, 27));

        namaKaryawanLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(namaKaryawanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 206, 130, 27));

        simpanButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanButtonMouseClicked(evt);
            }
        });
        getContentPane().add(simpanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 484, 220, 25));

        cariKaryawanButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariKaryawanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariKaryawanButtonMouseClicked(evt);
            }
        });
        getContentPane().add(cariKaryawanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 200, 25));

        cariRumahButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariRumahButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariRumahButtonMouseClicked(evt);
            }
        });
        getContentPane().add(cariRumahButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 140, 200, 25));

        cariClientButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cariClientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariClientButtonMouseClicked(evt);
            }
        });
        getContentPane().add(cariClientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 143, 200, 25));

        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 30, 30));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setHorizontalScrollBar(null);

        alamatLabel.setEditable(false);
        alamatLabel.setBackground(new java.awt.Color(210, 240, 255));
        alamatLabel.setColumns(20);
        alamatLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        alamatLabel.setLineWrap(true);
        alamatLabel.setRows(3);
        alamatLabel.setBorder(null);
        alamatLabel.setMaximumSize(new java.awt.Dimension(165, 90));
        jScrollPane3.setViewportView(alamatLabel);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 165, 80));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setHorizontalScrollBar(null);

        deskripsiLabel.setEditable(false);
        deskripsiLabel.setBackground(new java.awt.Color(210, 240, 255));
        deskripsiLabel.setColumns(20);
        deskripsiLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deskripsiLabel.setLineWrap(true);
        deskripsiLabel.setRows(3);
        deskripsiLabel.setBorder(null);
        deskripsiLabel.setMaximumSize(new java.awt.Dimension(165, 90));
        jScrollPane2.setViewportView(deskripsiLabel);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 165, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Penjualan Rumah.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        Transaksi TRANSAKSIPAGE = new Transaksi();
        TRANSAKSIPAGE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void cariClientButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariClientButtonMouseClicked
        // TODO add your handling code here:
        Popupdataclient cli = new Popupdataclient();
        cli.client = this;
        cli.setVisible(true);
        cli.setResizable(false);
//        String namaClient = cariClientField.getText();
//        if (namaClient.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Masukkan Nama Client terlebih dahulu.");
//            return;
//        }
//
//        try (Connection connection = koneksi.getConnection()) {
//            String query = "SELECT * FROM client WHERE `Nama Client` = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, namaClient);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                // Tampilkan nama karyawan
//                nikLabel.setText(resultSet.getString("NIK"));
//                clientLabel.setText(resultSet.getString("Nama Client"));
//                kkLabel.setText(resultSet.getString("Nomor KK"));
//                npwpLabel.setText(resultSet.getString("NPWP"));
//                asuransiLabel.setText(resultSet.getString("Asuransi"));
//                gajiLabel.setText(resultSet.getString("Gaji"));
//                alamatLabel.setText(resultSet.getString("Alamat"));
//            } else {
//                JOptionPane.showMessageDialog(this, "Data karyawan tidak ditemukan.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mencari data karyawan: " + e.getMessage());
//        }
//        cariClientField.setText("");
    }//GEN-LAST:event_cariClientButtonMouseClicked

    private void simpanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanButtonMouseClicked
        // TODO add your handling code here:
        int option = JOptionPane.showOptionDialog(
                this,
                        "Harap periksa kembali data yang Anda masukkan sebelum melanjutkan.",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Cek Kembali", "Simpan"}, // Tombol custom
                        "Cek Kembali"
                );

                if (option == JOptionPane.NO_OPTION) { // Jika memilih "Simpan"
                    simpanDataTransaksi(); // Simpan data ke database
                }
    }//GEN-LAST:event_simpanButtonMouseClicked

    private void cariKaryawanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariKaryawanButtonMouseClicked
        // TODO add your handling code here:
        Popupdatakaryawan popup = new Popupdatakaryawan(new Popupdatakaryawan.KaryawanSelectionListener() {
        @Override
        public void onKaryawanSelected(String id, String nama) {
            // Set nilai ke field di PenjualanRumah
            idKaryawanLabel.setText(id);
            namaKaryawanLabel.setText(nama);
            // Lakukan operasi lain jika diperlukan
        }
    });
    popup.setVisible(true);
    }//GEN-LAST:event_cariKaryawanButtonMouseClicked

    private void cariRumahButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariRumahButtonMouseClicked
        // TODO add your handling code here:
        Popupdatarumah rmh = new Popupdatarumah();
        rmh.rumah = this;
        rmh.setVisible(true);
        rmh.setResizable(false);
    }//GEN-LAST:event_cariRumahButtonMouseClicked

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
            java.util.logging.Logger.getLogger(PenjualanRumah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjualanRumah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjualanRumah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjualanRumah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjualanRumah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel airLabel;
    private javax.swing.JTextArea alamatLabel;
    private javax.swing.JLabel asuransiLabel;
    private javax.swing.JLabel back;
    private javax.swing.JLabel cariClientButton;
    private javax.swing.JLabel cariKaryawanButton;
    private javax.swing.JLabel cariRumahButton;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JTextArea deskripsiLabel;
    private javax.swing.JLabel gajiLabel;
    private javax.swing.JLabel hargaLabel;
    private javax.swing.JLabel idKaryawanLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel kamarMLabel;
    private javax.swing.JLabel kamarTLabel;
    private javax.swing.JLabel kkLabel;
    private javax.swing.JLabel lantaiLabel;
    private javax.swing.JLabel listrikLabel;
    private javax.swing.JLabel luasBLabel;
    private javax.swing.JLabel luasTLabel;
    private javax.swing.JLabel namaKaryawanLabel;
    private javax.swing.JLabel nikLabel;
    private javax.swing.JLabel npwpLabel;
    private javax.swing.JLabel simpanButton;
    private javax.swing.JLabel tipeLabel;
    // End of variables declaration//GEN-END:variables
}
