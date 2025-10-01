package com.heebin.hellospring.repository;

import com.heebin.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {


    public static Map<Long,Member> store = new HashMap<>();
    public static long sequence =0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()                     // 모든 Member 객체들
                .filter(m -> m.getName().equals(name))     // 이름이 일치하는 것만 필터링
                .findAny(); // 아무거나 하나 반환 (Optional)
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
