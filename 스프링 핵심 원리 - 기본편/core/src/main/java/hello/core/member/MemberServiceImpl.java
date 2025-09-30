package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // NullPointerException - 구현 객체 선택해주기
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
