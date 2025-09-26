package hello2.core2.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

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
