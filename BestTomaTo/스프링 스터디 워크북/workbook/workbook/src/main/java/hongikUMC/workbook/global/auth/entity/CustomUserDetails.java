package hongikUMC.workbook.global.auth.entity;

import hongikUMC.workbook.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
// 사용자 지정 UserDetail
// AuthenticationProvider가 UserDetailService를 통해 입력값과 대조할 저장값을 찾는 과정.
// UserDetail들은 SecurityContext에 들어가게 된다.
public class CustomUserDetails implements UserDetails {

    private final Member member;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> member.getRole().toString());
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getEmail();
    }
}
