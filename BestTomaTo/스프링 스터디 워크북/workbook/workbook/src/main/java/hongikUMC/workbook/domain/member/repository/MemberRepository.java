package hongikUMC.workbook.domain.member.repository;

import hongikUMC.workbook.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String username);
    // Optional<Member> findByEmail(String email);
}
