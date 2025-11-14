package hello.umc9th.domain.review.controller;

import hello.umc9th.domain.review.dto.ReviewResDTO;
import hello.umc9th.domain.review.entity.Review;
import hello.umc9th.domain.review.service.ReviewQueryService;
import hello.umc9th.global.apiPayload.ApiResponse;
import hello.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewQueryController {

    private final ReviewQueryService reviewQueryService;

    //검색 요청
//    @GetMapping("/reviews/search")
//    public List<Review> search(@RequestParam String query, @RequestParam String type){
//        //서비스에게 요청
//        List<Review> result = reviewQueryService.searchReview(query, type);
//        return result;
//    }
    //// 리뷰 검색 API 응답 통일
    @GetMapping("/reviews/search")
    public ApiResponse<List<ReviewResDTO.ReviewInfo>>  searchReview(
            @RequestParam String type,
            @RequestParam String query
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                reviewQueryService.searchReview(type, query)
        );
    }

//    //내 리뷰 검색요청
//    @GetMapping("/my/reviews/search")
//    public List<Review>  getMyReviews(@RequestParam String query, @RequestParam String type){
//        //서비스에게 요청
//        List<Review> result = reviewQueryService.searchMyReview(query, type);
//        return result;
//        //리턴문을 인라인 가능할거같지만 일단 놔둠.
//    }

    //// 내 리뷰 조회 API 응답 통일
    @GetMapping("/my/reviews/search")
    public ApiResponse<List<ReviewResDTO.ReviewInfo>> getMyReviews(
            @RequestParam String type,
            @RequestParam String query
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                reviewQueryService.searchMyReview(type, query)
        );
    }
}
