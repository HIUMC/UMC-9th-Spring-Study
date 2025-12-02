package com.example.Chapter6.global.validator;

import com.example.Chapter6.domain.user.exception.code.FoodErrorCode;
import com.example.Chapter6.global.annotation.ValidPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageValidator implements ConstraintValidator<ValidPage, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context){

        boolean isValid = value > 0 ;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(FoodErrorCode.NOT_FOUND.getMessage()).addConstraintViolation();
        }

        return isValid;
    }

}
