package modul5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Tugas1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Tugas 1 Komponen GUI Dasar");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 1. Atur Layout Manager ke BorderLayout
            // Sebenarnya ini tidak perlu
            // Karena BorderLayout adalah Layout Manager default
            frame.setLayout(new BorderLayout());

            // 2. Buat komponen
            JLabel label = new JLabel("Label ada di Atas (NORTH)");
            JButton south = new JButton("Tombol ada di Bawah (SOUTH)");
            JButton west = new JButton("Tombol ada di Kanan (WEST)");
            JButton east = new JButton("Tombol ada di Kiri (EAST)");
            JButton center = new JButton("Tombol ada di Tengah (CENTER)");

            // 3. Tambahkan Aksi (ActionListener) ke tombol
            south.addActionListener(e -> {
                label.setText("Tombol di SOUTH diklik!");
            });

            west.addActionListener(e -> {
                label.setText("Tombol di WEST diklik!");
            });

            east.addActionListener(e -> {
                label.setText("Tombol di EAST diklik!");
            });

            center.addActionListener(e -> {
                label.setText("Tombol di CENTER diklik!");
            });

            // 4. Tambahkan komponen ke frame DENGAN POSISI
            frame.add(label, BorderLayout.NORTH);
            frame.add(south, BorderLayout.SOUTH);
            frame.add(west, BorderLayout.WEST);
            frame.add(east, BorderLayout.EAST);
            frame.add(center, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
