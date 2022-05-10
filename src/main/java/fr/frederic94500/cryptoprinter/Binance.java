package fr.frederic94500.cryptoprinter;

import java.text.DecimalFormat;

public class Binance {
    private String symbol;
    private String priceChange;
    private String priceChangePercent;
    private String weightedAvgPrice;
    private String prevClosePrice;
    private String lastPrice;
    private String lastQty;
    private String bidPrice;
    private String bidQty;
    private String askPrice;
    private String askQty;
    private String openPrice;
    private String highPrice;
    private String lowPrice;
    private String volume;
    private String quoteVolume;
    private long openTime;
    private long closeTime;
    private int firstId;
    private int lastId;
    private int count;

    public Binance() {
    }

    public Binance(String symbol, String priceChange, String priceChangePercent, String weightedAvgPrice, String prevClosePrice, String lastPrice, String lastQty, String bidPrice, String bidQty, String askPrice, String askQty, String openPrice, String highPrice, String lowPrice, String volume, String quoteVolume, int openTime, int closeTime, int firstId, int lastId, int count) {
        this.symbol = symbol;
        this.priceChange = priceChange;
        this.priceChangePercent = priceChangePercent;
        this.weightedAvgPrice = weightedAvgPrice;
        this.prevClosePrice = prevClosePrice;
        this.lastPrice = lastPrice;
        this.lastQty = lastQty;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.volume = volume;
        this.quoteVolume = quoteVolume;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.firstId = firstId;
        this.lastId = lastId;
        this.count = count;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder();
        sb.append("========== ").append(symbol).append("==========\n");
        sb.append("Price: ").append(df.format(Float.valueOf(lastPrice))).append("\n");
        sb.append("Percent: ").append(priceChangePercent).append("%\n");
        return sb.toString();
    }
}
