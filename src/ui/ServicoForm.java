package app.ui;

import model.Servico;
import repository.ServicoRepository;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicoForm extends JFrame {

    // Campos do formulário
    private JTextField descricaoField;
    private JTextField valorField;
    private JTextField formaPagamentoField;

    public ServicoForm() {
        setTitle("Cadastro de Serviço");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha só essa janela

        // Painel principal
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));


        panel.add(new JLabel("Descrição:"));
        descricaoField = new JTextField();
        panel.add(descricaoField);

        panel.add(new JLabel("Valor (ex: 1200.00):"));
        valorField = new JTextField();
        panel.add(valorField);

        panel.add(new JLabel("Forma de Pagamento:"));
        formaPagamentoField = new JTextField();
        panel.add(formaPagamentoField);

        JButton salvarButton = new JButton("Salvar Serviço");
        panel.add(salvarButton);

        // Quando o botão eh clicado...
        salvarButton.addActionListener(e -> salvarServico());

        // Adiciona o painel a janela
        add(panel);
        setLocationRelativeTo(null); // Centraliza
        setVisible(true);
    }

    private void salvarServico() {
        String descricao = descricaoField.getText();
        String formaPagamento = formaPagamentoField.getText();

        double valor;
        try {
            valor = Double.parseDouble(valorField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido!");
            return;
        }

        Servico servico = new Servico(descricao, valor, formaPagamento, LocalDate.now());

        ServicoRepository repo = new ServicoRepository();
        List<Servico> lista = repo.carregarTodos();
        if (lista == null) lista = new ArrayList<>();
        lista.add(servico);
        repo.salvarTodos(lista);

        JOptionPane.showMessageDialog(this, "Serviço salvo com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        descricaoField.setText("");
        valorField.setText("");
        formaPagamentoField.setText("");
    }
}
