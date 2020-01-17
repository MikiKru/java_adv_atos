package thread_account;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Client implements Runnable {
    private Account account;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            account.pay(new Random().nextInt(100));
        }
    }
}
