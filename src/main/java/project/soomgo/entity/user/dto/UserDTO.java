package project.soomgo.entity.user.dto;

import lombok.Getter;


@Getter
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private boolean isMaster;
}
