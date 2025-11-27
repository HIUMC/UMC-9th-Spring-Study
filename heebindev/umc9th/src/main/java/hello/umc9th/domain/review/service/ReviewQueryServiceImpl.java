package hello.umc9th.domain.review.service;


import com.querydsl.core.BooleanBuilder;
import hello.umc9th.domain.review.converter.ReviewConverter;
import hello.umc9th.domain.review.dto.ReviewResDTO;
import hello.umc9th.domain.review.entity.QReview;
import hello.umc9th.domain.review.entity.Review;
import hello.umc9th.domain.review.enums.Score;
import hello.umc9th.domain.review.exception.ReviewException;
import hello.umc9th.domain.review.exception.code.ReviewErrorCode;
import hello.umc9th.domain.review.repository.ReviewRepository;
import hello.umc9th.domain.store.entity.Store;
import hello.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    public List<ReviewResDTO.ReviewInfo> searchReview(String type, String query) {
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

        // 타입 검증
        if (!type.equals("location") && !type.equals("score") && !type.equals("both")) {
            throw new ReviewException(ReviewErrorCode.INVALID_FILTER);
        }

        // location 검색
        if (type.equals("location")) {
            builder.and(review.store.location.storeLocation.stringValue().contains(query));
        }

        // score 검색
        if (type.equals("score")) {
            try {
                builder.and(review.reviewScore.eq(Score.valueOf(query)));
            } catch (IllegalArgumentException e) {
                throw new ReviewException(ReviewErrorCode.INVALID_SCORE);
            }
        }

        // both 검색
        if (type.equals("both")) {
            String[] parts = query.split("&");
            if (parts.length != 2) throw new ReviewException(ReviewErrorCode.INVALID_FILTER);

            builder.and(review.store.location.storeLocation.stringValue().contains(parts[0]));

            try {
                builder.and(review.reviewScore.eq(Score.valueOf(parts[1])));
            } catch (IllegalArgumentException e) {
                throw new ReviewException(ReviewErrorCode.INVALID_SCORE);
            }
        }

        // 검색 실행
        List<Review> reviews = reviewRepository.searchReview(builder);

        return reviews.stream()
                .map(ReviewConverter::toReviewInfo)
                .toList();
    }
    /// 내 리뷰 api
    public List<ReviewResDTO.ReviewInfo> searchMyReview(String type, String query) {
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

        // type 검증
        if (!type.equals("store") && !type.equals("score")) {
            throw new ReviewException(ReviewErrorCode.INVALID_FILTER);
        }

        // 💡 store 필터링
        if (type.equals("store")) {
            try {
                long storeId = Long.parseLong(query);
                builder.and(review.store.id.eq(storeId));
            } catch (NumberFormatException e) {
                throw new ReviewException(ReviewErrorCode.INVALID_FILTER);
            }
        }

        // 💡 score 필터링
        if (type.equals("score")) {
            try {
                builder.and(review.reviewScore.eq(Score.valueOf(query)));
            } catch (IllegalArgumentException e) {
                throw new ReviewException(ReviewErrorCode.INVALID_SCORE);
            }
        }

        List<Review> reviewList = reviewRepository.findMyReview(builder);

        return reviewList.stream()
                .map(ReviewConverter::toReviewInfo)
                .toList();
    }

    //가게의 리뷰들 조회
    @Override
    public ReviewResDTO.ReviewPreviewListDTO getReviewList(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.STORE_NOT_FOUND));
        //가게가 없으면 예외 발생

        //가게에 맞는 리뷰를 가져옴. (offset 페이징)
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Review> result = reviewRepository.findAllByStore(store, pageRequest);

        //- 결과를 응답 DTO로 변환한다 (컨버터 이용)
        return ReviewConverter.toReviewPreviewListDTO(result);
    }

    //내가 작성한 리뷰 목록 조회
    @Override
    public ReviewResDTO.ReviewPreviewListDTO getMyReviewList(Integer page){

        //아직 로그인 기능 없으니깐 회원 1번으로 고정할게요
        final Long TEMP_MEMBER_ID = 1L;

        // 프론트는 1부터, JPA는 0부터 시작하므로 -1
        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        // 해당 회원이 작성한 리뷰들을 페이징 조회
        Page<Review> result =
                reviewRepository.findAllByMemberId(TEMP_MEMBER_ID, pageRequest);

        // 엔티티 Page → DTO로 변환 (Stream 사용)
        return ReviewConverter.toReviewPreviewListDTO(result);
    }

}