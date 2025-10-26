package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //@기반 Config 해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //memberService라는 객체를 찾을 것임, 타입은 MemberService
        
        Member member1 = new Member(1L,"a", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member1.getName());
        System.out.println("findMember = "+ findMember.getName());

    }
}
