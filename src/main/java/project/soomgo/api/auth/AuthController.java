package project.soomgo.api.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.soomgo.configure.TokenDTO;
import project.soomgo.entity.user.dto.UserCreateRequest;
import project.soomgo.entity.user.dto.UserResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> createUser(
            @RequestBody UserCreateRequest userCreateDTO
    ) {
        return ResponseEntity.ok(authService.createUser(userCreateDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody UserCreateRequest userCreateRequest) {
        return ResponseEntity.ok(authService.login(userCreateRequest));
    }
}
