/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiRumah;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Asus
 */
public class ReportRancanganAnggaranBiaya {
    public void printRABByTipe(String tipe) {
        Connection conn = null;
        InputStream reportStream = null;

        try {
            // 1. Ambil koneksi ke database
            conn = koneksi.getConnection();

            // 2. Ambil file .jasper dari folder resources
            reportStream = getClass().getResourceAsStream("/AplikasiRumah/ReportRancanganAnggaranBiaya.jasper");

            if (reportStream == null) {
                throw new Exception("File report tidak ditemukan.\nPastikan file ReportRancanganAnggaranBiaya.jasper ada di /src/AplikasiRumah/");
            }

            // 3. Siapkan parameter
            Map<String, Object> parameters = new HashMap<>();
            if (tipe != null && !tipe.equals("Semua Tipe")) {
                parameters.put("id_RAB", tipe); // Ini sesuai dengan parameter di .jrxml
            }

            // 4. Cetak laporan
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters, conn);

            // 5. Tampilkan report
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setTitle("Laporan RAB - Tipe: " + (tipe == null ? "Semua" : tipe));
            viewer.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mencetak laporan:\n" + e.getMessage(),
                "Cetak Laporan Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                if (reportStream != null) reportStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
