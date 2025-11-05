package jpabook2.jpashop2;


import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class MemberRepositoryTest {
    
    @Autowired
    MemberRepository memberRepository;

    
    @Test
    @Transactional // Test에서 DB Rollback시킴.
    @Rollback(false)
    public void testMember() {
        //given
        Member member = new Member();
        member.setName("정헌");
        Long memberId = memberRepository.save(member);

        //when
        Member findMember = memberRepository.findById(member.getId());

        //then
        Assertions.assertThat(findMember.getId()).isSameAs(memberId);
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(findMember).isSameAs(member);
    }
    
}
