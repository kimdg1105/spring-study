package hello.core.order.repository;

import hello.core.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
