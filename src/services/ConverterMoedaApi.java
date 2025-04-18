package services;

import models.Conversor;
import exceptions.InvalidApiKeyException;
import com.google.gson.*;                           // gson LIB
import io.github.cdimascio.dotenv.Dotenv;           // .env LIB

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterMoedaApi {

    public Conversor buscaConversor(String baseCode, String targetCode, double valor){
        Dotenv dotenv = Dotenv.load();

        String BASE_URL = "https://v6.exchangerate-api.com/v6/";            // URL DA API
        String API_KEY = dotenv.get("API_KEY");                             // CHAVE DA API (da .env)

        // Docs para "Pair Conversion Requests" -> https://www.exchangerate-api.com/docs/pair-conversion-requests
        URI endereco = URI.create(BASE_URL + API_KEY + "/pair/" + baseCode + "/" + targetCode + "/" + valor);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            String status = json.get("result").getAsString();

            if (status.equals("error")) {
                String errorType = json.get("error-type").getAsString();

                if (errorType.equals("invalid-key")) {
                    throw new InvalidApiKeyException("Chave da API inválida ou expirada. Verifique sua .env.");
                }

                throw new RuntimeException("Erro da API: " + errorType);
            }

            return new Gson().fromJson(response.body(), Conversor.class);

        } catch (InvalidApiKeyException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter dados da API: " + e.getMessage());
        }
    }
}