package UMC.week4.controller;

import UMC.week4.domain.Review;
import UMC.week4.dto.ReviewPageDto;
import UMC.week4.dto.ReviewResponseDto;
import UMC.week4.global.apiPayload.ApiResponse;
import UMC.week4.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/my")
    // 반환 타입을 Page<Review>에서 ApiResponse<ReviewPageDto>로 변경
    public UMC.week4.global.apiPayload.ApiResponse<ReviewPageDto> getMyReviews(
            @RequestParam("memberId") Long memberId,

            @RequestParam(name = "storeName", required = false) String storeName,
            @RequestParam(name = "starRating", required = false) Integer starRating,

            @PageableDefault(size = 10) Pageable pageable
    ) {
        // 1. Service 호출 (반환값: Page<Review>)
        Page<Review> reviewPage = reviewService.getMyReviews(memberId, storeName, starRating, pageable);

        // 2. Page<Review> -> Page<ReviewResponseDto> 변환
        Page<ReviewResponseDto> reviewDtoPage = reviewPage.map(ReviewResponseDto::fromEntity);

        // 3. Page<ReviewResponseDto> -> ReviewPageDto 변환
        ReviewPageDto reviewPageDto = ReviewPageDto.from(reviewDtoPage);

        return UMC.week4.global.apiPayload.ApiResponse.onSuccess("조회 성공",reviewPageDto);
    }

}