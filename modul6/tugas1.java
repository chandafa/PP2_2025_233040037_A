/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul6;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author CHAN
 */
public class tugas1 {
    public static void main(String[] args) {
        // 1. Buat Frame utama
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout(5, 5));

        // 2. Komponen layar (JTextField)
        JTextField layar = new JTextField();
        layar.setEditable(false); // supaya tidak diketik manual
        frame.add(layar, BorderLayout.NORTH);

        // 3. Panel untuk tombol (GridLayout 4x4)
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4, 4, 5, 5));

        // 4. Tambahkan 16 tombol (10 angka + 4 operator + 2 ekstra)
        String[] tombol = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String teks : tombol) {
            panelTombol.add(new JButton(teks));
        }

        // 5. Tambahkan panel tombol ke frame
        frame.add(panelTombol, BorderLayout.CENTER);

        // 6. Tampilkan frame
        frame.setVisible(true);
    }
}
