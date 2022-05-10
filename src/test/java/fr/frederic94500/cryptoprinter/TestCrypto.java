package fr.frederic94500.cryptoprinter;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCrypto {
    @Test
    public void testCrypto() throws IOException, InterruptedException {
        var crypto = new Crypto("https://api.binance.com/api/v3/ticker/24hr?symbol=BTCUSDT");
        assertTrue(crypto.isCorrect());
    }
}
