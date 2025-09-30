package hello2.core2.discount;

import hello2.core2.member.Grade;
import hello2.core2.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인적용")
    void vipDiscount() {
        Member member = new Member(1L, "VIPmember", 1, Grade.VIP);
        int discount = rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("나머지는 할인X")
    void elseDiscount() {
        Member member = new Member(1L, "VIPmember", 1, Grade.GOLD);
        int discount = rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }
}