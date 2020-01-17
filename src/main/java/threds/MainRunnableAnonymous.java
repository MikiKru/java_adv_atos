package threds;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

import static java.lang.Thread.sleep;


public class MainRunnableAnonymous {
    private ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();
    private boolean isProduced = false;
    private boolean isConsumed = false;     // czy jest coś do pobrania
    private int global_i;
    Thread thProducer;
    Thread thConsumer;

    public Thread producer() {
        thProducer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    deque.addLast(i);
                    global_i++;
                    isProduced = true;
                    System.out.println("Dodano: " + i);
                }
                isProduced = false;
            }
        });
        return thProducer;
    }

    public Thread consumer() {
        thConsumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (global_i < 10) {
                    if (isProduced) {
                        System.out.println("Skonsumowano: " + deque.removeFirst());
                    }
                }
            }
        });
        return thConsumer;
    }

    public static void main(String[] args) throws InterruptedException {
        MainRunnableAnonymous run = new MainRunnableAnonymous();
        run.consumer().start();
        run.producer().start();

    }
}
