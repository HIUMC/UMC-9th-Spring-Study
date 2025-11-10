package UMC.week4.service;

import UMC.week4.domain.Member;
import UMC.week4.domain.Review;
import UMC.week4.domain.Store;
import UMC.week4.repository.MemberRepository;
import UMC.week4.repository.ReviewRepository;
import UMC.week4.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;

    public Page<Review> getMyReviews(Long memberId, String storeName, Integer starRating, Pageable pageable) {

        // (필요시) memberId로 실제 회원이 존재하는지 확인하는 로직
        // memberRepository.findById(memberId).orElseThrow(...);

        // 리포지토리에 구현된 커스텀 메소드 호출
        return reviewRepository.findMyReviews(memberId, storeName, starRating, pageable);

    }

    public Long createReview(){
        Member member = memberRepository.findById(101L).orElseThrow();
        Store store = storeRepository.findById(202L).orElseThrow();

        Review newReview = Review.builder()
                .member(member)
                .store(store)
                .content("정말 맛있어서 또 오고 싶네요")
                .star(5)
                .build();
        reviewRepository.save(newReview);

        return newReview.getId();
    }
}
