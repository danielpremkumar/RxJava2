package com.nerdylegend;

import com.nerdylegend.util.StockServer;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        var companies = List.of("GOOG","AMAZ","FACEB");
        var  observable  = StockServer.getFeed(companies);
        System.out.println("Got Observable");
        observable
                //.onErrorResumeNext()    -- To handle error and not close the channels
                .filter(stockInfo -> stockInfo.getValue() > 50)
                .map(stockInfo -> new StockInfo(stockInfo.getTicker(), stockInfo.getValue() * 0.9))
                .subscribe(
                        stockInfo -> System.out.println(stockInfo), // success channel
                        err -> System.out.println("Error : " + err), // error channel
                        () -> System.out.println("Done"));  // complete channel
    }
}