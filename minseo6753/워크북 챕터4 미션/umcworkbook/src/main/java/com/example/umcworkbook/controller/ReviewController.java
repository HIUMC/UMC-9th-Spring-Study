package com.example.umcworkbook.controller;

import com.example.umcworkbook.dto.ReviewDto;
import com.example.umcworkbook.service.ReviewQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/reviews/search")
    public List<ReviewDto> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<ReviewDto> result = reviewQueryService.searchReview(query, type);
        return result;
    }
}
