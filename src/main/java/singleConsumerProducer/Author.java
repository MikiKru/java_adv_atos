package singleConsumerProducer;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Author extends Thread {
    private Text text;
    String [] textToPublish = {"A","B","C","D","E",null};

    @Override
    public void run(){
        for (int i = 0;  i < textToPublish.length; i++){
            try {
                sleep(new Random().nextInt(500));
                text.setTextToWrite(textToPublish[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
