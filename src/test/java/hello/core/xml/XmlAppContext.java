package hello.core.xml;

import hello.core.member.repository.MemberService;
import hello.core.order.repository.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService",OrderService.class);

        System.out.println("orderService = " + orderService.toString());
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
