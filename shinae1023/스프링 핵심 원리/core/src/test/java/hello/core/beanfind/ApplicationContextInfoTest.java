package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.web.reactive.server.HttpHandlerConnector;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String [] beanDefinitionNames =ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            //부모타이브이 스프링빈을 조회하면 자식 타입도 함께 조회한다.
            //그래서 모든 자바 객체의 최고 부모인 object 타입으로 조회하면 모든 스프링빈을 조회한다.
            System.out.println("name = " + beanDefinitionName + " object = "+bean);
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean(){
        String [] beanDefinitionNames =ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //Bean 하나하나에 대한 정보
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ //getRole() 역할 가져옴
                //애플리케이션을 위해 직접 등록한 빈들을 출력
                //Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = "+bean);
            }

        }
    }
}
