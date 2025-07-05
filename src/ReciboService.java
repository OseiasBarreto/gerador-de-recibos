import java.util.Comparator;
import java.util.List;

public class ReciboService {
    //ordenar a lista por data
    public void listarRecibosEmOrdem(List<Recibo> recibos){
        recibos.sort(Comparator.comparing(Recibo::getDataEmissao));
        for (Recibo r : recibos){
            System.out.println("Cliente: " + r.getCliente().getNome());
            System.out.println("Serviço: " + r.getServico().getDescricao());
            System.out.println("Valor: " + r.getServico().getValor());
            System.out.println("Data: " + r.getDataEmissao());
            System.out.println("---------");
        }
    }

}
