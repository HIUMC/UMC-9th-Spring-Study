package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {
    /* 로그 뽑기
    Logger log = LoggerFactory.getLogger(HomeController.class);
    단, 위 코드 대신에 @Slf4j를 하면 롬복이 같은 코드를 만들어준다.
    */

    @RequestMapping("/")
    public String home() {
        log.info("home controller"); //로그 뽑기 by lombok
        return "home"; //home.html로 이동
    }
}
