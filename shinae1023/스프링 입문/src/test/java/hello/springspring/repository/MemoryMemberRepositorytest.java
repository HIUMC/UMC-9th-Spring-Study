package hello.springspring.repository;

import hello.springspring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositorytest {
    MemortMemberRepository repositiry = new MemortMemberRepository();

    @AfterEach //test 끝날때마다 지워주는 코드
    public void afterEach(){
        repositiry.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repositiry.save(member);

        Member result = repositiry.findById(member.getId()).get();
        //repositiry.findById(member.getId());

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositiry.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositiry.save(member2);

        Member result =  repositiry.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositiry.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositiry.save(member2);

        List<Member> result = repositiry.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
