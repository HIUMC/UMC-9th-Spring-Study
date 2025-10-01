package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);//member만들고
        memberService.join(member);//그 member를 회원가입시키기.

        Order order = orderService.createOrder(memberId,"itemA",10000);
        //order생성하기

        System.out.println("order = " + order);//인자 order는 order.toString()으로 호출
        System.out.println("order = " + order.calculatePrice());
    }
}
