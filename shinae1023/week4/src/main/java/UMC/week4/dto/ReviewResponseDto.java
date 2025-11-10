package UMC.week4.dto;

import UMC.week4.domain.Review;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewResponseDto {

    private Long reviewId;
    private String memberName; // Member 엔티티 대신 이름만
    private String storeName;  // Store 엔티티 대신 이름만
    private String content;
    private Integer starRating;
    private LocalDateTime createdAt; // BaseEntity가 있다고 가정

    // Review 엔티티를 DTO로 변환하는 정적 팩토리 메서드
    public static ReviewResponseDto fromEntity(Review review) {
        // 실제 Member, Store의 필드명에 맞게 수정 필요
        // (e.g., review.getMember().getNickname())
        String memberName = review.getMember() != null ? review.getMember().getName() : "알 수 없는 사용자";
        String storeName = review.getStore() != null ? review.getStore().getTitle() : "알 수 없는 가게";


        return ReviewResponseDto.builder()
                .reviewId(review.getId())
                .memberName(memberName)
                .storeName(storeName)
                .content(review.getContent())
                .starRating(review.getStar())
                .build();
    }
}
