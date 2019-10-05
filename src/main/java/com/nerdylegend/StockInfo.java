package com.nerdylegend;

public class StockInfo {
    private String ticker;
    private double value;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public StockInfo(String ticker, double value) {
        this.ticker = ticker;
        this.value = value;
    }

    public static StockInfo fetch(String ticker) {
        if (Math.random() > 0.94) throw new RuntimeException("oops, unexpected error");
        return new StockInfo(ticker, Math.random() * 100);
    }

    @Override
    public String toString() {
        return  ticker + " : " + value ;
    }
}
