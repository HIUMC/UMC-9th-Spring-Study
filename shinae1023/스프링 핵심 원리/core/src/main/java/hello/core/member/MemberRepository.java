package hello.core.member;

public interface MemberRepository { //멤버 저장 및 검색

    void save(Member member);

    Member findById(Long memberId);
}
