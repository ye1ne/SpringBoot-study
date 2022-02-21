package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!");
        return "hello"; //리소시스에 있는 헬로우를 찾아서 가서 랜더링 하라는 의미임
        //찾아 랜더링 후 타임리프 템플릿 엔진이 처리하는것, 이렇게 동작하도록 스프링 부트가 셋팅해줌
    }
    @GetMapping("hello-mvc")
    public String helloMvs(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //문자가 아니라 객체를 줌, 객체가 오면 그냥 json 방식으로 데이터를 반환하겠다는게 기본정책


    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
