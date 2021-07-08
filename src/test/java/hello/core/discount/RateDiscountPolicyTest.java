package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("10% 할인 성공 테스트")
    void vip_correct(){
        //given
        Member member = new Member(1L,"Donggyu", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member,12340);

        //then
        org.assertj.core.api.Assertions.assertThat(discount).isEqualTo(1234);
    }

    @Test
    @DisplayName("10% 할인 실패 테스트")
    void vip_wrong(){
        //given
        Member member = new Member(1L,"Donggyu", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member,12340);

        //then
        org.assertj.core.api.Assertions.assertThat(discount).isNotEqualTo(1234);
    }


}