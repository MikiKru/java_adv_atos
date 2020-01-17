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
                sleep(new Random().nextInt(5000));
                text.setTextToWrite(textToPublish[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
