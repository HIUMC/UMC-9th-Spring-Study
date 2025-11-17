package com.example.Chapter6.domain.review.dto.request;

import com.example.Chapter6.domain.user.enums.Gender;
import com.example.Chapter6.global.annotation.ExistFoods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class ReviewRequestDTO {
    public record reviewDTO(
          Long storeId,
          Long memberId,
          Float stars,
          String content
    ){}
}
