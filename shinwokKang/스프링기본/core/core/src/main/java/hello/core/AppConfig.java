package hello.core;
// 어떤 인터페이스에 어떤 구현 객체를 할당해줄 지를 선택해줌.

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.memberImplement.MemberServiceImpl;
import hello.core.member.memberImplement.MemoryMemberRepository;
import hello.core.member.memberInterface.MemberRepository;
import hello.core.member.memberInterface.MemberService;
import hello.core.order.orderImpl.OrderServiceImpl;
import hello.core.order.orderInterface.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
