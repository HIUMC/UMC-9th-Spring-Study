package jpabook.jpashop.repository;


import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
    //아래의 조건을 이용해서 동적쿼리에 사용
    private String memberName; //회원 이름
    private OrderStatus orderStatus;// 주문상태 (ORDER, CANCEL)
}
