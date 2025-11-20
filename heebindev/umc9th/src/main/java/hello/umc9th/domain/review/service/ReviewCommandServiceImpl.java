package hello.umc9th.domain.review.service;

import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.member.exception.MemberException;
import hello.umc9th.domain.member.exception.code.MemberErrorCode;
import hello.umc9th.domain.member.repository.MemberRepository;
import hello.umc9th.domain.review.converter.ReviewConverter;
import hello.umc9th.domain.review.dto.ReviewReqDTO;
import hello.umc9th.domain.review.dto.ReviewResDTO;
import hello.umc9th.domain.review.entity.Review;
import hello.umc9th.domain.review.exception.ReviewException;
import hello.umc9th.domain.review.exception.code.ReviewErrorCode;
import hello.umc9th.domain.review.repository.ReviewRepository;
import hello.umc9th.domain.store.entity.Store;
import hello.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    //리뷰 생성하기. jpa사용 , 에러도 새로 이넘에 만들었음..
    @Override
    public ReviewResDTO.ReviewInfo createReview(ReviewReqDTO.CreateReviewDTO dto) {

        // 로그인 기능이 없으므로 임시로 1번 유저 고정
        final Long TEMP_MEMBER_ID = 1L;

        Member member = memberRepository.findById(TEMP_MEMBER_ID)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));


        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.STORE_NOT_FOUND));

//        Member member = memberRepository.findById(dto.getMemberId())
//                .orElseThrow(() -> new ReviewException(ReviewErrorCode.MEMBER_NOT_FOUND));
//일단 하드코딩으로 멤버넣어놯으므로 주석처리...
        Review review = ReviewConverter.toReview(dto, store, member);

        Review saved = reviewRepository.save(review);

        return ReviewConverter.toReviewInfo(saved);
    }
}