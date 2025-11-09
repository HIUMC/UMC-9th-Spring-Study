package UMC.week4.repository;

import UMC.week4.domain.Member;
import UMC.week4.dto.MypageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT new UMC.week4.dto.MypageDto(m.nickName, m.email, m.phoneNum, m.point) FROM Member m WHERE m.id = :memberId")
    Optional<MypageDto> findMyPageInfo(@Param("memberId") Long memberId);
}
