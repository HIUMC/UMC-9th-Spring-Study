package com.heebin.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello로 들어오면 아래 매서드를 호출
    public String hello(Model model){
        model.addAttribute("data","hello");
        //key: data, value: hello
        return "hello";
        //hello.html OR hello.jsp로 이동.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
        //여기서 return "hello"는 더 이상 hello.html이 아니다.
        //@ResponseBody에 의해 그냥 hello라는 문자열 자체이다.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPI(@RequestParam("name") String name) {
        Hello hello = new Hello();         // Hello 객체 생성
        hello.setName(name);               // 파라미터로 받은 name 값을 객체에 저장
        return hello;                      // 객체 반환 (→ JSON으로 자동 변환됨)
    }


    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
