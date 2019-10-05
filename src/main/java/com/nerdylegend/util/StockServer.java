package com.nerdylegend.util;

import com.nerdylegend.StockInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.List;

public class StockServer {
    public static Observable<StockInfo> getFeed(List<String> companies) {
        return Observable.create(emitter -> emitPrice(emitter, companies));
    }

    private static void emitPrice(ObservableEmitter<StockInfo> emitter, List<String> companies) {
        System.out.println("Ready to emit...");
        int i =0;
        while (i < 5) {
            companies.stream()
                    .map(StockInfo::fetch)
                    .forEach(emitter::onNext);

            sleep(1000);
            if (i < 2) emitter.onError(new RuntimeException("oops"));
            i++;
        }
        emitter.onComplete();
        emitter.onNext(new StockInfo("blah", 0.0d));
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
