/*
    Author: Vladimir Mate
    Type: Class
    Description: Clase de peticiones a Exchangerate-API
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedaApi {
    public ConsultaDivisa convertirDivisa(String divisa, String cambio, double valor) {
        HttpClient client = HttpClient.newHttpClient();

        URI uriURL = URI.create("https://v6.exchangerate-api.com/v6/1f1c5dcacadc375f771edb43/pair/" + divisa +"/"+ cambio +"/" + valor);
        HttpRequest request = HttpRequest.newBuilder().uri(uriURL).build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), ConsultaDivisa.class);
    }
}
