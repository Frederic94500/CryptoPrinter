package fr.frederic94500.cryptoprinter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Crypto {
    private final HttpClient client;
    private final HttpRequest request;
    private final String pair;

    public Crypto(String url, String pair) {
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder(URI.create(url + pair)).header("accept", "*/*").build();
        this.pair = pair;
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
        try {
            return String.valueOf(getResponse().body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
