package builderWithLombok;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserWithLombok user =
                new UserWithLombok.UserWithLombokBuilder()
                        .login("miki")
                        .password("kru")
                        .roles(new ArrayList<>(Arrays.asList("ROLE_USER")))
                        .build();
        System.out.println(user);

    }
}
