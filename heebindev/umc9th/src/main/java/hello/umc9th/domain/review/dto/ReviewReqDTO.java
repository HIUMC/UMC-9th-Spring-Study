package hello.umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ReviewReqDTO {

    @Getter
    @Builder
    public static class CreateReviewDTO { //리뷰생성 내부 클래스 만들자~
        //private Long storeId;       // 어떤 가게에 대한 리뷰인지
        //StoreId를 PathVariable로 받을꺼면 Dto body에서 빼야함.
        private String reviewContent;
        private String reviewScore; // Score enum의 문자열 값
        private Long memberId;      // 로그인 기능 없으므로 하드코딩용
    }
}