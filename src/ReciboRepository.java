import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public class ReciboRepository {
    private static final String CAMINHO_ARQUIVO = "recibos.json";

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .setPrettyPrinting()
            .create();

    public void salvarTodos(List<Recibo> recibos){
        try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO)){
            gson.toJson(recibos, writer);
            System.out.println("Recibos salvos com sucesso!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Recibo> carregarTodos(){
        try (FileReader reader = new FileReader(CAMINHO_ARQUIVO)){
            Type tipoLista = new TypeToken<List<Recibo>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    public void salvarRecibo (Recibo recibo){
        List<Recibo> recibos = carregarTodos();
        if (recibos == null){
            recibos = new java.util.ArrayList<>();
        }
        recibos.add(recibo);

        salvarTodos(recibos);
    }
    public void salvaRecibo (Recibo recibo){
        List<Recibo> recibos = carregarTodos();
        if (recibos == null) {
            recibos = new java.util.ArrayList<>();
        }
        recibos.add(recibo);
        salvarTodos(recibos);
    }

}
