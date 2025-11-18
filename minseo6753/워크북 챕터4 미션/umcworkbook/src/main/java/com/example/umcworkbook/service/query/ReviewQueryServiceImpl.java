package com.example.umcworkbook.service.query;

import com.example.umcworkbook.apiPayload.code.error.RestaurantErrorCode;
import com.example.umcworkbook.apiPayload.exception.RestaurantException;
import com.example.umcworkbook.converter.ReviewConverter;
import com.example.umcworkbook.dto.res.ReviewResDto;
import com.example.umcworkbook.dto.res.ReviewResDto.MyReviewDto;
import com.example.umcworkbook.entity.QReview;
import com.example.umcworkbook.entity.Restaurant;
import com.example.umcworkbook.entity.Review;
import com.example.umcworkbook.repository.RestaurantRepository;
import com.example.umcworkbook.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<MyReviewDto> searchReview(String query, String type){

        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();

        if(type.equals("restaurant")){
            builder.and(review.restaurant.id.eq(Long.parseLong(query)));
        }
        if(type.equals("star")){
            builder.and(review.star.intValue().eq(Integer.parseInt(query)));
        }

        List<MyReviewDto> reviewResDtos =reviewRepository.searchReview(builder);

        return reviewResDtos;
    }

    @Override
    public ReviewResDto.PreviewListDto findReview(
            String restaurantName, Integer page
    ){
        Restaurant restaurant=restaurantRepository.findByName(restaurantName)
                .orElseThrow(()->new RestaurantException(RestaurantErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Review> result=reviewRepository.findAllByRestaurant(restaurant, pageRequest);

        return ReviewConverter.toPreviewListDto(result);
    }
}
