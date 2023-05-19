package project.soomgo.entity.user.dto;

import lombok.Getter;
import project.soomgo.entity.user.Users;


@Getter
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private boolean isMaster;

    public static UserDTO of(Long id, String name, String email, boolean isMaster) {
        UserDTO instance = new UserDTO();

        instance.id = id;
        instance.name = name;
        instance.email = email;
        instance.isMaster = isMaster;

        return instance;
    }

    public static UserDTO ofByUser(Users users) {
        UserDTO instance = new UserDTO();

        instance.id = users.getId();
        instance.name = users.getName();
        instance.email = users.getEmail();
        instance.isMaster = users.isMaster();

        return instance;
    }
}
