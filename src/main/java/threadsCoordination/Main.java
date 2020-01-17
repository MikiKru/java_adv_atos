package threadsCoordination;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUMBER_OF_ITEM = 10;
        final int NUMBER_OF_PRODUCERS = 4;
        final int NUMBER_OF_CONSUMERS = 3;

        Item [] items = new Item[NUMBER_OF_ITEM];       // deklaracja tablicy 100 elementowej

        for (int i = 0; i < items.length; i++){         // uzupełnienie tablicy obiektami klasy Item
            items[i] = new Item();
        }

        // parallel stream
//        long start = System.nanoTime();
//        Stream.of(items).parallel()
//                            .forEach(item -> {
//                                item.produceMe();
//                                item.consumeMe();
//                            });
//        long stop = System.nanoTime();
//        System.out.println("Czas wykoania: " + (stop - start)/1_000_000 + "ms");

        // thread pools
        int i = 0;
        long start = System.nanoTime();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors
                .newFixedThreadPool(NUMBER_OF_CONSUMERS + NUMBER_OF_PRODUCERS);
        for(int j = 0; j < (NUMBER_OF_CONSUMERS + NUMBER_OF_PRODUCERS); j++){
            threadPoolExecutor.submit(new ConsumerProducer(items));  // wykorania run w klasie ConsumerProducer
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(100, TimeUnit.SECONDS);
        long stop = System.nanoTime();
        System.out.println("Czas wykoania: " + (stop - start)/1_000_000 + "ms");
    }
}
