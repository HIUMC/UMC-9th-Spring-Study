package hongikUMC.workbook.global.validator;

import hongikUMC.workbook.global.annotation.ExistPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PageExistValidator implements ConstraintValidator<ExistPage, List<Long>> {
    //private final PageRepository pageRepository;

    @Override
    public boolean isValid(List<Long> value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        List<Long> ids = value.stream()
                .filter(Objects::nonNull)
                .distinct()
                .toList();

        long existCount = pageRepository.countByIdIn(ids);
        return existCount == ids.size();
    }



}
