package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{ //주문 서비스 구현

    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy;
    //인터페이스에만 의존하도록 바꾸면 NullpointException 터짐 할당된 객체 없음

    @Autowired //생성자가 하나만 있다면 Autowired 없애도됨
    //lombok으로 코드 최적화 가능
   public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }//생성자 주입을 통해 문제 해결

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    /*
    지금까지 짠 코드의 문제점
     : OrderServiceImpl은 DiscountPolicy에만 의존해야하는데
       FixDiscountPolicy에도 의존하고 있음 (위 코드) - DIP 위반
       자주 변경되는 클래스에 의존하면 안됨
       정책 변경 시 RateDiscountPolicy에 의존해야 되므로
       OrderServiceImpl 자체의 코드가 바뀌게 됨 - OCP 위반
       정책이 변경된다고 주문 서비스가 바뀌면 안됨
     */
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //할인 시 먼저 회원 정보 조회
        Member member = memberRepository.findById(memberId);
        //회원 등급 확인 및 할인 가격 결정
        int discountPrice = discountPolicy.discount(member,itemPrice);

        //주문 정보 (회원id, 물건 이름, 물건 가격, 할인 가격)을 return 해줌
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
