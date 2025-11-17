package com.example.umcworkbook.validator;

import com.example.umcworkbook.annotation.ExistCategories;
import com.example.umcworkbook.apiPayload.code.error.CategoryErrorCode;
import com.example.umcworkbook.repository.CategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final CategoryRepository categoryRepository;

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(categoryRepository::existsById);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(CategoryErrorCode.NOT_FOUND.getMessage())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
