package AplikasiRumah;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportTransaksiClient {
    
    public void printTransaksiById(int idTransaksi) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        InputStream reportStream = null;
        
        try {
            conn = new koneksi().getConnection();
            
            // Query yang menangani ID sebagai string
            String sql = "SELECT t.*, c.`Id Client` as client_id_str, " +
                        "c.`Nama Client`, k.`Nama Karyawan`, tr.Tipe " +
                        "FROM transaksi t " +
                        "JOIN client c ON t.client_id = c.`Id Client` " +
                        "JOIN karyawan k ON t.karyawan_id = k.`Id Karyawan` " +
                        "JOIN tipe_rumah tr ON t.tipe_rumah_id = tr.`Id Rumah` " +
                        "WHERE t.id = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idTransaksi); // Menggunakan setInt karena parameter method int
            rs = pstmt.executeQuery();
            
            // Gunakan JRResultSetDataSource
            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(rs);
            
            // Load report
            reportStream = getClass().getResourceAsStream("/reports/transaksi_client.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
            
            // Isi parameter (jika ada)
            Map<String, Object> parameters = new HashMap<>();
            
            // Generate report
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport, parameters, resultSetDataSource);
            
            // Tampilkan report
            JasperViewer.viewReport(jasperPrint, false);
            
        } catch (Exception e) {
            e.printStackTrace();
            showError("Error saat mencetak laporan: " + e.getMessage());
        } finally {
            // Tutup semua resources
            closeResources(conn, pstmt, rs, reportStream);
        }
    }
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(null, 
            message, 
            "Error Cetak Laporan", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    private void closeResources(Connection conn, PreparedStatement pstmt, 
                              ResultSet rs, InputStream stream) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
            if (stream != null) stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Untuk testing
    public static void main(String[] args) {
        new ReportTransaksiClient().printTransaksiById(17); // Ganti dengan ID yang valid
    }
}