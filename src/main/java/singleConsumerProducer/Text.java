package singleConsumerProducer;

public class Text {
    String text;
    boolean newText;

    synchronized void setTextToWrite(String s) throws InterruptedException {
        while (newText){
            wait();
        }
        text = s;
        newText = true;
        notifyAll();
    }

    synchronized String getTextToWrite() throws InterruptedException {
        while(!newText){
            wait();
        }
        newText = false;
        notifyAll();
        return text;
    }
}
