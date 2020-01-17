package threds;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class ThreadsDemo extends Thread {
    // mogą występować pola i metody klasowe
    String threadName;

    @Override
    public void run(){
        // edycja nazwy wątku
        Thread.currentThread().setName(threadName);
        // determinuje co ma się wykonać przy wystartowaniu wątku
        for (int i = 0; i < 10; i++){
            System.out.printf(
                    "thread: %s - task: %d \n",
                    Thread.currentThread().getName(),
                    i);
            try {
                sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
