package hello.core.order.implement;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.implement.MemoryMemberRepository;
import hello.core.member.repository.MemberRepository;
import hello.core.order.Order;
import hello.core.order.repository.OrderService;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; // 현재 구현체에 의존하고 있음을 알 수 있다.
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();// <---- 할인 정책 변경을 위해 주문서비스 구현체를 변경해야 한다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);  // 할인 정책이 바뀌어도 이 부분 변경이 필요없다.

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
