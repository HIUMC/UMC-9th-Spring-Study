package hello.umc9th.domain.member.service;

import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    // ✅ 마이페이지 조회 기능
    public Member getMyPage(Long memberId) {
        // 존재하지 않는 회원이면 예외 발생
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}