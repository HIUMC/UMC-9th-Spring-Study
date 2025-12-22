package com.example.Chapter6.domain.security;

import com.example.Chapter6.domain.user.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final Member member;

    //권한을 리스트 형태로 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()-> member.getRole().toString());
    }

    //비밀번호 반환
    @Override
    public String getPassword() {
        return member.getPassword();
    }


    //이메일 반환
    @Override
    public String getUsername() {
        return member.getEmail();
    }
}
