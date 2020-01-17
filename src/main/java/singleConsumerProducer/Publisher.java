package singleConsumerProducer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Publisher extends Thread {
    private Text text;

    @Override
    public void run(){
        try {
            String textToPublish = text.getTextToWrite();
            while(textToPublish != null){
                System.out.println("-> " + textToPublish);
                textToPublish = text.getTextToWrite();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
