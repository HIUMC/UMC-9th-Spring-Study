package hongikUMC.workbook.domain.review.service;

import com.querydsl.core.BooleanBuilder;
import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.member.repository.MemberRepository;
import hongikUMC.workbook.domain.review.converter.ReviewConverter;
import hongikUMC.workbook.domain.review.dto.res.ReviewResDTO;
import hongikUMC.workbook.domain.review.entity.QReview;
import hongikUMC.workbook.domain.review.entity.Review;
import hongikUMC.workbook.domain.review.repository.ReviewRepository;
import hongikUMC.workbook.global.apiPayload.code.GeneralErrorCode;
import hongikUMC.workbook.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 조회 기능이므로 readOnly = true 설정
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    public List<Review> searchReview(String query, String type){

        // Q클래스 정의
        QReview review = QReview.review;

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // BooleanBuilder 사용

        // 동적 쿼리
        if (type.equals("region")) {
            // builder.and(review.store.region.name.contains(query));
        }

        return null;
    }

    // 멤버 ID로 내가 쓴 리뷰 목록을 가져오는 메소드
    public ReviewResDTO.ReviewListDTO getReviewList(Long memberId, Integer page){

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Review> result = reviewRepository.findAllByMember(member, pageRequest);
        return ReviewConverter.toReviewListDTO(result);
    }
}
