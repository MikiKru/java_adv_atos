package threadsCoordination;

import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerProducer implements Runnable {
    private static final AtomicInteger COUNTER = new AtomicInteger();
    private static final Integer LIMIT = 10;
    private Item[] items;
    private int i;

    public ConsumerProducer(Item[] items) {
        this.items = items;
    }

    @Override
    public void run() {
        while((i = COUNTER.getAndIncrement()) < LIMIT ){
            items[i].produceMe();
            items[i].consumeMe();
        }
    }
}
