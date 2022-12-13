package project.soomgo.entity.user.repository;

import java.util.Optional;
import project.soomgo.entity.user.Users;

public interface UserRepositoryCustom {

    Optional<Users> findByEmail(String email);
}
