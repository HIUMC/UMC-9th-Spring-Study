package com.example.demo.member.memberImplement;

import com.example.demo.member.Member;
import com.example.demo.member.memberInterface.MemberRepository;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    // HashMap 은 동시성 문제가 있음. -> 실무에서는 동시성 이슈까지 처리
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);

    }
}
