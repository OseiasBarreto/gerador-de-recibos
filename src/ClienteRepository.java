import com.google.gson.Gson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ClienteRepository {
    private static final String CAMINHO_ARQUIVO = "clientes.json";
    private final Gson gson = new Gson();

//Metodo de salvar em json os objetos e usar o try catch
    public void salvarTodos(List<Cliente> clientes){
       try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO)){
           gson.toJson(clientes, writer);
       } catch (IOException e){
           e.printStackTrace();
       }
    }
    public List<Cliente> carregarTodos(){
        try (FileReader reader = new FileReader(CAMINHO_ARQUIVO)) {
           Type tipoLista = new TypeToken<List<Cliente>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
