package oop;

public class Example extends Object{

//    public boolean compareUsersByLogin(User u1, User u2){
//        return u1.getLogin().equals(u2.getLogin());
//    }
    public Boolean compareUsersByLogin(Object o1, Object o2){
        Boolean result = null;
        try {
            result =((User) o1).getLogin().equals(((User) o2).getLogin());
        } catch(ClassCastException e){
            System.out.println("Błąd rzutowania");
        } catch (Exception e){
            System.out.println("Inny nieznany wyjątek");
        }
        return result;
    }
    public static void main(String[] args) {
        Example e = new Example();
        System.out.println(e.getClass().getName());
        // wykorzystanie polimorfizmu do porównania obiektów
        System.out.println(
                e.compareUsersByLogin(
                        new UserRegistration("y", "y"),
                        new UserRegistration("y", "y")));
    }
}
