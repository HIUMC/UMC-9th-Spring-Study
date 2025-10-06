package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member" 원하는 시작위치부터 스캔
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //예제코드 살리기 위함
)

//안 붙이면 AutoConfig 의 시작위치인 hello.core 부터 뒤진당
public class AutoAppConfig {

}
