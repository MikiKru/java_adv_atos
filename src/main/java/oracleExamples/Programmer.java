package oracleExamples;

public class Programmer extends Writer {
    public static void write() {
        System.out.println("Writing code");
    }
    public static void main(String[] args) {
        Writer w = new Programmer();
        System.out.println(w.getClass().getName());
        w.write();

    }
}