package com.example.umcworkbook.service.query;

import com.example.umcworkbook.dto.res.ReviewResDto;
import java.util.List;

public interface ReviewQueryService {
    List<ReviewResDto.SearchDto> searchReview(String query, String type);
}
