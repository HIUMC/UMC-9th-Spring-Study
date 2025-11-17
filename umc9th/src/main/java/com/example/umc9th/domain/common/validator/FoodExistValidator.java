package com.example.umc9th.domain.common.validator;

import com.example.umc9th.domain.Food.repository.FoodRepository;
import com.example.umc9th.domain.common.annotation.ExistFoods;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodExistValidator implements ConstraintValidator<ExistFoods, List<Long>> {

    private final FoodRepository foodRepository;

    @Override
    public void initialize(ExistFoods constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        if (values == null || values.isEmpty()) {
            return true; // 선호 음식이 없는 경우는 유효성 검사를 통과시킵니다.
        }

        // 모든 음식 ID가 DB에 존재하는지 확인합니다.
        // allMatch는 스트림의 모든 요소가 주어진 조건을 만족해야 true를 반환합니다.
        boolean allExist = values.stream()
                .allMatch(value -> foodRepository.existsById(value));

        return allExist;
    }
}
