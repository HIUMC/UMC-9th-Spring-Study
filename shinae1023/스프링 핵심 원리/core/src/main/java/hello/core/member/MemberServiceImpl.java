package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService { //회원에게 제공하는 서비스를 구현
   private final MemberRepository memberRepository;
   //이제 MemberServiceImpl은 인터페이스에만 의존
   //구현 객체를 직접 선택하지 않고 AppConfig를 통해 제공 받을것임

    @Autowired //자동 의존 관계 주입
   public MemberServiceImpl(MemberRepository memberRepository){
       this.memberRepository = memberRepository;
   }//생성자를 통해 회원이 들어있는 객체를 제공 받아 리포지토리에 저장
    //멤버리포지토리 의존할 필요 없음, 회원 정보 알지 못함
    //이 클래스의 생성자를 통해서 어떤 구현 객체를 주입할지는 외부(AppConfig)에서 결정
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
       return memberRepository;
    }
}
