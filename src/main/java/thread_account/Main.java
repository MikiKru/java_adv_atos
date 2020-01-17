package thread_account;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(500);
        Client c1 = new Client(account);
        Client c2 = new Client(account);
        Client c3 = new Client(account);
        Thread th1 = new Thread(c1);
        Thread th2 = new Thread(c2);
        Thread th3 = new Thread(c3);
        th1.start();
        th2.start();
        th3.start();
    }
}
