package com.example.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//이 클래스가 Spring MVC의 컨트롤러임
@Slf4j
/**
 * return home
 * "home"이라는 문자열을 반환합니다.
 * Spring Boot와 Thymeleaf를 함께 사용하는 경우,
 * 이는 src/main/resources/templates/ 폴더 아래에 있는 home.html 파일을 찾아 사용자에게 보여주는 역할을 합니다.
 */
public class HomeController {
    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "home";
    }
}
