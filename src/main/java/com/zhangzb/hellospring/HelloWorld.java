package com.zhangzb.hellospring;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
//@Controller
//@ResponseBody
public class HelloWorld {
//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;

    @Autowired
    private  GirlProperties girlProperties;

    @GetMapping(value = "/say")
    public String sayHello(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId) {

        return  "id: "+ myId;
    }

}
