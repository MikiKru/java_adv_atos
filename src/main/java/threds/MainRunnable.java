package threds;

public class MainRunnable {
    public static void main(String[] args) throws InterruptedException {
        Thread th0 = new Thread(new RunnableDemo());
        Thread th1 = new Thread(new RunnableDemo());
        long start = System.nanoTime();
        th0.start();
        th1.start();
        th0.join();
        th1.join();
        long stop = System.nanoTime();
        System.out.println("Czas wykonania: " + (stop - start)/ 1_000_000 + "ms");



    }
}
