package com.abdullah.rabbitmqtester.controller;


import com.abdullah.rabbitmqtester.services.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }


    @GetMapping("/home")
    public String kelimeciktisi(String str){
        return this.testService.getkey(str);
    }

}
