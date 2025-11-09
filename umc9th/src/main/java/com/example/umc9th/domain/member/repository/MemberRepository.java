package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * 이름으로 회원을 찾는 쿼리 메서드
     * Spring Data JPA가 메서드 이름을 분석하여 "SELECT m FROM Member m WHERE m.name = :name" 쿼리를 자동으로 생성합니다.
     * @param name 회원 이름
     * @return Optional<Member>
     */
    Optional<Member> findByName(String name);
}
