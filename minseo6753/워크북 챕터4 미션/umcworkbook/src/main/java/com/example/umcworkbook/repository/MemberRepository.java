package com.example.umcworkbook.repository;

import com.example.umcworkbook.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findMemberById(Long id);
}
