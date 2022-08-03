package org.example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;

import io.reactivex.rxjava3.core.*;


public class Sample {
public static void main(String[] args){
    java.util.List<String> symbols = Arrays.asList("MTC","MTC");

    Observable<StockInfo> feed = StockServer.getFeed(symbols);
    System.out.println("got observable");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    feed.subscribe(

            stockInfo -> System.out.println("Result kl "+ LocalDateTime.now().format(formatter) + ": " + stockInfo.ticker + " " + stockInfo.value),
            error -> System.err.println(error)
    );

}
}
