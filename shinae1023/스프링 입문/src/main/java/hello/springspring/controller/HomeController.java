package hello.springspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
//localhost 8080에서 요청이 오면 먼저 컨트롤러를 찾아봄
// index.html 정적 리소스는 무시하고 얘를 먼저 호출한 후 끝
