package hello2.core2.discount;

import hello2.core2.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
