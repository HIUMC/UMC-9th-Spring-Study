package umc9th.global.annotation;

import jakarta.validation.Payload;

public @interface CheckPage {

    String message() default "페이지 번호는 1이상이어야함 ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}