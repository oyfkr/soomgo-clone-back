package project.soomgo.entity.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.soomgo.entity.user.Users;

@Getter
@NoArgsConstructor
public class UserCreateRequest {

    @ApiModelProperty(value = "로그인에 쓰일 이메일", example = "asd@asd.com")
    private String email;
    @ApiModelProperty(value = "로그인에 쓰일 비밀번호", example = "1234")
    private String password;
    @ApiModelProperty(value = "회원이름", example = "오근혁")
    private String name;
    @ApiModelProperty(value = "고수 여부", example = "true")
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
