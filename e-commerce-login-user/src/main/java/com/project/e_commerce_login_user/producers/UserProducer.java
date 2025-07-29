package com.project.e_commerce_login_user.producers;

import com.project.e_commerce_login_user.dtos.CartDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.user}")
    private String routingKey;

    public void publishMessageUserEmail(CartDTO cartDTO){

        rabbitTemplate.convertAndSend("", routingKey, cartDTO);

    }
}
