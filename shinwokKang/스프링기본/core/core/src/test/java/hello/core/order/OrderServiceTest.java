package hello.core.order;

import hello.core.Appconfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.memberImplement.MemberServiceImpl;
import hello.core.member.memberInterface.MemberService;
import hello.core.order.orderImpl.OrderServiceImpl;
import hello.core.order.orderInterface.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        Appconfig appConfig = new Appconfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
