package hongikUMC.workbook.domain.review.service;

import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.member.exception.MemberException;
import hongikUMC.workbook.domain.member.exception.code.MemberErrorCode;
import hongikUMC.workbook.domain.member.repository.MemberRepository;
import hongikUMC.workbook.domain.review.converter.ReviewConverter;
import hongikUMC.workbook.domain.review.dto.req.ReviewReqDTO;
import hongikUMC.workbook.domain.review.dto.res.ReviewResDTO;
import hongikUMC.workbook.domain.review.entity.Review;
import hongikUMC.workbook.domain.review.enums.Rating;
import hongikUMC.workbook.domain.review.repository.ReviewRepository;
import hongikUMC.workbook.domain.store.entity.Store;
import hongikUMC.workbook.domain.store.exception.StoreException;
import hongikUMC.workbook.domain.store.exception.code.StoreErrorCode;
import hongikUMC.workbook.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    public ReviewResDTO.saveReviewDTO saveReview(
            ReviewReqDTO.saveReviewDTO reviewDTO
    ){
        // 리뷰 엔티티 생성
        Review review = ReviewConverter.toReview(reviewDTO);

        // 가게 찾기
        Store store = storeRepository.findById(reviewDTO.store_id())
                .orElseThrow(() -> new StoreException(StoreErrorCode.BAD_REQUEST));

        review.setStore(store);

        // 작성자(멤버) 찾기
        Member member = memberRepository.findById(reviewDTO.member_id())
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        review.setMember(member);

        // rating 처리
        Rating rate = Rating.NONE;
        rate = switch (reviewDTO.rate().intValue()) {
            case 1 -> Rating.ONE;
            case 2 -> Rating.TWO;
            case 3 -> Rating.THREE;
            case 4 -> Rating.FOUR;
            case 5 -> Rating.FIVE;
            default -> rate;
        };
        review.setRating(rate);

        // 리뷰 저장
        reviewRepository.save(review);

        // 반환
        return ReviewConverter.toReviewDTO(review);
    }
}

