package hongikUMC.workbook.domain.review.controller;

import hongikUMC.workbook.domain.review.dto.req.ReviewReqDTO;
import hongikUMC.workbook.domain.review.dto.res.ReviewResDTO;
import hongikUMC.workbook.domain.review.exception.code.ReviewSuccessCode;
import hongikUMC.workbook.domain.review.service.ReviewCommandService;
import hongikUMC.workbook.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/add")
    public ApiResponse<ReviewResDTO.saveReviewDTO> saveReview(
            @RequestBody ReviewReqDTO.saveReviewDTO reviewDTO
    ){
        return ApiResponse.onSuccess(ReviewSuccessCode.OK, reviewCommandService.saveReview(reviewDTO));
    }
}
