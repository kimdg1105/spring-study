package hello.core.order.implement;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.implement.MemoryMemberRepository;
import hello.core.order.Order;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        final MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

        memoryMemberRepository.save(new Member(1L, "Donggyu", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new RateDiscountPolicy());
        Order order = orderService.createOrder(1L, "Donggyu", 1000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(100);
    }

}