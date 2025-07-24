
package ui;
import java.time.LocalDate;
import model.Servico;
import repository.ServicoRepository;

import java.util.Scanner;

public class MenuConsole {

    private static final ServicoRepository servicoRepository = new ServicoRepository();

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║      SISTEMA DE RECIBOS CODÊXIUM       ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1 - Cadastrar Cliente                  ║");
            System.out.println("║ 2 - Cadastrar Serviço                  ║");
            System.out.println("║ 3 - Emitir Recibo                      ║");
            System.out.println("║ 4 - Listar Todos os Recibos           ║");
            System.out.println("║ 5 - Buscar Recibo por CPF             ║");
            System.out.println("║ 6 - Sair                               ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    cadastrarServico(scanner);
                    break;
                case 3:
                    emitirRecibo(scanner);
                    break;
                case 4:
                    listarRecibos();
                    break;
                case 5:
                    buscarPorCpf(scanner);
                    break;
                case 6:
                    System.out.println("👋 Saindo do sistema...");
                    break;
                default:
                    System.out.println("⚠ Opção inválida.");
            }

        } while (opcao != 6);

        scanner.close();
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.println("⚠ Funcionalidade de cadastro de cliente ainda será implementada.");
    }

    private static void cadastrarServico(Scanner scanner) {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║     CADASTRO DE SERVIÇO     ║");
        System.out.println("╚══════════════════════════════╝");

        System.out.print("Digite o nome do serviço: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o valor do serviço (ex: 99.90): ");
        double valor = 0.0;

        try {
            valor = Double.parseDouble(scanner.nextLine());
            if (valor < 0) {
                System.out.println("❌ Valor não pode ser negativo.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Valor inválido. Use ponto ao invés de vírgula (ex: 49.90)");
            return;
        }

        System.out.print("Digite a forma de pagamento: ");
        String formaPagamento = scanner.nextLine();

        LocalDate data = LocalDate.now(); // ou você pode pedir para o usuário digitar

        Servico servico = new Servico(nome, valor, formaPagamento, data);
        servicoRepository.salvar(servico);

        System.out.println("✅ Serviço cadastrado com sucesso!");
    }

    private static void emitirRecibo(Scanner scanner) {
        System.out.println("⚠ Funcionalidade de emissão de recibo ainda será implementada.");
    }

    private static void listarRecibos() {
        System.out.println("⚠ Funcionalidade de listagem de recibos ainda será implementada.");
    }

    private static void buscarPorCpf(Scanner scanner) {
        System.out.println("⚠ Funcionalidade de busca por CPF ainda será implementada.");
    }
}
