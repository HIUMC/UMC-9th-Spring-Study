package umc9th.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc9th.domain.review.dto.ReviewRequestDTO;
import umc9th.domain.review.entity.Review;
import umc9th.domain.review.repository.ReviewRepository;
import umc9th.domain.store.entity.Restaurant;
import umc9th.domain.store.repository.RestaurantRepository;
import umc9th.global.apiPayload.code.GeneralErrorCode;
import umc9th.global.apiPayload.exception.GeneralException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Review createReview(ReviewRequestDTO.AddReviewDTO request, Long restaurantId) {

        User user = userRepository.findById(1L).orElseThrow(() ->
                new GeneralException(GeneralErrorCode.MEMBER_NOT_FOUND));

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() ->
                new GeneralException(GeneralErrorCode.RESTAURANT_NOT_FOUND));


        Review newReview = Review.builder()
                .context(request.getContext())
                .star(request.getStar())
                .user(user) // 하드코딩으로 찾은 유저
                .restaurant(restaurant)
                .build();


        return reviewRepository.save(newReview);
    }

    public Page<Review> getReviewListByRestaurant(Long restaurantId, int page) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.RESTAURANT_NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 10);

        return reviewRepository.findAllByRestaurant(restaurant, pageRequest);
    }
}
