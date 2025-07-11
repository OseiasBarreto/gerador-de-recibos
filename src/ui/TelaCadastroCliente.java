package ui;

import model.Cliente;
import repository.ClienteRepository;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroCliente extends JFrame {

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(350, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Fecha só essa janela

        // Painel de formulário
        JPanel panel = new JPanel(new GridLayout(5, 2));

        // Campos de entrada
        JTextField campoNome = new JTextField();
        JTextField campoCpf = new JTextField();
        JTextField campoTelefone = new JTextField();
        JTextField campoEmail = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        // Adiciona os componentes ao painel
        panel.add(new JLabel("Nome:"));
        panel.add(campoNome);

        panel.add(new JLabel("CPF/CNPJ:"));
        panel.add(campoCpf);

        panel.add(new JLabel("Telefone:"));
        panel.add(campoTelefone);

        panel.add(new JLabel("Email:"));
        panel.add(campoEmail);

        panel.add(new JLabel()); // espaço vazio
        panel.add(btnSalvar);

        // Adiciona o painel à janela
        add(panel);

        // Ação do botão
        btnSalvar.addActionListener(e -> {
            String nome = campoNome.getText();
            String cpf = campoCpf.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();

            // Criando o cliente
            Cliente novoCliente = new Cliente(nome, cpf, telefone, email);

            // Salvando com o repository
            ClienteRepository repo = new ClienteRepository();
            java.util.List<Cliente> clientes = repo.carregarTodos();
            if (clientes == null) {
                clientes = new java.util.ArrayList<>();
            }
            clientes.add(novoCliente);
            repo.salvarTodos(clientes);

            JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
            dispose(); // Fecha a janela
        });

        setVisible(true);
    }
}
