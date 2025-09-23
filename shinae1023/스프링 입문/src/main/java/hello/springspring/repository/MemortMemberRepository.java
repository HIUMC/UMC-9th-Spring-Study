package hello.springspring.repository;

import hello.springspring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemortMemberRepository implements MemberRepositiry{
//맥에서 옵션 = alt
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L; //키값 생성해줌
    @Override
    public Member save(Member member) {

        member.setId(++sequence); //시퀀스값 증가
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // null이어도 반환하기 위해 ofnullable  사용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //루프를 돌음
                .filter(member->member.getName().equals(name))
                // 멤버에서 멤버.getname이 매개변수로 넘ㅇㅓ온 name과 같은지 확인
                .findAny(); // 하나라도 찾으면 반환 없으면 null 반환
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());
    }

    public void clearStore(){  //공용데이터 삭제
        store.clear();
}
 }