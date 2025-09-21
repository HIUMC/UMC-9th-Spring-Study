package hello.springspring.repository;

import hello.springspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositiry {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 모든 회원 반환

}
