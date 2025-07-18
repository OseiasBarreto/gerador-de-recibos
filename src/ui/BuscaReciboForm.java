package ui;

import model.Recibo;
import repository.ReciboRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BuscaReciboForm extends JFrame {
    private JTextField cpfField;
    private JButton buscarButton;
    private JTable tabela;
    private DefaultTableModel tabelaModelo;

    public BuscaReciboForm() {
        setTitle("Buscar Recibos por CPF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de topo com campo CPF e botão
        JPanel topo = new JPanel();
        topo.setLayout(new FlowLayout());

        topo.add(new JLabel("CPF:"));
        cpfField = new JTextField(15);
        topo.add(cpfField);

        buscarButton = new JButton("Buscar");
        topo.add(buscarButton);

        add(topo, BorderLayout.NORTH);

        // Tabela para exibir os recibos
        String[] colunas = {"Cliente", "Serviço", "Valor", "Data"};
        tabelaModelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(tabelaModelo);
        JScrollPane scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);

        // Ação do botão buscar
        buscarButton.addActionListener(e -> buscarRecibos());
    }

    private void buscarRecibos() {
        String cpf = cpfField.getText().trim();

        ReciboRepository repo = new ReciboRepository();
        List<Recibo> resultados = repo.filtrarPorCpf(cpf);

        tabelaModelo.setRowCount(0); // Limpa a tabela

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum recibo encontrado para o CPF informado.");
        } else {
            for (Recibo r : resultados) {
                Object[] linha = {
                        r.getCliente().getNome(),
                        r.getServico().getDescricao(),
                        "R$" + r.getServico().getValor(),
                        r.getDataEmissao()
                };
                tabelaModelo.addRow(linha);
            }
        }
    }
}
