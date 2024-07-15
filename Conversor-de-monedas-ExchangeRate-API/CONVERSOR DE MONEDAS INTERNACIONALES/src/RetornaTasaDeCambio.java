import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RetornaTasaDeCambio {
    public static double buscarTasaDeCambio(String moneda1, String moneda2) {
        //Variable local
        double tasaDeCambio;
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5a687aaef2866d1405928c90/pair/" + moneda1 + "/" + moneda2);
        HttpResponse<String> response = null;
        //Instancia de HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        // Instancia de HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // Enviar petición y obtener respuesta - Validación de Excepciones
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Deserialización de JSON
        Conversion conversion = new Gson().fromJson(response.body(), Conversion.class);

        return conversion.conversion_rate();
    }
}