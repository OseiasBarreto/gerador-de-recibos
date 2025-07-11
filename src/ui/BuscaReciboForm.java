package ui;

import model.Recibo;
import repository.ReciboRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscaReciboForm extends JFrame {

    private JTextField campoBusca;
    private JButton botaoBuscar;
    private JTextArea areaResultado;

    public BuscaReciboForm() {
        setTitle("Buscar Recibos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de busca (norte)
        JPanel painelBusca = new JPanel();
        painelBusca.setLayout(new FlowLayout());

        campoBusca = new JTextField(20);
        botaoBuscar = new JButton("Buscar");

        painelBusca.add(new JLabel("Nome ou CPF:"));
        painelBusca.add(campoBusca);
        painelBusca.add(botaoBuscar);

        add(painelBusca, BorderLayout.NORTH);

        // Área de resultado (centro)
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Ação do botão
        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRecibos();
            }
        });

        setVisible(true);
    }

    private void buscarRecibos() {
        String termo = campoBusca.getText().toLowerCase();
        ReciboRepository repo = new ReciboRepository();
        List<Recibo> resultados = repo.filtrarPorCliente(termo);

        areaResultado.setText("");

        if (resultados.isEmpty()) {
            areaResultado.setText("Nenhum recibo encontrado para: " + termo);
        } else {
            for (Recibo r : resultados) {
                areaResultado.append("Cliente: " + r.getCliente().getNome() + "\n");
                areaResultado.append("Serviço: " + r.getServico().getDescricao() + "\n");
                areaResultado.append("Valor: R$" + r.getServico().getValor() + "\n");
                areaResultado.append("Data: " + r.getDataEmissao() + "\n");
                areaResultado.append("--------------------------\n");
            }
        }
    }
}
