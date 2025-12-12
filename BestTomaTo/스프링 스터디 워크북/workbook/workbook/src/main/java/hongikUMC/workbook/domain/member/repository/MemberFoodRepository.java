package hongikUMC.workbook.domain.member.repository;

import hongikUMC.workbook.domain.member.entity.mapped.MemberFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFoodRepository extends JpaRepository<MemberFood, Long> {
}
