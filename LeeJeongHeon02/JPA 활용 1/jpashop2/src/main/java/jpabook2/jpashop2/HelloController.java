package jpabook2.jpashop2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello World");
        return "hello";
    }

    @GetMapping("hellosecret")
    public String secret(Model model) {
        model.addAttribute("secret", "소환사님");
        return "hellosecret";
    }
}
