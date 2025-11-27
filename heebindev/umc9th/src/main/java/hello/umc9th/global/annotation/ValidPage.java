package hello.umc9th.global.annotation;

import hello.umc9th.global.validator.PageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

//page 검증 에노테이션
@Documented
@Constraint(validatedBy = PageValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPage {

    String message() default "page는 1이상의 정이어야 한다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
