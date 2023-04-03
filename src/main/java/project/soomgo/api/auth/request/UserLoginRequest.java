package project.soomgo.api.auth.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
public class UserLoginRequest {

    @ApiModelProperty(value = "로그인 이메일", example = "asd@asd.com")
    private String email;
    @ApiModelProperty(value = "비밀번호", example = "1234")
    private String password;
    @ApiModelProperty(value = "고수 여부", example = "true")
    private boolean isMaster;

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
