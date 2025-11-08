package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given 무엇이 주어졌을 때
        ///member의 정보 주어짐(생성자를 통해 생성)
        Member member = new Member(1L,"a",Grade.VIP);

        //when 이렇게 했을 때
        memberService.join(member); //회원가입
        Member findmember = memberService.findMember(1L);
        //findMember 매서드를 통해 ID와 일치하는 멤버 찾아 findmember에 저장

        //then 이렇게
        //isEqualTo함수를 통해 member에 저장되어있는 회원과
        //findmember에 저장되어 있는 회원이 같은 지 확인
        Assertions.assertThat(member).isEqualTo(findmember);

    }
}
