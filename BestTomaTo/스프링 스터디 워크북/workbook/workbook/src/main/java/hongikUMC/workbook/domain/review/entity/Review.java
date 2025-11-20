package hongikUMC.workbook.domain.review.entity;

import hongikUMC.workbook.domain.review.enums.Rating;
import hongikUMC.workbook.global.enums.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@Builder
@Table
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_id;

    @Column(name = "store_id")
    private Long store_id;

    @Column(name = "member_id")
    private Long member_id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Rating rating = Rating.NONE;
}
