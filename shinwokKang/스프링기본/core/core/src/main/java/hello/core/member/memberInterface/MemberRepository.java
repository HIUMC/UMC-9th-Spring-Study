package hello.core.member.memberInterface;

import hello.core.member.Member;

// 인터페이스.
public interface MemberRepository {
    // 회원을 저장하는 인터페이스
    void save(Member member);
    // 회원의 ID로 찾는 기능
    Member findById(Long memberId);
}
