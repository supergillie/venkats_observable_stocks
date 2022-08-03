package org.example;

import java.util.List;
import io.reactivex.rxjava3.core.*;
import static java.lang.Thread.sleep;


public class StockServer {

    public static Observable<StockInfo> getFeed(List<String> symbols){
        System.out.println("greated");
        return Observable.create(emitter -> emitPrice(emitter, symbols));
    }
        public static void emitPrice(ObservableEmitter<StockInfo> emitter, List<String> symbols) {
        System.out.println("Ready to emit...");
        int count = 0;
        while(count <8) {
            symbols.stream()
                    .map(StockInfo::fetch)
                    .forEach(emitter::onNext);
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }

        emitter.onNext(new StockInfo("blah", 0.0));

    }
}
