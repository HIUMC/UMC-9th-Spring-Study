package hello2.core2;

import hello2.core2.member.*;

public class MamberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(10L, "이정헌", 24, Grade.GOLD);
        memberService.join(member);

        // 이렇게 sout 직접 찍지말고, Test코드 작성해야함
        Member byId = memberService.findById(member.getId());
        System.out.println(member.getName());
        System.out.println(byId.getName());
    }
}
