package ui;

import model.Cliente;
import repository.ClienteRepository;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteForm extends JFrame {

    private JTextField nomeField;
    private JTextField cpfCnpjField;
    private JTextField telefoneField;
    private JTextField emailField;

    private ClienteRepository repo = new ClienteRepository();

    public ClienteForm() {
        setTitle("Cadastro de Cliente");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Pergunta: O que os JLabel e JTextField fazem aqui?
        // Resposta: Criam campos visuais para o usuário digitar os dados.
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("CPF/CNPJ:"));
        cpfCnpjField = new JTextField();
        add(cpfCnpjField);

        add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        add(telefoneField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        JButton salvarBtn = new JButton("Salvar");

        // Pergunta: O que acontece quando o botão é clicado?
        // Resposta: Um novo cliente é criado com os dados dos campos e salvo no JSON.
        salvarBtn.addActionListener(e -> {
            String nome = nomeField.getText();
            String cpfCnpj = cpfCnpjField.getText();
            String telefone = telefoneField.getText();
            String email = emailField.getText();

            Cliente cliente = new Cliente(nome, cpfCnpj, telefone, email);

            List<Cliente> clientes = repo.carregarTodos();
            if (clientes == null) {
                clientes = new ArrayList<>();
            }

            clientes.add(cliente);
            repo.salvarTodos(clientes);

            JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
            dispose(); // fecha a janela
        });

        add(salvarBtn);

        setVisible(true);
    }
}
