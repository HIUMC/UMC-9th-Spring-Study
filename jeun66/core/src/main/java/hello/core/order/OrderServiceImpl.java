package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Autowired
public OrderServiceImpl(MemberRepository memberRepository,
                        @MainDiscountPolicy DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
}