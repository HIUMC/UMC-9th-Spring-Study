package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
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
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
