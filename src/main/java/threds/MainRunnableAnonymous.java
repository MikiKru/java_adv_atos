package threds;

import java.util.*;

import static java.lang.Thread.sleep;


public class MainRunnableAnonymous {
    private Deque<Integer> deque = new ArrayDeque<>();
    private boolean isProduced = false;
    private int global_i;
    public void producer() {
        Thread thProducer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    deque.addLast(i);
                    global_i++;
                    isProduced = true;
                    System.out.println("Dodano: " + i);
                    try {
                        sleep(new Random().nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thProducer.start();
    }

    public void consumer() {
        Thread thConsumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (global_i < 10) {
                    if(isProduced) {
                        System.out.println("Skonsumowano: " + deque.removeFirst());
                        try {
                            sleep(new Random().nextInt(500));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thConsumer.start();
    }
    public static void main(String[] args) {
        MainRunnableAnonymous run = new MainRunnableAnonymous();
        run.producer();
        run.consumer();
    }
}
