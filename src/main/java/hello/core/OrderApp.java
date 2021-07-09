package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.implement.MemberServiceImpl;
import hello.core.member.repository.MemberService;
import hello.core.order.Order;
import hello.core.order.implement.OrderServiceImpl;
import hello.core.order.repository.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId,"Donggyu", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"item1",123000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
