package AplikasiRumah;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportKinerjaKaryawan {
    
    public void printKinerjaByYear(String tahun) throws Exception {
        Connection conn = null;
        try {
            // Validasi parameter
            if (tahun == null || tahun.equals("Semua Tahun")) {
                tahun = null;
            }
            
            // Siapkan parameter
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("tahun", tahun != null ? Integer.parseInt(tahun) : null);
            
            // Load report dari resources (jika file ada di dalam project)
            InputStream reportStream = getClass().getResourceAsStream(
                "/AplikasiRumah/ReportKinerjaKaryawan.jasper");
            
            if (reportStream == null) {
                throw new Exception("File laporan tidak ditemukan");
            }
            
            // Koneksi database
            conn = new koneksi().getConnection();
            
            // Generate report
            JasperPrint print = JasperFillManager.fillReport(
                reportStream, 
                parameters, 
                conn);
            
            // Tampilkan report
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setTitle("Laporan Kinerja Karyawan Tahun " + (tahun != null ? tahun : "Semua Tahun"));
            viewer.setVisible(true);
            
        } catch (NumberFormatException e) {
            showError("Format tahun tidak valid: " + e.getMessage());
            throw new Exception("Format tahun tidak valid");
        } catch (Exception e) {
            showError("Error saat mencetak laporan: " + e.getMessage());
            throw e;
        } finally {
            closeResources(conn, null);
        }
    }
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(null, 
            message, 
            "Error Cetak Laporan", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    private void closeResources(Connection conn, InputStream stream) {
        try {
            if (conn != null) conn.close();
            if (stream != null) stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Untuk testing
    public static void main(String[] args) {
        try {
            // Test case 1: Tahun spesifik
            new ReportKinerjaKaryawan().printKinerjaByYear("Semua Tahun");
            
            // Test case 2: Semua tahun
            new ReportKinerjaKaryawan().printKinerjaByYear("Semua Tahun");
            
            // Test case 3: Invalid tahun
            new ReportKinerjaKaryawan().printKinerjaByYear("dua ribu dua puluh lima");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}