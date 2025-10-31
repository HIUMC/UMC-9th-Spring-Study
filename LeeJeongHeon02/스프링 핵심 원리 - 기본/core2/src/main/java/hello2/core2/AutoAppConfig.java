package hello2.core2;


import hello2.core2.member.MemberRepository;
import hello2.core2.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =
        Configuration.class))
public class AutoAppConfig {

//    @Bean
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
