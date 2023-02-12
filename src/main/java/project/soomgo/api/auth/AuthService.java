package project.soomgo.api.auth;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.soomgo.configure.TokenDTO;
import project.soomgo.configure.TokenProvider;
import project.soomgo.entity.token.RefreshToken;
import project.soomgo.entity.token.RefreshTokenRepository;
import project.soomgo.entity.user.Users;
import project.soomgo.entity.user.dto.UserCreateRequest;
import project.soomgo.entity.user.dto.UserResponse;
import project.soomgo.entity.user.repository.UsersRepository;
import project.soomgo.redis.RedisUtil;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthService {

    private final UsersRepository usersRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedisUtil redisUtil;

    public UserResponse createUser(UserCreateRequest userCreateDTO) {

        Optional<Users> users = usersRepository.findByEmail(userCreateDTO.getEmail());

        if (users.isPresent()) {
            throw new RuntimeException("이미 가입되어 있는 이메일입니다.");
        }

        Users savedUser = usersRepository.save(userCreateDTO.convertUserCreateDTOToUsers(passwordEncoder));

        // TODO 추후에 mapper 구현 후 수정할 부분
        return UserResponse.of(savedUser.getEmail(), savedUser.getName(),
                savedUser.isMaster());
    }

    public TokenDTO login(UserCreateRequest userCreateRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = userCreateRequest.toAuthentication();
        Authentication authenticate = null;
        try {
            authenticate = authenticationManagerBuilder.getObject()
                    .authenticate(authenticationToken);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        TokenDTO tokenDTO = tokenProvider.generateTokenDTO(authenticate);

        refreshTokenRepository.save(
                RefreshToken.of(authenticate.getName(), tokenDTO.getAccessToken()));

        return tokenDTO;
    }

    public String logout(String accessToken, Users users) {

        // refreshToken 테이블의 refreshToken 삭제
        refreshTokenRepository.deleteRefreshTokenByKey(users.getEmail());

        // 레디스에 accessToken 사용못하도록 등록
        redisUtil.setBlackList(accessToken, "accessToken", 5);

        return "로그아웃 완료";
    }
}
