package project.soomgo.entity.token;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "refresh_token")
public class RefreshToken {

    // Member Id 값이 들어감
    @Id
    @Column(name = "rt_key")
    private String key;

    // Refresh Token 값이 들어감
    private String value;

    public static RefreshToken of(String key, String value) {
        RefreshToken instance = new RefreshToken();

        instance.key = key;
        instance.value = value;

        return instance;
    }
}
