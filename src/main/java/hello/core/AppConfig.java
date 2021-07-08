package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.implement.MemberServiceImpl;
import hello.core.member.implement.MemoryMemberRepository;
import hello.core.member.repository.MemberService;
import hello.core.order.implement.OrderServiceImpl;
import hello.core.order.repository.OrderService;

public class AppConfig {

    public MemberService memberService(){

        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
