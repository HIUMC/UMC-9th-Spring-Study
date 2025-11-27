package hongikUMC.workbook.domain.review.controller;

import hongikUMC.workbook.global.apiPayload.ApiResponse;
import hongikUMC.workbook.domain.review.converter.ReviewConverter;
import hongikUMC.workbook.domain.review.dto.res.ReviewResDTO;
import hongikUMC.workbook.domain.review.entity.Review;
import hongikUMC.workbook.domain.review.service.ReviewQueryService;
import hongikUMC.workbook.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;


    @GetMapping("/{memberId}/review")
    @Operation(summary = "내 리뷰 조회", description = "내 리뷰 조회")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "리뷰가 존재하지 않습니다")

    })
    public ApiResponse<ReviewResDTO.ReviewListDTO> getMyReviewList(
            @RequestParam Long memberId,
            @RequestParam Integer page
    ) {
        ReviewResDTO.ReviewListDTO myReviewList = reviewQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, myReviewList);
    }
}
