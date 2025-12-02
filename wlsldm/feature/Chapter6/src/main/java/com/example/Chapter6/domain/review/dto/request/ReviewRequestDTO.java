package com.example.Chapter6.domain.review.dto.request;

public class ReviewRequestDTO {
    public record reviewDTO(
          Long storeId,
          Long memberId,
          Float stars,
          String content
    ){}

}
