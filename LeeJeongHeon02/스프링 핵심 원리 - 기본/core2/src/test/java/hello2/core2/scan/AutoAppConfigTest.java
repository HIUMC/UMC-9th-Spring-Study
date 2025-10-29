package hello2.core2.scan;

import hello2.core2.AutoAppConfig;
import hello2.core2.member.MemberRepository;
import hello2.core2.member.MemberService;
import hello2.core2.member.MemberServiceImpl;
import hello2.core2.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService bean = ac.getBean(MemberService.class);
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);

        OrderServiceImpl bean2 = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean2.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }
}
