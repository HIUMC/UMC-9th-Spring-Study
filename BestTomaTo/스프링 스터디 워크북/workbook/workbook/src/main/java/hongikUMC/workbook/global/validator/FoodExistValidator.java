package hongikUMC.workbook.global.validator;

import hongikUMC.workbook.domain.member.exception.code.FoodErrorCode;
import hongikUMC.workbook.domain.member.repository.FoodRepository;
import hongikUMC.workbook.global.annotation.ExistFoods;
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
    public boolean isValid(List<Long> longs, ConstraintValidatorContext context) {
        boolean isValid = longs.stream()
                .allMatch(value -> foodRepository.existsById(value));

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(FoodErrorCode.NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;
    }
}
