package hello.umc9th.global.security;

import hello.umc9th.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final Member member;

    @Override //권한을 list 형태로 반환 (ADMIN or USER)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> member.getRole().toString());
    }

    @Override //비밀번호 반환
    public String getPassword() {
        return member.getPassword();
    }

    @Override //아이디(이메일)을 반환
    public String getUsername() {
        return member.getEmail();
    }
}
