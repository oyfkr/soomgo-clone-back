package project.soomgo.entity.user.repository.impl;

import java.util.Optional;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import project.soomgo.entity.user.Users;
import project.soomgo.entity.user.repository.UserRepositoryCustom;

import static project.soomgo.entity.user.QUsers.users;

public class UserRepositoryCustomImpl extends QuerydslRepositorySupport implements
        UserRepositoryCustom {

    private JpaRepositoryFactory factory;

    public UserRepositoryCustomImpl() {
        super(Users.class);
    }

    public Optional<Users> findByEmail(String email) {
        return Optional.ofNullable(from(users)
                .where(users.email.eq(email)).fetchOne());
    }
}
