package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    @GetMapping("hello")
    public String hello(Model modeL) {
        modeL.addAttribute("data", "hello!!!");
        return "hello";
    }
}
