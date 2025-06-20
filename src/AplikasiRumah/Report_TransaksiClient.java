/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiRumah;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner.DateEditor;

/**
 *
 * @author Asus
 */
public class Report_TransaksiClient extends javax.swing.JFrame {
    private DefaultTableModel tbl;
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String DISPLAY_DATE_PATTERN = "dd-MM-yyyy";
    /**
     * Creates new form Transaksi_TransaksiClient
     */
    public Report_TransaksiClient() {
        initComponents();
        initSpinners();
        initTable();
        loadAllData();
    }
    
     
    private void initSpinners() {
        // Set model dan format untuk spinner tanggalAdd commentMore actions
        spinnerAwal.setModel(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
        spinnerAkhir.setModel(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_MONTH));
        
        // Set format tampilan
        spinnerAwal.setEditor(new DateEditor(spinnerAwal, DISPLAY_DATE_PATTERN));
        spinnerAkhir.setEditor(new DateEditor(spinnerAkhir, DISPLAY_DATE_PATTERN));
    }
    
    private void initTable() {
        // Model tabel dengan kolom yang diperlukanAdd commentMore actions
        tbl = new DefaultTableModel(
            new Object[]{"Id Transaksi", "Timestamp", "NIK", "Nama Client", "Tipe Rumah", "Nama Karyawan", "Harga"}, 
            0
        );
        table.setModel(tbl);
        
        // Format kolom harga sebagai mata uang
        table.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof Number) {
                    value = nf.format(value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected, 
                        hasFocus, row, column);
            }
        });
    }
    
    private void loadAllData() {
        loadData(false, null, null);
    }
    
    private void loadData(boolean filterByDate, Date startDate, Date endDate) {
        tbl.setRowCount(0); // Clear existing dataAdd commentMore actions
        
        String sql = "SELECT t.id, t.timestamp, c.NIK, c.`Nama Client`, tr.Tipe, "
                   + "k.`Nama Karyawan`, t.harga_rumah "
                   + "FROM transaksi t "
                   + "JOIN client c ON t.client_id = c.`Id Client` "
                   + "JOIN tipe_rumah tr ON t.tipe_rumah_id = tr.`Id Rumah` "
                   + "JOIN karyawan k ON t.karyawan_id = k.`Id karyawan` ";
        
        if (filterByDate) {
            sql += "WHERE t.timestamp BETWEEN ? AND ? ";
        }
        
        sql += "ORDER BY t.timestamp DESC";
        
        try (Connection conn = koneksi.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            if (filterByDate) {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
                pst.setString(1, sdf.format(startDate) + " 00:00:00");
                pst.setString(2, sdf.format(endDate) + " 23:59:59");
            }
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                tbl.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getTimestamp("timestamp"),
                    rs.getString("NIK"),
                    rs.getString("Nama Client"),
                    rs.getString("Tipe"),
                    rs.getString("Nama Karyawan"),
                    rs.getDouble("harga_rumah")
                });
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Error saat memuat data: " + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void printSelectedTransaction() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Pilih transaksi yang akan dicetak terlebih dahulu", 
                "Peringatan", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int idTransaksi = (Integer) table.getValueAt(selectedRow, 0);
            new ReportTransaksiClient().printTransaksiById(idTransaksi);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal mencetak laporan:\n" + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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

        btnRefresh1 = new javax.swing.JLabel();
        spinnerAkhir = new javax.swing.JSpinner();
        spinnerAwal = new javax.swing.JSpinner();
        back = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnShowAll = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefresh1MouseClicked(evt);
            }
        });
        getContentPane().add(btnRefresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 485, 180, 26));

        spinnerAkhir.setModel(new javax.swing.SpinnerDateModel());
        spinnerAkhir.setBorder(null);
        spinnerAkhir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(spinnerAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 140, -1));

        spinnerAwal.setModel(new javax.swing.SpinnerDateModel());
        spinnerAwal.setBorder(null);
        spinnerAwal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(spinnerAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 140, -1));

        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 30, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 780, 150));

        btnShowAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowAllMouseClicked(evt);
            }
        });
        getContentPane().add(btnShowAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 250, 26, 26));

        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 185, 180, 26));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Transaksi Client.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        Laporan LAPORANPAGE = new Laporan();
        LAPORANPAGE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        // Get selected row
     
    }//GEN-LAST:event_tableMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
    Date startDate = (Date) spinnerAwal.getValue();
        Date endDate = (Date) spinnerAkhir.getValue();
        
        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "Harap pilih kedua tanggal");
            return;
        }
        
        if (startDate.after(endDate)) {
            JOptionPane.showMessageDialog(this, "Tanggal awal tidak boleh setelah tanggal akhir");
            return;
        }
        
        loadData(true, startDate, endDate);
        
        SimpleDateFormat sdf = new SimpleDateFormat(DISPLAY_DATE_PATTERN);
        JOptionPane.showMessageDialog(this, "Data difilter dari " + 
            sdf.format(startDate) + " sampai " + sdf.format(endDate));
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnShowAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowAllMouseClicked
        // TODO add your handling code here:
        loadAllData();
        JOptionPane.showMessageDialog(this, "Menampilkan semua data transaksi");
    }//GEN-LAST:event_btnShowAllMouseClicked

    private void btnRefresh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefresh1MouseClicked
        // TODO add your handling code here:
        printSelectedTransaction();
    }//GEN-LAST:event_btnRefresh1MouseClicked

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
            java.util.logging.Logger.getLogger(Report_TransaksiClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report_TransaksiClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report_TransaksiClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report_TransaksiClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report_TransaksiClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel btnRefresh;
    private javax.swing.JLabel btnRefresh1;
    private javax.swing.JLabel btnShowAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerAkhir;
    private javax.swing.JSpinner spinnerAwal;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
