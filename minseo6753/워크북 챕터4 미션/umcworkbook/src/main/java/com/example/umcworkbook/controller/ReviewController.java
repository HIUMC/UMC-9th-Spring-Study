package com.example.umcworkbook.controller;

import com.example.umcworkbook.dto.ReviewDto;
import com.example.umcworkbook.service.ReviewQueryService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

    private ReviewQueryService reviewQueryService;

    @GetMapping("/reviews/search")
    public List<ReviewDto> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<ReviewDto> result = reviewQueryService.searchReview(query, type);
        return result;
    }
}
