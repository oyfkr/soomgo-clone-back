package project.soomgo.entity.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.soomgo.entity.user.Users;

public interface UsersRepository extends JpaRepository<Users, Long> , UserRepositoryCustom{

}
