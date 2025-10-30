package hello.core.lifecycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new
                AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
    }
package hello.core.lifecycle;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
    public class NetworkClient {
        private String url;
        public NetworkClient() {
            System.out.println("생성자 호출, url = " + url);
        }
        public void setUrl(String url) {
            this.url = url;
        }
        //서비스 시작시 호출
        public void connect() {
            System.out.println("connect: " + url);
        }
        public void call(String message) {
            System.out.println("call: " + url + " message = " + message);
        }
        //서비스 종료시 호출
        public void disConnect() {
            System.out.println("close + " + url);
        }
        @PostConstruct
        public void init() {
            System.out.println("NetworkClient.init");
            connect();
            call("초기화 연결 메시지");
        }
        @PreDestroy
        public void close() {
            System.out.println("NetworkClient.close");
            disConnect();
        }
    }
}

