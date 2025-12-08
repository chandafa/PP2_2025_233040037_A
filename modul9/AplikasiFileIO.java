package modul9;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {
    // Komponen UI
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText, btnAppendText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JFileChooser fileChooser;

    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi Komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        // Panel Tombol
        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        btnAppendText = new JButton("Tambah Text");
        btnSaveBinary = new JButton("Simpan Config (Binary)");
        btnLoadBinary = new JButton("Muat Config (Binary)");

        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnAppendText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);

        // Layout
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event Handling
        // 1. MEMBACA FILE TEKS (Text Stream)
        btnOpenText.addActionListener(e -> bukaFileTeks());
        // 2. MENULIS FILE TEKS (Text Stream)
        btnSaveText.addActionListener(e -> simpanFileTeks(false)); // false untuk overwrite
        // Menambahkan event untuk tombol append
        btnAppendText.addActionListener(e -> simpanFileTeks(true)); // true untuk append
        // 3. MENULIS FILE BINARY (Byte Stream)
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        // 4. MEMBACA FILE BINARY (Byte Stream)
        btnLoadBinary.addActionListener(e -> muatConfigBinary());

        // Memuat catatan terakhir saat aplikasi dibuka
        muatCatatanTerakhir();
    }

    // contoh membaca file teks
    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null;
            try {
                // Membuka stream
                reader = new BufferedReader(new FileReader(file));
                textArea.setText(""); // Kosongkan area

                String line;
                // Baca baris demi baris
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }

                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            } finally {
                // Blok Finally: Selalu dijalankan untuk menutup resource
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Method untuk menyimpan atau menambahkan teks ke file
    private void simpanFileTeks(boolean append) {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
                writer.write(textArea.getText());
                if (append) {
                    JOptionPane.showMessageDialog(this, "Teks berhasil ditambahkan ke file!");
                } else {
                    JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage());
            }
        }
    }

    // Contoh: Menulis Binary (Menyimpan objek UserConfig)
    private void simpanConfigBinary() {
        String username = JOptionPane.showInputDialog(this, "Masukkan username:", "Input Username", JOptionPane.PLAIN_MESSAGE);
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserConfig config = new UserConfig();
        config.setUsername(username);
        config.setFontSize(textArea.getFont().getSize());

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user_config.bin"))) {
            oos.writeObject(config);
            JOptionPane.showMessageDialog(this, "Konfigurasi user berhasil disimpan ke user_config.bin");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan config: " + ex.getMessage());
        }
    }

    // Contoh: Membaca Binary (Mengambil objek UserConfig)
    private void muatConfigBinary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user_config.bin"))) {
            UserConfig config = (UserConfig) ois.readObject();

            // Terapkan konfigurasi ke aplikasi
            textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontSize()));
            JOptionPane.showMessageDialog(this, "Konfigurasi dimuat! Selamat datang kembali, " + config.getUsername() + "!");

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File user_config.bin tidak ditemukan!");
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca config: " + ex.getMessage());
        }
    }

    private void muatCatatanTerakhir() {
        try (BufferedReader reader = new BufferedReader(new FileReader("last_notes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (FileNotFoundException e) {
            // File tidak ditemukan, tidak perlu melakukan apa-apa.
        } catch (IOException e) {
            // Error saat membaca file
            JOptionPane.showMessageDialog(this, "Gagal memuat catatan terakhir: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }

}
