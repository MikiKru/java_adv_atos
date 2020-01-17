package threds;

import java.util.Random;

import static java.lang.Thread.sleep;

public class RunnableDemo implements Runnable {
    private String [] words = "w najnowszym sondażu prezydenckim doszło do niespodziewanych roszad na podium i dupa".split(" ");

    @Override
    public void run() {
        String sentence = "";
        // wygenrował zadnie składające się z 10 słów
        for(int i = 0; i < 10; i++){
            sentence += words[new Random().nextInt(words.length)] + " ";
            System.out.println(sentence);
            try {
                sleep(new Random().nextInt(500));           // uśpienie wątku na czas 0-500 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
