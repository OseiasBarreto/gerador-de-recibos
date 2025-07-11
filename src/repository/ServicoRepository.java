package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Servico;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ServicoRepository {
    private static final String CAMINHO_ARQUIVO = "servicos.json";
    private final Gson gson = new Gson();

    public void salvarTodos(List<Servico> servicos) {
        try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO)) {
            gson.toJson(servicos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Servico> carregarTodos() {
        try (FileReader reader = new FileReader(CAMINHO_ARQUIVO)) {
            Type tipoLista = new TypeToken<List<Servico>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
