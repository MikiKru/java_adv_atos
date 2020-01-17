package threadsCoordination;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final int NUMBER_OF_ITEM = 10;
        final int NUMBER_OF_PRODUCERS = 4;
        final int NUMBER_OF_CONSUMERS = 3;

        Item [] items = new Item[NUMBER_OF_ITEM];       // deklaracja tablicy 100 elementowej

        for (int i = 0; i < items.length; i++){         // uzupełnienie tablicy obiektami klasy Item
            items[i] = new Item();
        }

        // parallel stream
        long start = System.nanoTime();
        Stream.of(items).parallel()
                            .forEach(item -> {
                                item.produceMe();
                                item.consumeMe();
                            });
        long stop = System.nanoTime();
        System.out.println("Czas wykoania: " + (stop - start)/1_000_000 + "ms");
    }
}
