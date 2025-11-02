// UMC/week4/controller/ReviewController.java
package UMC.week4.controller;

import UMC.week4.domain.Review;
import UMC.week4.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/my")
    public Page<Review> getMyReviews(
            @RequestParam("memberId") Long memberId,

            @RequestParam(name = "storeName", required = false) String storeName,
            @RequestParam(name = "starRating", required = false) Integer starRating,

            @PageableDefault(size = 10) Pageable pageable
    ) {
        return reviewService.getMyReviews(memberId, storeName, starRating, pageable);
    }
}
