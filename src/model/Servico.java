package model;

import java.time.LocalDate;

public class Servico {
    private String descricao;
    private double valor;
    private String formaPagamento;
    private LocalDate data;

    public Servico(String descricao, double valor, String formaPagamento, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
