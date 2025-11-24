package com.example.Chapter6.domain.review.service.query;

import com.example.Chapter6.domain.review.converter.ReviewConverter;
import com.example.Chapter6.domain.review.dto.response.ReviewResponseDTO;
import com.example.Chapter6.domain.review.entity.Review;
import com.example.Chapter6.domain.review.repository.ReviewRepository;
import com.example.Chapter6.domain.store.entity.Store;
import com.example.Chapter6.domain.store.exception.StoreException;
import com.example.Chapter6.domain.store.exception.code.StoreErrorCode;
import com.example.Chapter6.domain.store.repository.StoreRepository;
import com.example.Chapter6.domain.user.entity.Member;
import com.example.Chapter6.domain.user.exception.MemberException;
import com.example.Chapter6.domain.user.exception.code.MemberErrorCode;
import com.example.Chapter6.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public ReviewResponseDTO.ReviewPreViewListDTO findReview(
            String storeName,
            Integer page
    ){
        // - 가게를 가져온다 (가게 존재 여부 검증)
        Store store = storeRepository.findByName(storeName)
                //    - 없으면 예외 터뜨린다
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        //- 가게에 맞는 리뷰를 가져온다 (Offset 페이징)
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Review> result = reviewRepository.findAllByStore(store, pageRequest);

        //- 결과를 응답 DTO로 변환한다 (컨버터 이용)
        return ReviewConverter.toReviewPreviewListDTO(result);
    }

    @Override
    public ReviewResponseDTO.ReviewPreViewListDTO findMyReview(Long memberId, Integer page) {
        //멤버 확인
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new MemberException(MemberErrorCode.NOT_FOUND));

        //멤버에 맞는 리뷰 가져옴
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Review> result = reviewRepository.findByMember(member, pageRequest);


        return ReviewConverter.toReviewPreviewListDTO(result);
    }


}
