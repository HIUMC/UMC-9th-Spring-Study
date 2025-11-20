package hongikUMC.workbook.domain.review.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Reivew_Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_comments_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body")
    private String body;

}
