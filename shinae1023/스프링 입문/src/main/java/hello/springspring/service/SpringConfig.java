package hello.springspring.service;

import hello.springspring.aop.TimeTraceApp;
import hello.springspring.repository.JdbcMemberRepositiory;
import hello.springspring.repository.JpaRepository;
import hello.springspring.repository.MemberRepositiry;
import hello.springspring.repository.MemortMemberRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepositiry memberRepositiry;

    @Autowired
    public SpringConfig(MemberRepositiry memberRepositiry) {
        this.memberRepositiry = memberRepositiry;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepositiry);
    }

    @Bean
    public TimeTraceApp timeTraceAop(){
        return new TimeTraceApp();
    }

 //   @Bean
   // public MemberRepositiry memberRepositiry(){

       // return new MemortMemberRepository();
       // return new JdbcMemberRepositiory(dataSource);
     //   return new JpaRepository(em);
    //}
}
