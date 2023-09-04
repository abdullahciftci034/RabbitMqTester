package com.abdullah.rabbitmqtester.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TestService {

    private final AmqpTemplate rabbitTemplate;
    private final DirectExchange exchange;

    @Value("${sample.rabbitmq.queue}")
    String queueName;

    @Value("${sample.rabbitmq.routingKey}")
    String routingKey;

    public TestService(AmqpTemplate rabbitTemplate, DirectExchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public String getkey(String str){
        System.out.println(str);
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, str+" ; first que");
        return "İşlem başarılı";
    }

    @RabbitListener(queues = "${sample.rabbitmq.queue}")
    public void transferMoneyMessage(String str) {
        System.out.println(str);
        rabbitTemplate.convertAndSend(exchange.getName(), "thirdRoute", str+" second qeu ; ");
    }

    @RabbitListener(queues = "secondStepQueue")
    public void updateReceiverAccount(String str) {
        System.out.println(str);
        rabbitTemplate.convertAndSend(exchange.getName(), "thirdRoute", str+" second qeu ; ");
    }

    @RabbitListener(queues = "thirdStepQueue")
    public void finalizeTransfer(String str) {
        System.out.println(str);
        str+="; third que";
        System.out.println(str);

    }
}
