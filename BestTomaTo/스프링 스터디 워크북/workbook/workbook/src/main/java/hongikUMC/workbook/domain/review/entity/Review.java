package hongikUMC.workbook.domain.review.entity;

import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.review.enums.Rating;
import hongikUMC.workbook.domain.store.entity.Store;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Rating rating = Rating.NONE;
}
