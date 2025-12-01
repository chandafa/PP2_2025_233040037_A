package modul8.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modul8.controller.PersegiPanjangController;

@SuppressWarnings("unused")
public class PersegiPanjangView extends JFrame {
    // Komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");
    private JLabel lblHasilKeliling = new JLabel("-");
    private JButton btnHitung = new JButton("Hitung Luas");
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        // Inisialisasi VI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new GridLayout(6, 2, 10, 10)); // Grid 6 baris
        this.setTitle("MVC Kalkulator");
        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasil);
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblHasilKeliling);
        this.add(new JLabel("")); // Spacer kosong
        this.add(btnHitung);
        this.add(new JLabel("")); // Spacer kosong untuk tombol reset
        this.add(btnReset);
    }

    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());

    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());

    }

    public void setHasil(double hasil) {
        lblHasil.setText(String.valueOf(hasil));
    }

    public void setHasilKeliling(double keliling) {
        lblHasilKeliling.setText(String.valueOf(keliling));
    }

    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void addHitungListener(ActionListener hitungListener) {
        btnHitung.addActionListener(hitungListener);

    }

    public void addResetListener(ActionListener resetListener) {
        btnReset.addActionListener(resetListener);
    }

    // Reset inputan dan hasil tampilan di View
    public void resetInputs() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText("-");
        lblHasilKeliling.setText("-");
    }
}