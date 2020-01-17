package threadPools;

import javafx.concurrent.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {
    private ExecutorService executorService;

    public ExecutorService createSingleThread(){
        executorService = Executors.newSingleThreadExecutor();
        return executorService;
    }
    public ExecutorService createFixedThreads(int n){
        executorService = Executors.newFixedThreadPool(n);
        return executorService;
    }
    public ExecutorService createDynamicThreads(){
        executorService = Executors.newCachedThreadPool();
        return executorService;
    }
    public void executeTask(){
        Runnable task = () -> {
            for (int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        };
        executorService.submit(task);       // wykonanie - wystartowanie wątku
    }
    public void shutDown(){
        executorService.shutdown();
    }
    public static void main(String[] args) {
        ThreadPools threadPools = new ThreadPools();
        threadPools.createSingleThread();
        threadPools.executeTask();
        threadPools.executeTask();
        threadPools.executeTask();
        threadPools.shutDown();
    }



}
