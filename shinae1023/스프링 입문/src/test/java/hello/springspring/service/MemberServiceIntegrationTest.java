package hello.springspring.service;

import hello.springspring.domain.Member;
import hello.springspring.repository.MemberRepositiry;
import hello.springspring.repository.MemortMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@Transactional // test를 반복할 수 있게 해줌 db에 데이터 안남음
public class MemberServiceIntegrationTest {
    @Autowired  MemberService memberService;
    @Autowired MemberRepositiry memberRepository;

    @Test
    void 회원가입() {
        //given 주어졌을때
        Member member = new Member();
        member.setName("hello");

        //when 이걸 검증
        Long saveId =  memberService.join(member);

        //then 이렇게 되야함
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName())
                .isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class,
                ()->memberService.join(member2));

    }

}
