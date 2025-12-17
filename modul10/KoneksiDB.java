package modul10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class KoneksiDB {
    private static Connection mysqlconfig;
    
    public static Connection configDB() throws SQLException {
        try {
            // URL Database (Ganti 'root' dan '' sesuai user/pass database lokal Anda)
            String url = "jdbc:mysql://pongo.kencang.com:3306/academyc_kampus_db";
            String user = "academyc_ruang-rasa-user";
            String pass = "Ruangrasaunpas123";
            
            // Registrasi Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            // Buat Koneksi
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
        }
        return mysqlconfig;
    }
}