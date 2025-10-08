package com.example.demo.member.memberInterface;

import com.example.demo.member.Member;

// 인터페이스.
public interface MemberRepository {
    // 회원을 저장하는 인터페이스
    void save(Member member);
    // 회원의 ID로 찾는 기능
    Member findById(Long memberId);
}
