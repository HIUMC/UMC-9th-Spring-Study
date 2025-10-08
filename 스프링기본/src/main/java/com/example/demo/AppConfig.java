package com.example.demo;
// 어떤 인터페이스에 어떤 구현 객체를 할당해줄 지를 선택해줌.

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.memberImplement.MemberServiceImpl;
import com.example.demo.member.memberImplement.MemoryMemberRepository;
import com.example.demo.member.memberInterface.MemberRepository;
import com.example.demo.member.memberInterface.MemberService;
import com.example.demo.order.orderImpl.OrderServiceImpl;
import com.example.demo.order.orderInterface.OrderService;
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
        return new RateDiscountPolicy();
    }
}
