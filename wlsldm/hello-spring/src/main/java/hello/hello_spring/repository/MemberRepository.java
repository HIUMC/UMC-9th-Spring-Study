package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//회원 저장
    Optional<Member> findById(Long id); //아이디로 회원 찾기
    Optional<Member> findByName(String name);//이름으로 회원 찾기
    //optional -> 값을 가져올 때 null일 수 있는 데 이때 null을 처리하는 방법
    List<Member> findAll(); //모든 회원 반환
}
