package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

// HTML을 보내는 방식
public class HelloController {
    @GetMapping("hello")
    public  String hello(Model model){
        model.addAttribute("data", "hello!!");
                return "hello";
    }

    // URL 에서 주는 방식 (URL 에서 뽑아서 HTML 로)
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    // Data 만 넘기는 방식
    @GetMapping("hello-string")
    @ResponseBody // HTML Body 에 데이터를 직집 넣겠다는 의미를 가진 어노테이션.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //JSON 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName(){
            return name;
        }


        public String setName(String name) {
            return this.name = name;
        }
    }
}
