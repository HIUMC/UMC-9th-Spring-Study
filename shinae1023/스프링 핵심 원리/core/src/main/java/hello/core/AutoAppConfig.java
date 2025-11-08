package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core.member", //member만 컴포넨트 스캔 대상
        //탐색 시작할 패키지 위치 지정 이 패키지부터 하위패키지 탐색
        //basePackageClasses = AutoAppConfig.class, // 탐색 시작할 클래스 지정
        //지정 안할 경우, hello.core부터 시작해서 하위패키지 탐색
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)) //컴포넨트 스캔 제외
public class AutoAppConfig {
    //@Autowired를 통해 의존관계 자동 주입 가능

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    } //빈 이름 중복
    //Overriding bean definition for bean 'memoryMemberRepository'
    // 수동 빈이 등록이 우선이 되며 수동 빈이 자동 빈을 오버라이딩
}

/*
@ComponentScan은 @Component가 붙은 모든 클래스를 스프링 빈으로 등록한다
이때 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다
    - 빈 이름 기본 전략: MemberServiceImpl -> memberService
    - 빈 이름 직접 지정: 만약 스프링 빈의 이름을 직접 지정하고 싶으면
      @Component("memberService")이런 식으로 이름 부여하면 됨
 */

/*
@Autowired 의존관계 자동 주입
생성자에 @Autowired를 지정하면 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입함
기본 조회 전략은 타입이 같은 빈을 찾아서 주입 getBean과 같은 기능
 */

/*
Component 스캔 기본 대상
    @Component, @Controller, @Service, @Repository, @Configuration
 */
