/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul6;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author CHAN
 */
public class latihan1 {
    public static void main(String[] args) {
        // 1. Buat frame (window)
        JFrame frame = new JFrame("Contoh FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // 2. Buat panel (container)
        // JPanel secara default sudah menggunakan FlowLayout
        JPanel panel = new JPanel();

        // Anda juga bisa mengaturnya secara eksplisit:
        // panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        // Pilihan lainnya: LEFT, RIGHT, dll.

        // 3. Buat dan tambahkan komponen
        panel.add(new JButton("Tombol 1"));
        panel.add(new JButton("Tombol 2"));
        panel.add(new JButton("Tombol 3"));
        panel.add(new JButton("Tombol Empat Panjang"));
        panel.add(new JButton("Tombol 5"));

        // 4. Tambahkan panel ke frame
        frame.add(panel);

        // 5. Tampilkan frame
        frame.setVisible(true);
    }
}
