package hongikUMC.workbook.domain.review.controller;

import hongikUMC.workbook.domain.review.entity.Review;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    @GetMapping("/reivews/search")
    public List<Review> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ){

        // 서비스에 요청
        //List<Review> result = reviewQueryService.searchReview(query, type);
        //return result;

        return null;
    }
}
