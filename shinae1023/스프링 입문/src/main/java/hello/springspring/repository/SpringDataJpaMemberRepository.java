package hello.springspring.repository;

import hello.springspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepositiry {

    @Override
    Optional<Member> findByName(String name);
}
