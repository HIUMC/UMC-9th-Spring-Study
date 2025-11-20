package hello.umc9th.domain.review.controller;

import hello.umc9th.domain.review.dto.ReviewReqDTO;
import hello.umc9th.domain.review.dto.ReviewResDTO;
import hello.umc9th.domain.review.service.ReviewCommandService;
import hello.umc9th.global.apiPayload.ApiResponse;
import hello.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewCommandController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/reviews")
    public ApiResponse<ReviewResDTO.ReviewInfo> createReview(@RequestBody ReviewReqDTO.CreateReviewDTO dto) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                reviewCommandService.createReview(dto)
        );
    }
}
