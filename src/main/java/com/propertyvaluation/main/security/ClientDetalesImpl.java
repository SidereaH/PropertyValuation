package com.propertyvaluation.main.security;

import com.propertyvaluation.main.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class ClientDetalesImpl implements UserDetails {
    private Long id;
    private String username;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private String password;
//    исправить на phone

    public static ClientDetalesImpl build(Client user) {
        return new ClientDetalesImpl(
                user.getPeopleId(),
                user.getUsername(),
                user.getLastName(),
                user.getFirstName(),
                user.getMiddleName(),
                user.getBirthDate(),
                user.getPhone(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @Override
    public Collection<?extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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