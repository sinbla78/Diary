package com.example.diary.global.security.auth;

import com.example.diary.domain.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@RequiredArgsConstructor
public class AuthDetails implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // 계정이 갖고 있는 권한 정보 리턴
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() { // 계정이 만료되지 않았는지를 리턴, true면 만료되지 않음
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정이 잠겨있지 않았는지를 리턴, true면 잠겨있지 않음
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //계정 비밀번호가 만료되지 않았는지를 리턴
        return true;
    }

    @Override
    public boolean isEnabled() { // 사용 가능한 게정인지를 리턴
        return true;
    }

}
