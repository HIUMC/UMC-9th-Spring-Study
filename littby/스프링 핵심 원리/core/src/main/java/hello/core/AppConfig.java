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

@Configuration //설정, 구성정보
public class AppConfig {

    // bean 멤버서비스 -> new 메모리멤버리퍼지토리 ()
    // bean 오버서비스 -> new 멤버리포지토리() -> new 메모리멤버리퍼지토리()
    // 두개의 각각 다른 객체 .. -> 싱글톤깨짐?

    @Bean // 각 메서드에 @Bean 붙이기 -> 그럼 스프링 컨테이너에 등록됨
    public MemberService memberService() {//memberService 이걸 스프링 빈의 이름으로 사용!
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());

    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();

    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }


    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy(); //배우교체라고 생각!
    }
}
