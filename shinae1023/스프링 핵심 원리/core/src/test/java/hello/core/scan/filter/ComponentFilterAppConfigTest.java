package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA",BeanA.class);
        Assertions.assertThat(beanA).isNotNull();
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter //추가로 컴포낸트스캔
                    (type = FilterType.ANNOTATION,
                            classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter //컴포낸트 스캔 제외
            (type = FilterType.ANNOTATION,
            classes = MyExcludeComponent.class))
    static class ComponentFilterAppConfig{

    }
}

/*
FilterType 옵션
    1. ANNOTATION : 기본값, 애노테이션을 인식해서 동작한다
    2. ASSIGNABLE_TYPE : 지정한 타입과 자식타입을 인식해서 동작한다
    3. ASPECTJ : AspectJ 패턴 사용
    4. REGEX : 정규 표현식
    5. CUSTOM : TypeFilter 이라는 인터페이스를 구현해서 처리
 */
