package modul8.controller;

import modul8.model.PersegiPanjangModel;
import modul8.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    // Model dan view sebagai atribut kelas
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        // Menghubungkan tombol di View dengan logic di Controller
        this.view.addHitungListener(new HitungListener());
        this.view.addResetListener(new ResetListener());
    }

    // Inner class untuk menangani event klik tombol
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // 1. Ambil data dari View
                double p = view.getPanjang();
                double l = view.getLebar();

                // 2. Kirim data ke Model
                model.setPanjang(p);
                model.setLebar(l);

                // 3. Jalankan logika bisnis di Model
                model.hitungLuas();
                model.hitungKeliling();

                // 4. Ambil hasil dari Model dan tampilkan kembali di View
                double hasil = model.getLuas();
                view.setHasil(hasil);
                double kel = model.getKeliling();
                view.setHasilKeliling(kel);

            } catch (NumberFormatException ex) {
                // Handle jika user memasukkan huruf
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    // Inner class untuk menangani event klik tombol Reset
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Reset model dan view
            model.reset();
            view.resetInputs();
        }
    }
}