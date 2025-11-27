package hello.umc9th.domain.review.service;

import hello.umc9th.domain.review.dto.ReviewResDTO;

import java.util.List;

//검색 / 전체조회 / 페이징조회
public interface ReviewQueryService {
    //검색 api
    List<ReviewResDTO.ReviewInfo> searchReview(String type, String query);

    //가게의 리뷰들 조회
    ReviewResDTO.ReviewPreviewListDTO getReviewList(Long storeId, Integer page);

    //내가 작성한 리뷰 목록 조회
    ReviewResDTO.ReviewPreviewListDTO getMyReviewList(Integer page);
}
