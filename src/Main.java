import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteRepository repo = new ClienteRepository();

        // Criando lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("João", "123", "1199", "joao@email.com"));
        clientes.add(new Cliente("Maria", "456", "1188", "maria@email.com"));

        // Salvando lista
        repo.salvarTodos(clientes);

        // Carregando lista
        List<Cliente> listaCarregada = repo.carregarTodos();
        if (listaCarregada != null) {
            for (Cliente c : listaCarregada) {
                System.out.println("Cliente: " + c.getNome());
            }
        }
    }
}
