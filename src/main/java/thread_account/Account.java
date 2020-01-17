package thread_account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private double saldo;

    public synchronized void pay(double amount){        // metoda synchronizowana -> metoda atomowa
        if(saldo >= amount){
            System.out.println("Stan konta: " + getSaldo());
            saldo -= amount;
            System.out.println(Thread.currentThread().getName() + " płacę kwotę: " + amount + " stan konta: " + getSaldo());
        } else {
            System.out.println(Thread.currentThread().getName() + " brak środków do wypłacenia: " + amount + " stan konta: " + getSaldo());
        }
    }

}
