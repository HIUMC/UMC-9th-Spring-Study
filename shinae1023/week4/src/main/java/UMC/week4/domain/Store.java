package UMC.week4.domain;

import UMC.week4.domain.enums.Region;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 40)
    private String title;

    @Column(nullable = false,length = 40)
    private String address;

    private String storeNum;

    @Enumerated(EnumType.STRING)
    private Region region;
}
