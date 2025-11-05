package com.example.umcworkbook.service;

import com.example.umcworkbook.dto.ReviewDto;
import com.example.umcworkbook.entity.QReview;
import com.example.umcworkbook.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ReviewQueryService {

    private ReviewRepository reviewRepository;

    public List<ReviewDto> searchReview(String query, String type){

        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();

        if(type.equals("restaurant")){
            builder.and(review.restaurant.id.eq(Long.parseLong(query)));
        }
        if(type.equals("star")){
            builder.and(review.star.intValue().eq(Integer.parseInt(query)));
        }

        List<ReviewDto> reviewDtos=reviewRepository.searchReview(builder);

        return reviewDtos;
    }
}
