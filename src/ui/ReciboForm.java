package ui;

import model.Cliente;
import model.Servico;
import model.Recibo;
import repository.ClienteRepository;
import repository.ServicoRepository;
import repository.ReciboRepository;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class ReciboForm extends JFrame {

    private JComboBox<Cliente> comboClientes;
    private JComboBox<Servico> comboServicos;
    private JButton btnSalvar;

    public ReciboForm() {
        setTitle("Cadastro de Recibo");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        comboClientes = new JComboBox<>();
        comboServicos = new JComboBox<>();
        btnSalvar = new JButton("Salvar Recibo");

        add(new JLabel("Cliente:"));
        add(comboClientes);
        add(new JLabel("Serviço:"));
        add(comboServicos);
        add(new JLabel(""));
        add(btnSalvar);

        carregarClientesEServicos();

        btnSalvar.addActionListener(e -> salvarRecibo());

        setVisible(true);
    }

    private void carregarClientesEServicos() {
        ClienteRepository clienteRepo = new ClienteRepository();
        List<Cliente> clientes = clienteRepo.carregarTodos();
        for (Cliente c : clientes) {
            comboClientes.addItem(c);
        }

        ServicoRepository servicoRepo = new ServicoRepository();
        List<Servico> servicos = servicoRepo.carregarTodos();
        for (Servico s : servicos) {
            comboServicos.addItem(s);
        }
    }

    private void salvarRecibo() {
        Cliente clienteSelecionado = (Cliente) comboClientes.getSelectedItem();
        Servico servicoSelecionado = (Servico) comboServicos.getSelectedItem();

        if (clienteSelecionado == null || servicoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione cliente e serviço.");
            return;
        }

        Recibo recibo = new Recibo(clienteSelecionado, servicoSelecionado, LocalDate.now());
        ReciboRepository repo = new ReciboRepository();
    repo.salvar(recibo);

        JOptionPane.showMessageDialog(this, "Recibo salvo com sucesso!");
        dispose();
    }
}
