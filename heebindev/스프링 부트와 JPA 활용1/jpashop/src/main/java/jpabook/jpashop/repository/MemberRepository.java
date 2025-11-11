package jpabook.jpashop.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //컴포넌트 스캔으로 자동으로 빈으로 등
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em; //스프링이 엔티티 메니저를 만들어서 주입해줌.

    public void save(Member member){ //회원 저장
        em.persist(member);
    }

    public Member findOne(Long id){ //회원 찾기
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){ //회원 목록 조회
        return em.createQuery("select m from Member m", Member.class)  //JPQL, 조회 클래스
                .getResultList(); // 멤버를 리스트로
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }

}
