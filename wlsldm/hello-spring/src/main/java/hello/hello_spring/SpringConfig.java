package hello.hello_spring;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired //생성자 하나일 때 생략 가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

  /*  @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/
    //aop bean으로 등록하거나 컴포넌트 넣어도 됨 근데 빈으로 넣는 게 더 좋음

 //   @Bean
   // public MemberRepository memberRepository() {
      //  return new MemoryMemberRepository();
      //  return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
     //   return new JpaMemberRepository(em);

  //  }
}
//둘 다 스프링빈에 등록하고 memerService에는 빈에 등록된 memberRepository가 들어감