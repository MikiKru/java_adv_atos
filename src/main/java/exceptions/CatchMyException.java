package exceptions;

public class CatchMyException {
    public static void main(String[] args) {
        int i = 1;
        try{
            if(i == 0){
                throw new MyException("Mój wyjątek");
            }
        } catch (MyException e){
            System.out.println("Obsługa mojego wyjątku");
            e.myService();
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Co ma się wydarzyć po każdej obsłudze");
        }
    }
}
