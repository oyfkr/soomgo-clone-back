package project.soomgo.entity.user;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.soomgo.entity.user.dto.UserCreateRequest;

@Entity
@Getter
public class Users {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private boolean isMaster;

    @OneToMany(mappedBy = "user")
    private Set<UserChatRoomMapping> userChatRoomMappings;

    public static Users of(UserCreateRequest userCreateDTO, PasswordEncoder passwordEncoder) {
        Users instance = new Users();

        instance.name = userCreateDTO.getName();
        instance.email = userCreateDTO.getEmail();
        instance.password = passwordEncoder.encode(userCreateDTO.getPassword());
        instance.isMaster = userCreateDTO.isMaster();

        return instance;
    }
}
