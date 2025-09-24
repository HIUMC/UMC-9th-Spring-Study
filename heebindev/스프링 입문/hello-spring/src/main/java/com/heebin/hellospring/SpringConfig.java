package com.heebin.hellospring;

import com.heebin.hellospring.repository.JdbcTemplateMemberRepository;
import com.heebin.hellospring.repository.JpaMemberRepository;
import com.heebin.hellospring.repository.MemberRepository;
import com.heebin.hellospring.repository.MemoryMemberRepository;
import com.heebin.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    /*
        private DataSource dataSource;

        public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }
    */
   /* private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }
*/
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
/*
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }*/
}