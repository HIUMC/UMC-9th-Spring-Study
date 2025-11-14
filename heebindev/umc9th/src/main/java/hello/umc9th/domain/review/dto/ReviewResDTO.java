package hello.umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

public class ReviewResDTO {
    @Getter
    @Builder
    public static class ReviewInfo {
    private Long id;
    private String reviewContent;
    private String reviewScore;
    private String storeName;
    private String location;
    private String memberName;
    }
}
