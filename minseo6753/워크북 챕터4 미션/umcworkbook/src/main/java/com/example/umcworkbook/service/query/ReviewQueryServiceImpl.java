package com.example.umcworkbook.service.query;

import com.example.umcworkbook.dto.res.ReviewResDto;
import com.example.umcworkbook.entity.QReview;
import com.example.umcworkbook.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewResDto.SearchDto> searchReview(String query, String type){

        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();

        if(type.equals("restaurant")){
            builder.and(review.restaurant.id.eq(Long.parseLong(query)));
        }
        if(type.equals("star")){
            builder.and(review.star.intValue().eq(Integer.parseInt(query)));
        }

        List<ReviewResDto.SearchDto> reviewResDtos =reviewRepository.searchReview(builder);

        return reviewResDtos;
    }
}
