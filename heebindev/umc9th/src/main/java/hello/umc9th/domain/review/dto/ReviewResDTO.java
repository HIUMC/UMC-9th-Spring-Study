package hello.umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

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

    //목록 개별 요소의 DTO
    @Getter
    @Builder
    public static class ReviewPreviewDTO {
        private String ownerNickname;
        private String reviewScore;
        private String reviewContent;
        private LocalDate createdAt;
    }


    //목록의 개별 요소 DTO
    @Getter
    @Builder
    public static class ReviewPreviewListDTO {
        private List<ReviewPreviewDTO> reviewList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }


}
