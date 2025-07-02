import java.time.LocalDate;

public class Recibo {
    private Cliente cliente;
    private Servico servico;
    private String prestador;
    private LocalDate dataEmissao;

    public Recibo(Cliente cliente, Servico servico, String prestador, LocalDate dataEmissao) {
        this.cliente = cliente;
        this.servico = servico;
        this.prestador = prestador;
        this.dataEmissao = dataEmissao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}

