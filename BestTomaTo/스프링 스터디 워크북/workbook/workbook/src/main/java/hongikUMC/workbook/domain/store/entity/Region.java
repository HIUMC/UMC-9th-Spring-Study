package hongikUMC.workbook.domain.store.entity;

import hongikUMC.workbook.domain.mission.entity.Mission;
import hongikUMC.workbook.global.enums.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long region_id;

    @Column(name = "area")
    private String area;

    @OneToMany(mappedBy = "store_id")
    private List<Store> storeList;
}
