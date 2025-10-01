package hello.core.member.memberInterface;

import hello.core.member.Member;

// 회원 관리를 위한 interface
public interface MemberService {
    // 회원 가입
    void join(Member member);
    // 회원 조회
    Member findMember(Long memberId);

}
