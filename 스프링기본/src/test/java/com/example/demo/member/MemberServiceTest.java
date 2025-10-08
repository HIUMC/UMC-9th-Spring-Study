package com.example.demo.member;

import com.example.demo.AppConfig;
import com.example.demo.member.memberInterface.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
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
