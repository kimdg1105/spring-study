package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.implement.MemberServiceImpl;
import hello.core.member.repository.MemberService;
import hello.core.order.implement.OrderServiceImpl;
import hello.core.order.repository.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrderTest(){
        Long memberId = 1L;
        Member member = new Member(memberId,"Donggyu", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"item2",10000);
        Assertions.assertThat(order.calculatePrice()).isEqualTo(order.getItemPrice()- order.getDiscountPrice());
    }
}
