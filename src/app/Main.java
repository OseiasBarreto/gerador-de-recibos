package app;

import model.Cliente;
import model.Recibo;
import model.Servico;
import repository.ReciboRepository;
import java.util.Collections;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public class Main {
    public static void main(String[] args) {




        // Criar cliente
        Cliente cliente = new Cliente("João Silva", "12345678900", "11999999999", "joao@email.com");

        // Criar serviço
        Servico servico = new Servico("Desenvolvimento de site", 1200.00, "PIX", LocalDate.now());

        // Criar recibo
        Recibo recibo = new Recibo(cliente, servico, "Oséias Barreto", LocalDate.now());

        // Criar repositório
        ReciboRepository repo = new ReciboRepository();

        // Salvar recibo no JSON
            repo.salvarRecibo(recibo);

        // Ler todos os recibos salvos
         List<Recibo> recibos = repo.carregarTodos();


         //ordenar recibos por data
        Collections.sort(recibos);

        // Mostrar no console
        for (Recibo r : recibos) {
            System.out.println("Cliente: " + r.getCliente().getNome());
            System.out.println("Serviço: " + r.getServico().getDescricao());
            System.out.println("Valor: R$" + r.getServico().getValor());
            System.out.println("Data: " + r.getDataEmissao());
            System.out.println("-----------");
        }
    }
}
