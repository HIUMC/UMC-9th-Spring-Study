package hello.umc9th.domain.review.controller;

import hello.umc9th.domain.review.entity.Review;
import hello.umc9th.domain.review.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewQueryController {

    private final ReviewQueryService reviewQueryService;

    //검색 요청
    @GetMapping("/review/search")
    public List<Review> search(@RequestParam String query, @RequestParam String type){
        //서비스에게 요청
        List<Review> result = reviewQueryService.searchReview(query, type);
        return result;
    }

    //내 리뷰 검색요청
    @GetMapping("/my/reviews/search")
    public List<Review>  getMyReviews(@RequestParam String query, @RequestParam String type){
        //서비스에게 요청
        List<Review> result = reviewQueryService.searchMyReview(query, type);
        return result;
        //리턴문을 인라인 가능할거같음..
    }
}
