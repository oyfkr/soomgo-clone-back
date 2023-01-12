package project.soomgo.configure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresln;

    public static TokenDTO of (String grantType, String accessToken, String refreshToken, Long accessTokenExpiresln) {
        TokenDTO instance = new TokenDTO();

        instance.grantType = grantType;
        instance.accessToken = accessToken;
        instance.refreshToken = refreshToken;
        instance.accessTokenExpiresln = accessTokenExpiresln;

        return instance;
    }
}
