package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 수동으로 어노테이션 붙은 객체 및 클래스는 빈에서 제외 (충돌 방지)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION
        , classes = Configuration.class)
)
public class AutoAppConfig {
    // 빈으로 등록되면 소문자가 되니까 이름을 이렇게 함
    /*
    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;

    @Bean
    OrderService orderService(){
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }
    */

    // 프로젝트에서 이미 동일한 이름의 빈을 등록하는데 지금 중복 등록하려고 하고 있음.
    // 오류 해결을 위해 다음 코드를 주석처리한다.
    /*
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
