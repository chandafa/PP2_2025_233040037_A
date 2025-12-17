package modul10.controller;

import modul10.model.MahasiswaModel;
import modul10.view.MahasiswaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class MahasiswaController {

    private MahasiswaModel model;
    private MahasiswaView view;

    public MahasiswaController(MahasiswaModel model, MahasiswaView view) {
        this.model = model;
        this.view = view;

        this.model.loadData();

        this.view.addSimpanListener(new SimpanListener());
        this.view.addEditListener(new EditListener());
        this.view.addHapusListener(new HapusListener());
        this.view.addClearListener(new ClearListener());
        this.view.addCariListener(new CariListener());
        this.view.addTableMouseListener(new TableMouseListener());
    }

    class SimpanListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = view.getTxtNama();
            String nim = view.getTxtNIM();
            String jurusan = view.getTxtJurusan();

            if (nama.trim().isEmpty() || nim.trim().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nama dan NIM tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (model.nimExists(nim)) {
                JOptionPane.showMessageDialog(view, "NIM sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            model.tambahData(nama, nim, jurusan);
            model.loadData();
            view.kosongkanForm();
        }
    }

    class EditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = view.getTxtNama();
            String nim = view.getTxtNIM();
            String jurusan = view.getTxtJurusan();
            model.ubahData(nama, nim, jurusan);
            model.loadData();
            view.kosongkanForm();
        }
    }

    class HapusListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nim = view.getTxtNIM();
            model.hapusData(nim);
            model.loadData();
            view.kosongkanForm();
        }
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.kosongkanForm();
        }
    }

    class CariListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String keyword = view.getTxtCari();
            model.cariData(keyword);
        }
    }

    class TableMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = view.getTable().getSelectedRow();
            view.setTxtNama(view.getTableModel().getValueAt(row, 1).toString());
            view.setTxtNIM(view.getTableModel().getValueAt(row, 2).toString());
            view.setTxtJurusan(view.getTableModel().getValueAt(row, 3).toString());
        }
    }
}
