package project.soomgo.entity.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponse {

    private String email;
    private String name;
    private boolean isMaster;

    public static UserResponse of(String email, String name, boolean isMaster) {
        UserResponse instance = new UserResponse();

        instance.email = email;
        instance.name = name;
        instance.isMaster = isMaster;

        return instance;
    }
}
