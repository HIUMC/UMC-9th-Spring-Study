package com.example.umc9th.global.resolver;

import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.review.exception.code.ReviewErrorCode;
import com.example.umc9th.global.annotation.PageParam;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
@Component
public class PageParamArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageParam.class)
                && parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) {

        PageParam annotation = parameter.getParameterAnnotation(PageParam.class);
        String paramName = annotation != null ? annotation.value() : "page";

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String pageParam = request.getParameter(paramName);

        if (pageParam == null) {
            // 기본값: page = 1
            return 1;
        }

        int page;
        try {
            page = Integer.parseInt(pageParam);
        } catch (NumberFormatException e) {
            throw new ReviewException(ReviewErrorCode.INVALID_PAGE_REQUEST);
        }

        if (page <= 0) {
            throw new ReviewException(ReviewErrorCode.INVALID_PAGE_REQUEST);
        }

        return page;
    }
}
