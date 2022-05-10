package fr.frederic94500.cryptoprinter;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Crypto {
    private final HttpClient client;
    private final HttpRequest request;

    public Crypto(String url) {
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder(URI.create(url)).header("accept", "*/*").build();
    }

    public HttpResponse getResponse() throws IOException, InterruptedException {
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public int getCode() throws IOException, InterruptedException {
        return getResponse().statusCode();
    }

    public boolean isCorrect() throws IOException, InterruptedException {
        return getCode() <= 299;
    }

    @Override
    public String toString() {
        var gson = new Gson();
        try {
            var responseJSON = gson.fromJson((String) getResponse().body(), Binance.class);
            return responseJSON.toString();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
