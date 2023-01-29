package project.soomgo.api.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import project.soomgo.configure.TokenDTO;
import project.soomgo.entity.user.Users;
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

    @PatchMapping("/logout")
    public ResponseEntity<String> logout(@AuthenticationPrincipal CustomDetails customDetails) {

        Users users = customDetails.getUsers();
        return ResponseEntity.ok("성공");
    }
}
