package modul10;

import javax.swing.SwingUtilities;
import modul10.controller.MahasiswaController;
import modul10.model.MahasiswaModel;
import modul10.view.MahasiswaView;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaView view = new MahasiswaView();
            MahasiswaModel model = new MahasiswaModel(view.model);
            new MahasiswaController(model, view);
            view.setVisible(true);
        });
    }
}