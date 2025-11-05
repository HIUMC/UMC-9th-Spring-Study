package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberRepositoryTest {
        @Autowired MemberRepository memberRepository;

        @Test @Transactional
        @Rollback(false)
         void testMember()   {
            // given
            Member member = new Member();
            member.setUsername("MemberA");

            //when
            memberRepository.save(member);
            Member findMember = memberRepository.find(member.getId());

            // then
            org.assertj.core.api.Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
            org.assertj.core.api.Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
            org.assertj.core.api.Assertions.assertThat(findMember).isEqualTo(member); //JPA 엔티티 보장

            System.out.println("findMember == member: " + (findMember == member));
        }
}