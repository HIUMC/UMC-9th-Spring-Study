package hello.core.singletontest;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl  memberService = ac.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository",MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberService -> memberRepository = "+memberRepository1);
        System.out.println("orderService -> memberRepository2 = "+memberRepository2);
        System.out.println("memberRepository = "+memberRepository);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = "+bean.getClass());
        //출력 결과 bean = class hello.core.AppConfig$$SpringCGLIB$$0
        /*
        순수한 클래스라면 class hello.core.AppConfig라고 출력되어야 한다
        하지만 예상과 다르게 뒤에 CGLIB가 붙으며 상당히 복잡해진 것을 볼 수 있다.
        이것은 내가 만든 클래스가 아니라 CGLIB라는 바이트코드 조작 라이브러리를 사용하여
        내가 만든 AppConfig 클래스를  상속받은 임의의 다른 클래스를 만들고 이를 스프링 빈에 등록
         */
    }
}
