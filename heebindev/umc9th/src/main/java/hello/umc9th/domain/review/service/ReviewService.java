package hello.umc9th.domain.review.service;


import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.review.entity.Review;
import hello.umc9th.domain.review.enums.Score;
import hello.umc9th.domain.review.repository.ReviewRepository;
import hello.umc9th.domain.store.entity.Store;

public class ReviewService {
    private ReviewRepository reviewRepository;

    public Review createReview(Member member, Store store, String content, Score score) {
        Review review = Review.builder()
                .member(member)
                .restaurant(store)
                .reviewContent(content)
                .score(score)
                .build();

        return reviewRepository.save(review);
    }
}