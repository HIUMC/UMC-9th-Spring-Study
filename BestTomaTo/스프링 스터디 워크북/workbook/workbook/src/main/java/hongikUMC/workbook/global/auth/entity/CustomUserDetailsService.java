package hongikUMC.workbook.global.auth.entity;

import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.member.exception.MemberException;
import hongikUMC.workbook.domain.member.exception.code.MemberErrorCode;
import hongikUMC.workbook.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    // 실제 애플리케이션에서는 로그인 횟수 제한, 이중 검증 코드를 두는 것이 좋다.
    @Override
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException {

        // 검증할 Member 조회
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // CustomUserDetails 반환
        return new CustomUserDetails(member);
    }
}

