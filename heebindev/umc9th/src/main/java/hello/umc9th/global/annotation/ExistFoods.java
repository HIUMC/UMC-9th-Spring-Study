package hello.umc9th.global.annotation;

import hello.umc9th.global.validator.FoodExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

//사용자 정의 애노테이션
@Documented
//사용자가 유효성을 검증(Validation)할 수 있도록 커스텀 에노테이션을 제공해줌
@Constraint(validatedBy = FoodExistValidator.class)
//애노테이션 적용 범위
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
//애노테이션의 생명 주기
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistFoods {
    //여기서 디폴트 메시지를 설정합니다.
    String message() default "해당 음식이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
