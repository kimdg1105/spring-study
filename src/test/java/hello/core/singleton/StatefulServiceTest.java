package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);


        // ThreadA: A사용자가 20000원 주문
        int userAPrice = statefulService1.order("DongGyu",20000);
        // ThreadB: B사용자가 1400원 주문
        int userBPrice = statefulService2.order("DongGyu",1400);


        // ThreadA: 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("Aprice = " + userAPrice);
        // ThreadB: 주문 금액 조회
        System.out.println("Bprice = " + userBPrice);

        // 중간에 B의 주문 개입으로 싱글톤 객체 인스턴스의 필드가 변경되었다! (같은 인스턴스를 쓰기에 발생하는 문제)

        Assertions.assertThat(userAPrice).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }
}