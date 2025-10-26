package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AppConfig {
    //애플리케이션의 전체 동작 방식을 구성하기 위해
    //구현객체를 생성하고 연결하는 책임을 가지는 별도의 설정 클래스

    //@bean memberService -> new MemoryMemberRepository()
    //@bean orderService -> new MemoryMemberRepository() 각각 다른 MemoryMemberRepository 생성
    //@Bean //스프링 자체 컨테이너에 등록됨
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    } //생성자주입 객체 생성 및 참조값 전달
    //리포지토리 반환 메서드 사용하여 멤버서비스 구현 클래스에 리포지토리 전달

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    //AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성함

}
