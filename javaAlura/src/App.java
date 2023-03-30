import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI adressURI = URI.create(url);
        HttpClient clientProtocol = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(adressURI).GET().build();
        HttpResponse<String> response = clientProtocol.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
    }
}
