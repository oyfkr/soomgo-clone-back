package project.soomgo.entity.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.soomgo.entity.user.Users;

@Getter
@NoArgsConstructor
public class UserCreateRequest {

    private String email;
    private String password;
    private String name;
    private boolean isMaster;

    public Users convertUserCreateDTOToUsers(PasswordEncoder passwordEncoder) {
        return Users.of(this, passwordEncoder);
    }

    public static UserCreateRequest of(String email, String password, String name, boolean isMaster) {
        UserCreateRequest instance = new UserCreateRequest();

        instance.email = email;
        instance.password = password;
        instance.name = name;
        instance.isMaster = isMaster;

        return instance;
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
