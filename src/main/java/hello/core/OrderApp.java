package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.implement.MemberServiceImpl;
import hello.core.member.repository.MemberService;
import hello.core.order.Order;
import hello.core.order.implement.OrderServiceImpl;
import hello.core.order.repository.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId,"Donggyu", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"item1",10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
