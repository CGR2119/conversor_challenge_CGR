import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public Moneda buscarConversion(String monedaInicial, String monedaFinal, long cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/786061e8e5cbad11f26ff1a0/pair/"
                + monedaInicial + "/" + monedaFinal + "/" + cantidad + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No fue posible realizar la conversión");
        }
    }
}
