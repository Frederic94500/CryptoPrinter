package fr.frederic94500.cryptoprinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var crypto = new Crypto("https://api.binance.com/api/v3/ticker/24hr?symbol=", "BTCUSDT");
        if (crypto.isCorrect()) {
            System.out.println(crypto);
        } else {
            System.out.println("Error!");
        }
    }
}