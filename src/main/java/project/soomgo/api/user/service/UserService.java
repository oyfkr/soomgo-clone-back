package project.soomgo.api.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.soomgo.entity.user.Users;
import project.soomgo.entity.user.dto.UserDTO;
import project.soomgo.entity.user.repository.UsersRepository;
import project.soomgo.exception.BaseException;
import project.soomgo.exception.ErrorCode;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public UserDTO getUser(Long userId) {

        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> BaseException.of(ErrorCode.USER_NOT_FOUND));
        return UserDTO.ofByUser(user);
    }
}
