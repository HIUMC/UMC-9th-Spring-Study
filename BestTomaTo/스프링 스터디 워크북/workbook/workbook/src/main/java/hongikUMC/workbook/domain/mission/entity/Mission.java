package hongikUMC.workbook.domain.mission.entity;

import hongikUMC.workbook.domain.mission.enums.Status;
import hongikUMC.workbook.domain.store.entity.Store;
import hongikUMC.workbook.global.enums.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mission_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "status")
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Status status = Status.STBY;

    @Column(name = "point", nullable = false)
    private Long point;
}
