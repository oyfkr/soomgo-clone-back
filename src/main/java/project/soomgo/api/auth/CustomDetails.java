package project.soomgo.api.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.soomgo.entity.user.Users;

import java.util.*;

@Getter
@NoArgsConstructor
public class CustomDetails implements UserDetails {

    private Users users;

    public static CustomDetails of(Users users) {
        CustomDetails instance = new CustomDetails();
        instance.users = users;

        return instance;
    }

//    public static CustomDetails ofTest(Long id, String name,) {
//
//    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return "ROLE_USER";
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return this.users.getPassword();
    }

    @Override
    public String getUsername() {
        return this.users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
