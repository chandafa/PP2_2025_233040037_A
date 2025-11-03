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
import javax.swing.JTextField;

/**
 *
 * @author CHAN
 */
public class tugas2 {
    public static void main(String[] args) {
        // 1. Buat Frame
        JFrame frame = new JFrame("Konversi Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // 2. Buat komponen
        JLabel labelCelcius = new JLabel("Celcius:");
        JTextField inputCelcius = new JTextField(10);
        JButton tombolKonversi = new JButton("Konversi");
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JLabel hasilFahrenheit = new JLabel(""); // label kosong untuk hasil

        // 3. Tambahkan ActionListener ke tombol
        tombolKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Ambil teks dari input
                    String teksInput = inputCelcius.getText();
                    // Ubah ke double
                    double celcius = Double.parseDouble(teksInput);
                    // Konversi ke Fahrenheit
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    // Tampilkan hasil
                    hasilFahrenheit.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    // Jika input bukan angka
                    hasilFahrenheit.setText("Input tidak valid!");
                }
            }
        });

        // 4. Tambahkan komponen ke frame
        frame.add(labelCelcius);
        frame.add(inputCelcius);
        frame.add(tombolKonversi);
        frame.add(labelFahrenheit);
        frame.add(hasilFahrenheit);

        // 5. Tampilkan frame
        frame.setVisible(true);
    }
}
