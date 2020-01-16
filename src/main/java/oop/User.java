package oop;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data       // getter setter toString
public class User {
    private static Long globalId = 0L;
    private long userId;
    private String login;
    private String password;
    private LocalDateTime registrationDate;
    private boolean status;

    private static Long auto_increment(){
        return ++globalId;
    }
    protected void getComment(){
        System.out.println("Komentarz jest chroniony");
    }

    public User(String login, String password) {
        System.out.println("Konstruktor USER");
        this.userId = auto_increment();
        this.login = login;
        this.password = password;
        this.registrationDate = LocalDateTime.now();
        this.status = false;
    }

    public static void main(String[] args) {
        System.out.println(User.globalId);
        User user1 = new User("m", "m");
        User user2 = new User("k", "k");
        User user3 = new User("t", "t");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

    }
}
