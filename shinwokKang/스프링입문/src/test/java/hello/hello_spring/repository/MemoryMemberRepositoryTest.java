package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class MemoryMemberRepositoryTest {
//    MemberRepository repository = new MemoryMemberRepository();
MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // Test가 끝날 때마다 실행을 함.
    public void afterEach() {
repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
       Member result= repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

    }
}
