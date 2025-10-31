package hello2.core2.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class MyLogger {

    private String uuid;

    @Setter
    private String requestURL;

    public void log(String message) {
        System.out.println(uuid + "  " + requestURL + "  " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println(uuid + " init...  " + this);

    }

    @PreDestroy
    public void close() {
        System.out.println(uuid + " close... " + this);
    }

}
