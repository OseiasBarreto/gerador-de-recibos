package app;



public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BuscaReciboForm().setVisible(true);
        });
    }
}
