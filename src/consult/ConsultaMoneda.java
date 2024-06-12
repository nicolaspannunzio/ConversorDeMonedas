package consult;

import com.google.gson.Gson;
import model.Moneda;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    String ApiKey = "8f633d128758b25e8910b261";

    public Moneda buscaMoneda(String baseCode, String targetCode, double monto){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + ApiKey + "/pair/" + baseCode + "/" + targetCode + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la solicitud: " + response.statusCode());
            }
            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la moneda: " + e.getMessage());
        }
    }
}