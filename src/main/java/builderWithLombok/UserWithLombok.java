package builderWithLombok;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class UserWithLombok {
    private String login;
    private String password;
    private List<String> roles;

}
