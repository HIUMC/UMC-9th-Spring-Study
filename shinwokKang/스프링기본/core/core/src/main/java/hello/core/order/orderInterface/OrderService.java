package hello.core.order.orderInterface;

import hello.core.order.Order;

public interface OrderService {
    /**
     * 클라이언트가 @param을 반환
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return 최종 Order 결과
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
