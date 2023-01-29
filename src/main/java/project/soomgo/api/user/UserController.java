package project.soomgo.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.soomgo.api.auth.CustomDetails;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("test")
    public ResponseEntity<String> test(
            @AuthenticationPrincipal CustomDetails customDetails
    ) {

        return ResponseEntity.ok("test");
    }
}
