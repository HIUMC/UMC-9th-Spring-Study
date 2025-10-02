package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {
    MemberService memberService = new MemberService();

    @Test
    void join() {
        // given
        Member member1 = new Member();
        member1.setName("Wook");

        // when
        Long saveId1 = memberService.join(member1);

        // then
//        Optional<Member> one = memberService.findOne(saveId1);
        Member findMember = memberService.findOne(saveId1).get();
    }

    @Test
    void 중복_회원_일때(){
        //given
        Member member2 = new Member();
        member2.setName("Kang");

        Member member3 = new Member();
        member3.setName("Kang");

        //when
        memberService.join(member2);
    IllegalStateException e =    assertThrows(IllegalStateException.class, ()->memberService.join(member3));


//        try{
//            memberService.join(member3);
//            fail("예외가 발생해야 하는데 .. ");
//        }catch (IllegalStateException e){
//
//        }


        //
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}