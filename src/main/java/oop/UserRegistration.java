package oop;

import lombok.Data;

@Data
public class UserRegistration extends User {
    private String activationURL;

    public UserRegistration(String login, String password) {
        super(login, password);
        System.out.println("Konstruktor USER REGISTRATION");
        this.activationURL = "XXX";
    }
    @Override
    public String toString() {
        return "UserRegistration{" +
                "activationURL='" + activationURL + '\'' +
                "} " + super.toString();
    }

    public static void main(String[] args) {
        UserRegistration userRegistration = new UserRegistration(
                "x", "x");
        System.out.println(userRegistration);
//        System.out.println(userRegistration.userId); // składowe prywatne nie są dziedziczone
        userRegistration.getComment();
        User ur = new UserRegistration("u", "u");   // polimorfizm
        System.out.println(ur.getClass().getName());
        Object o = new User("u1","u1");
        System.out.println(o.getClass().getName());
    }

}
