package hello2.core2;

import hello2.core2.discount.DiscountPolicy;
import hello2.core2.discount.FixDiscountPolicy;
import hello2.core2.discount.RateDiscountPolicy;
import hello2.core2.member.MemberRepository;
import hello2.core2.member.MemberService;
import hello2.core2.member.MemberServiceImpl;
import hello2.core2.member.MemoryMemberRepository;
import hello2.core2.order.OrderService;
import hello2.core2.order.OrderServiceImpl;
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
//        return new RateDiscountPolicy();
        return new FixDiscountPolicy();
    }

}
