package ui;

import model.Servico;
import repository.ServicoRepository;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastroServico extends JFrame {

    public TelaCadastroServico() {
        setTitle("Cadastro de Serviço");
        setSize(350, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField campoDescricao = new JTextField();
        JTextField campoValor = new JTextField();
        JTextField campoFormaPagamento = new JTextField();
        JTextField campoData = new JTextField(); // formato: yyyy-MM-dd
        JButton btnSalvar = new JButton("Salvar");

        panel.add(new JLabel("Descrição:"));
        panel.add(campoDescricao);

        panel.add(new JLabel("Valor:"));
        panel.add(campoValor);

        panel.add(new JLabel("Forma de Pagamento:"));
        panel.add(campoFormaPagamento);

        panel.add(new JLabel("Data (yyyy-MM-dd):"));
        panel.add(campoData);

        panel.add(new JLabel());
        panel.add(btnSalvar);

        add(panel);

        btnSalvar.addActionListener(e -> {
            try {
                String descricao = campoDescricao.getText();
                double valor = Double.parseDouble(campoValor.getText());
                String formaPagamento = campoFormaPagamento.getText();
                LocalDate data = LocalDate.parse(campoData.getText());

                Servico servico = new Servico(descricao, valor, formaPagamento, data);

                ServicoRepository repo = new ServicoRepository();
                List<Servico> servicos = repo.carregarTodos();
                if (servicos == null) {
                    servicos = new ArrayList<>();
                }
                servicos.add(servico);
                repo.salvarTodos(servicos);

                JOptionPane.showMessageDialog(this, "Serviço salvo com sucesso!");
                dispose();
            } catch (NumberFormatException | DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Erro: Verifique os campos numéricos e de data.");
            }
        });

        setVisible(true);
    }
}
