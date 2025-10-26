package hello.core.singletontest;

import hello.core.AppConfig;
import hello.core.member.MemberService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class singletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = "+memberService1);
        System.out.println("memberService2 = "+memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

        //스프링 없는 순수 DI 컨테이너ㄴ인 AppConfig는 요청을 할 때 마다 객체를 새로 생성
        //고객 트래픽이 많은 경우 메모리 낭비가 심함
        //해결방안 : 해당 객체가 딱 1개만 생성되고, 공유하도록 설계하면 됨. -> 싱글톤 패턴
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonSErviceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 =  SingletonService.getInstance();

        System.out.println("singleton1 = "+singletonService1);
        System.out.println("singleton2 = "+singletonService2);
        //static이므로 똑같은 참조값을 반환

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    /* 싱글톤 패턴 문제점
    싱글톤 패턴을 구현하는 코드 많이 들어감
    의존관계 상 클라이언트가 구체 클래스에 의존 -> DIP 위반
    테스트 어려움, 속성 변경 및 초기화 어려움, 자식 클래스 만들기 어려윰
    -> 스프링 컨테이너 사용하면 문제 해결
     */

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
       // AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 =ac.getBean("memberService", MemberService.class);

        //참조값이 같음
        System.out.println("memberService1 = "+memberService1);
        System.out.println("memberService2 = "+memberService2);

        //memberService1 = memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }
    /*
        스프링 컨테이너 덕분에 고객의 요청이 올 때 마다 객체를 생성하는 것이 아니라
        이미 만들어진 객체를 공유해서 효율적으로 재사용할 수 있다.
     */
}
