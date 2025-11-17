package com.example.umcworkbook.controller;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.apiPayload.code.GeneralSuccessCode;
import com.example.umcworkbook.dto.req.ReviewReqDto;
import com.example.umcworkbook.dto.res.ReviewResDto;
import com.example.umcworkbook.repository.MemberRepository;
import com.example.umcworkbook.repository.RestaurantRepository;
import com.example.umcworkbook.service.command.ReviewCommandService;
import com.example.umcworkbook.service.query.ReviewQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @GetMapping("/reviews/search")
    public ApiResponse<List<ReviewResDto.SearchDto>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<ReviewResDto.SearchDto> result = reviewQueryService.searchReview(query, type);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                result
        );
    }

    @PostMapping("/users/{userId}/restaurants/{restaurantId}/reviews")
    public ApiResponse<ReviewResDto.SearchDto> createReview(
            @PathVariable Long userId,
            @PathVariable Long restaurantId,
            @RequestBody ReviewReqDto.CreateDto dto
    ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                reviewCommandService.createReview(userId,restaurantId,dto)
        );
    }
}
