package com.example.umcworkbook.service.query;

import com.example.umcworkbook.dto.res.ReviewResDto;
import com.example.umcworkbook.dto.res.ReviewResDto.MyReviewDto;
import java.util.List;

public interface ReviewQueryService {
    List<MyReviewDto> searchReview(String query, String type);

    ReviewResDto.PreviewListDto findReview(
            String restaurantName, Integer page
    );
}
