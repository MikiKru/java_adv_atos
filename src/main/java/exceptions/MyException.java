package exceptions;

public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public void myService(){
        System.out.println("my service method");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
