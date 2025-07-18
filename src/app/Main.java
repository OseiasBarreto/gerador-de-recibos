package app;

import ui.BuscaReciboForm;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BuscaReciboForm().setVisible(true);
        });
    }
}
