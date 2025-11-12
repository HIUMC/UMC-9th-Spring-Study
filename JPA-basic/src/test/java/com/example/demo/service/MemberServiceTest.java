package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    void 회원가입_성공() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        memberService.join(member); // join의 반환값은 더 이상 중요하지 않습니다.

        //then
        em.flush();

        Member findMember = memberRepository.findOne(member.getId());

        assertNotNull(member.getId()); // id가 생성되었는지 확인
        assertEquals(member, findMember); // 객체가 동일한지 확인
    }

    @Test
    void 중복_회원_예외() throws Exception {
        //given: 동일한 이름의 회원이 주어졌을 때
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when: 첫 번째 회원을 가입시키고, 두 번째 회원도 가입시키려 하면
        memberService.join(member1);

        //then: IllegalStateException 예외가 발생해야 한다
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다.", e.getMessage());
    }
}
