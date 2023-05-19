package project.soomgo.api.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.soomgo.api.auth.CustomDetails;
import project.soomgo.api.user.service.UserService;
import project.soomgo.entity.user.dto.UserDTO;
import project.soomgo.exception.BaseException;
import project.soomgo.exception.ErrorCode;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
}
