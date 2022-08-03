package org.example;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.Map;

public class StockInfo{
    public double value;
    public static String ticker;

    public StockInfo (String theTicker, double theValue) {
    ticker = theTicker;
    value = theValue;
}

public static StockInfo fetch(String ticker) {
    Stock stock = null;
    try {
        stock = YahooFinance.get(ticker);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    return new StockInfo(ticker, stock.getQuote().getPrice().doubleValue());

}

}
