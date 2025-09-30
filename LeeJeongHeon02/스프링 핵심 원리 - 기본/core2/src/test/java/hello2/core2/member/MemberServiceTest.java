package hello2.core2.member;

import hello2.core2.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = ac.getBean(MemberService.class);

    @Test
    public void join() {
        //given
        Member member = new Member(10L, "이정헌", 24, Grade.GOLD);
        memberService.join(member);

        //when
        Member findMember = memberService.findById(member.getId());

        //then
        assertThat(member).isEqualTo(findMember);
    }
}
