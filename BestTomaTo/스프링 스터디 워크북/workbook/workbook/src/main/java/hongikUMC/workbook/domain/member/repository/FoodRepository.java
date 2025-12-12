package hongikUMC.workbook.domain.member.repository;

import hongikUMC.workbook.domain.member.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
