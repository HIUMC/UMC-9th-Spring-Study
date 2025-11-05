package com.example.demo.order.orderImpl;

import com.example.demo.annotation.MainDiscountPolicy;
import com.example.demo.discount.DiscountPolicy;
import com.example.demo.member.Member;
import com.example.demo.member.memberInterface.MemberRepository;
import com.example.demo.order.Order;
import com.example.demo.order.orderInterface.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

// final이 붙은 것들을 자동으로 만들어줌. (Lombok)
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //이러한 새로운 것이 들어오면 @RequiredConstructor가 굉장히 편리하다.
//    private final MemberRopository2 memberRopository2;

    //@RequiredArgsConstructor가 이 부분을 대신 만들어준다.

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
