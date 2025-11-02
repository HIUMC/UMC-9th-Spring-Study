package umc9th.domain.member.repository;

public interface memberRepository extends JpaRepository<Member, Long> {

    @Query("""
        SELECT new com.example.dto.MyPageResponse(
            m.id,
            m.name,
            m.email,
            m.phoneNumber,
            m.point,
            COUNT(r.id)
        )
        FROM Member m
        LEFT JOIN Review r ON r.member.id = m.id
        WHERE m.id = :memberId
        GROUP BY m.id, m.name, m.email, m.phoneNumber, m.point
    """)
    MyPageResponse findMyPageInfo(@Param("memberId") Long memberId);
}
