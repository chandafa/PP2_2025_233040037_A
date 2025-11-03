/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author CHAN
 */
public class latihan4 {
    public static void main(String[] args) {
        // 1. Buat Frame
        JFrame frame = new JFrame("Contoh ActionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // 1. Buat Komponen (Event Source dan komponen lain)
        JLabel label = new JLabel("Halo, klik tombol di bawah!");
        JButton button = new JButton("Klik Saya!");

        // 2. Buat Event Listener
        // Menggunakan anonymous inner class
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logika yang dieksekusi saat event terjadi
                label.setText("Tombol telah diklik!");
            }
        };

        // 3. Daftarkan listener ke source
        button.addActionListener(listener);

        // 4. Tambahkan komponen ke frame
        frame.add(label);
        frame.add(button);

        // 5. Tampilkan frame
        frame.setVisible(true);
    }
}
