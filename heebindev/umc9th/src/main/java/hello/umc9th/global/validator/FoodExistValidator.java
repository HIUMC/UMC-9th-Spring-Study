package hello.umc9th.global.validator;

import hello.umc9th.domain.member.exception.code.FoodErrorCode;
import hello.umc9th.domain.member.repository.FoodRepository;
import hello.umc9th.global.annotation.ExistFoods;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
//ExistFoods 어노테이션에 대한 로직을 담을 것이며 검증 대상이 List<Long>임을 명시
public class FoodExistValidator implements ConstraintValidator<ExistFoods, List<Long>> {

    private final FoodRepository foodRepository;

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()//stream을 돌려서 DB에 없는 경우, isValid를 false로 변경
                .allMatch(value -> foodRepository.existsById(value));

        if (!isValid) {
            // 이 부분에서 아까 디폴트 메시지를 초기화 시키고, 새로운 메시지로 덮어씌우게 됩니다.
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(FoodErrorCode.NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;

    }
}
