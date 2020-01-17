package threds;

public class MainThreads {
    public static void main(String[] args) throws InterruptedException {
        // utworzenie obiektu klasy rozszerzającej Thread
        ThreadsDemo th1 = new ThreadsDemo("Th-1");
        ThreadsDemo th2 = new ThreadsDemo("Th-2");
        ThreadsDemo th3 = new ThreadsDemo("Th-3");
        ThreadsDemo th4 = new ThreadsDemo("Th-4");
        System.out.println("Th-" + Thread.currentThread().getName() + " START");
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th1.join();     // jesteśmy w wątku main i join()
                        // powoduje oczekiwanie na zakńczenie metody run wątku th1
        th2.join();
        th3.join();
        th4.join();
        System.out.println("Th-" +Thread.currentThread().getName() + " STOP");
    }
}
