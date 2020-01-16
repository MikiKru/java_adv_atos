package builderDesignPattern;

import lombok.ToString;

@ToString
public class User {
    private String login;
    private String password;
    private User(){}
    public static final class Builder{
        private String login;
        private String password;

        public Builder login(String login){
            this.login = login;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public User build(){
            User user = null;
            try {
                if (login == null || password == null) {
                    throw new IllegalAccessException();
                }
                user = new User();
                user.login = login;
                user.password = password;
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
            return user;
        }
    }
    public static Builder builder(){        // metoda statyczne zwracająca obiekt buildera
        return new Builder();
    }
}
