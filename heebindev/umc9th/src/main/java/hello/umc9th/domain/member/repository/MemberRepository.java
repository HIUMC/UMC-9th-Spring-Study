package hello.umc9th.domain.member.repository;

import hello.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //deletedAt이 null(활성화 상태)인 멤버를 이름으로 찾기.

    //1.매서드 이름으로 쿼리 생성 -> SpringData JPA가 매서드명 기반으로 쿼리를 자동 생성
    List<Member> findByNameAndDeletedAtIsNull(String name);

    //2.JPQL을 직접 작성하기 -> 조건이 복잡해서 매서드명으로 표현하기 어려울 때 사용.
    @Query("select m from Member m where m.name = :name and m.deletedAt is null")
    List<Member> findActiveMember(@Param("name")  String name);
}
