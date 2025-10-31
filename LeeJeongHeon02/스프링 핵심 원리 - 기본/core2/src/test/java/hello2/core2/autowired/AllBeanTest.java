package hello2.core2.autowired;

import hello2.core2.AutoAppConfig;
import hello2.core2.discount.DiscountPolicy;
import hello2.core2.member.Grade;
import hello2.core2.member.Member;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member member = new Member(1L, "userA", 24, Grade.VIP);
        int discountPrice = discountService.discount(member, 10000,
                "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);
    }


    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int discountPrice, String policyName) {
            DiscountPolicy discountPolicy = policyMap.get(policyName);

            System.out.println("discountPolicy = " + policyName);
            System.out.println("discountPolicy = " + discountPolicy);

            return discountPolicy.discount(member, discountPrice);
        }
    }
}
