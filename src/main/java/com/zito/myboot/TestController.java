package com.zito.myboot;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "id" ,required = false, defaultValue = "20") Integer id){
        return "id= " + id ;
    }

}
