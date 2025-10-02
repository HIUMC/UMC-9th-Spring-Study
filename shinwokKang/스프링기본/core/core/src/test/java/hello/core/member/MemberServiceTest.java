package hello.core.member;

import hello.core.Appconfig;
import hello.core.member.memberInterface.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        Appconfig appConfig = new Appconfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given
        Member Wook = new Member(1L, "Wook", Grade.VIP);

        //when
        memberService.join(Wook);
        Member findByWook = memberService.findMember(1L);

        //then
//        Assertions.assertThat(Wook);
    }
}
