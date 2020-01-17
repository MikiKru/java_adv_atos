package singleConsumerProducer;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Author extends Thread {
    private Text text;
    String [] textToPublish;
    @Override
    public void run(){
        for (int i = 0;  i < textToPublish.length; i++){
            try {
                Thread timeTh = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(2000);

                        } catch (InterruptedException e) {
//                            e.printStackTrace();
                        }
                    }
                }) ;
                int sleepTime = new Random().nextInt(5000);
                System.out.println("Czas uśpienia: " + sleepTime);
                if(sleepTime < 2000){
                    sleep(sleepTime);
                    text.setTextToWrite(textToPublish[i]);
                } else if(timeTh.isAlive()) {
                    timeTh.start();
                    timeTh.join();
                    text.setTextToWrite(textToPublish[i]);
                } else {
                    System.out.println("Nic nie opublikowano");
                    timeTh.interrupt();
                }
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }
}
