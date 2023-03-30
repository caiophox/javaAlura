import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        //fazer conexão HTTP e buscar 250 filmes no topo
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI adressURI = URI.create(url);
        HttpClient clientProtocol = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(adressURI).GET().build();
        HttpResponse<String> response = clientProtocol.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extração de dados relevantes
        var parser = new JsonParser();
        List<Map<String, String>> movieList = parser.parse(body) ;

        //Exibir os itens
        for (Map<String,String> filme : movieList) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }
}
