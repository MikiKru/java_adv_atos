package builderDesignPattern;

public class Main {
    public static void main(String[] args) {
        User user1 = User.builder()
                .login("Miki")
                .password("Kru")
                .build();
        System.out.println(user1);

        User user2 = User.builder()
                .password("Kru")
                .login("Miki")
                .build();
        System.out.println(user2);

        User user3 = User.builder()
                .build();
        System.out.println(user3);

        User user4 = User.builder()
                .login("Miki")
                .build();
        System.out.println(user4);
    }
}
