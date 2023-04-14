package project.soomgo.entity.user.dto;

import lombok.Getter;


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
}
