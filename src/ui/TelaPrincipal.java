package ui;

import javax.swing.*; // Biblioteca do Swing
import java.awt.*;     // Para layout
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    // Construtor
    public TelaPrincipal() {
        setTitle("Sistema de Recibos"); // Título da janela
        setSize(400, 300);              // Tamanho da janela (largura, altura)
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Encerra o programa ao fechar

        // Painel para organizar os botões
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1)); // 6 linhas, 1 coluna

        // Criando botões
        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        JButton btnCadastrarServico = new JButton("Cadastrar Serviço");
        JButton btnGerarRecibo = new JButton("Gerar Recibo");
        JButton btnListarRecibos = new JButton("Listar Recibos");
        JButton btnBuscarPorCpf = new JButton("Buscar por CPF");
        JButton btnSair = new JButton("Sair");
        btnCadastrarCliente.addActionListener(e -> new TelaCadastroCliente());
        btnCadastrarServico.addActionListener(e -> new TelaCadastroServico());


        // Adicionando botões ao painel
        panel.add(btnCadastrarCliente);
        panel.add(btnCadastrarServico);
        panel.add(btnGerarRecibo);
        panel.add(btnListarRecibos);
        panel.add(btnBuscarPorCpf);
        panel.add(btnSair);


        add(panel);

        btnSair.addActionListener(e -> System.exit(0));


        setVisible(true);
    }



    public static void main(String[] args) {
        new TelaPrincipal(); // Cria a tela
    }
}
