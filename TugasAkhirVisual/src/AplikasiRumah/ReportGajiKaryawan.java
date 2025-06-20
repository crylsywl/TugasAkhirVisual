package AplikasiRumah;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportGajiKaryawan {
    
    public void printGajiById(int idGaji) {
        Connection conn = null;
        InputStream reportStream = null;
        
        try {
            // 1. Dapatkan koneksi database
            conn = koneksi.getConnection();
            
            // 2. Dapatkan stream untuk file report
            reportStream = getClass().getResourceAsStream(
                "/AplikasiRumah/ReportGajiKaryawan.jasper");
            
            if (reportStream == null) {
                throw new Exception(
                    "File report tidak ditemukan. Pastikan:\n" +
                    "1. File ReportGajiKaryawan.jasper ada di folder src/AplikasiRumah\n" +
                    "2. Nama file tepat (termasuk huruf besar/kecil)\n" +
                    "3. Project sudah di-clean dan rebuild");
            }
            
            // 3. Siapkan parameter
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id_gaji", idGaji);
            
            // 4. Generate report
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                reportStream,
                parameters,
                conn);
            
            // 5. Tampilkan report
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setTitle("Detail Transaksi #" + idGaji);
            viewer.setVisible(true);
            
        } catch (Exception e) {
            showError("Error saat mencetak laporan:\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            // 6. Tutup resources
            closeResources(conn, reportStream);
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
        new ReportGajiKaryawan().printGajiById(17); // Ganti dengan ID yang valid
    }
}