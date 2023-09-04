package com.abdullah.rabbitmqtester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.abdullah")
@SpringBootApplication
public class RabbitMqTesterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqTesterApplication.class,args);
    }
}
