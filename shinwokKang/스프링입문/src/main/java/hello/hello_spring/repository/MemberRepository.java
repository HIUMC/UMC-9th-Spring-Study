package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

// repository : 회원 관련 정보 저장
public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // 찾기
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 리스트 반환 받기
}
