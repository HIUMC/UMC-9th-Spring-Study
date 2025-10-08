package com.example.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

 class StatefulServiceTest {
    @Test
     void statefulServiceSingleton() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService statefulService1 = context.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = context.getBean("statefulService", StatefulService.class);
        statefulService1.order("userA", 10000);
        statefulService2.order("userB", 20000);

        System.out.println(statefulService1.getPrice());

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
