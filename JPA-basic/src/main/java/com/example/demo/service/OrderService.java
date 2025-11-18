package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.domain.Item.Item;
import com.example.demo.domain.repository.ItemRepository;
import com.example.demo.domain.repository.MemberRepository;
import com.example.demo.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 1. 비즈니스 로직을 처리하는 서비스 계층임을 명시
@Transactional(readOnly = true) // 2. 기본적으로 읽기 전용 트랜잭션 적용
@RequiredArgsConstructor // 3. final 필드 생성자 자동 생성 (의존성 주입)
public class OrderService {

    // 4. 필요한 Repository들을 주입받음
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    /** 주문 생성 */
    @Transactional // 5. 쓰기 작업이므로 별도 트랜잭션 적용
    public Long order(Long memberId, Long itemId, int count) {

        // 6. 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 7. 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        // 8. 주문상품 생성 (핵심 로직 위임)
        /**
         * 핵심 로직 위임: OrderService가 직접 재고를 줄이지 않고, OrderItem 생성 메서드에 그 책임을 위임합니다.
         * createOrderItem 내부에서 item.removeStock()이 호출되어 재고가 차감됩니다.
         */
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 9. 주문 생성 (핵심 로직 위임)
        /**
         * 핵심 로직 위임: OrderService가 직접 주문 상태나 날짜를 설정하지 않고, Order 생성 메서드에 그 책임을 위임합니다.
         */
        Order order = Order.createOrder(member, delivery, orderItem);

        // 10. 주문 저장 (Cascade 설정으로 delivery, orderItem도 함께 저장됨)
        orderRepository.save(order);

        return order.getId();
    }

    /** 주문 취소 */
    @Transactional // 11. 쓰기 작업이므로 별도 트랜잭션 적용
    public void cancelOrder(Long orderId) {
        // 12. 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);

        // 13. 주문 취소 (핵심 로직 위임)
        order.cancel();
    }

    // (주석 처리된 주문 검색 기능)
}