package jpabook2.jpashop2.service;


import jpabook2.jpashop2.domain.Member;
import jpabook2.jpashop2.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    public void 회원가입_테스트() throws Exception {

        Member member = new Member();
        member.setName("나다");

        Long memberId = memberService.join(member);

        assertEquals(member, memberRepository.findOne(memberId));

    }

    @Test
    public void 중복_회원_예외() throws Exception {
        Member member1 = new Member();
        member1.setName("홍대");
        Member member2 = new Member();
        member2.setName("홍대");

        Long memberId1 = memberService.join(member1);

        // IllegalStateException에러가 터지지 않으면 테스트 실패
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }

}
