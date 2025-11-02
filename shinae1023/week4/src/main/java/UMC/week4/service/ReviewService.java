package UMC.week4.service;

import UMC.week4.domain.Member;
import UMC.week4.domain.Review;
import UMC.week4.domain.Store;
import UMC.week4.repository.MemberRepository;
import UMC.week4.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public Long createReview(){
        Member member = memberRepository.findById(101L).orElseThrow();
        Store store = storeRepository.findById(202L).orElseThrow();

        Review newReview = Review.builder()
                .member(member)
                .store(store)
                .content("정말 맛있어서 또 오고 싶네요")
                .star(5)
                .build();
        storeRepository.save(store);

        return newReview.getId();
    }
}
