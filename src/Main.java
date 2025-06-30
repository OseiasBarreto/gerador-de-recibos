
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "12345678900", "11999999999", "joao@email.com");
        Servico servico = new Servico("Consultoria Java", 350.00, "PIX", LocalDate.now());

        Recibo recibo = new Recibo(cliente, servico, "Oséias Barreto", "27/06/2025");

    }
}