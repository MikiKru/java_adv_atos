package singleConsumerProducer;

public class Main {
    public static void main(String[] args) {
        Text t = new Text();
        Author a = new Author(t, new String[]{"A", "B", "C", "D", "E", null});
        Publisher p = new Publisher(t);
        a.start();
        p.start();
    }
}
