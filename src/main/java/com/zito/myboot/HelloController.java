package com.zito.myboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private StrudentProperties strudentProperties;

    @RequestMapping(value = "/hello")
    public String sayHello(){
        return "hello World @2018 .student:" + strudentProperties.getName() + ",age="+
                strudentProperties.getAge() +". say ' "+ strudentProperties.getContent()+" '.";
    }

    @RequestMapping(value = {"/hello","/hi"} ,method = RequestMethod.GET)
    public String hello(){
        return "hello World @2018 .student:" + strudentProperties.getName() + ",age="+
                strudentProperties.getAge() +". say ' "+ strudentProperties.getContent()+" '.";
    }

}
