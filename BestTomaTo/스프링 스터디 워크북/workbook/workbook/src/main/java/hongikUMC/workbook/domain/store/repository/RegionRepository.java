package hongikUMC.workbook.domain.store.repository;

import hongikUMC.workbook.domain.store.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
