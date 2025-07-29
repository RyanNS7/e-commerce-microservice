package com.project.e_commerce_cart.consumers;

import com.project.e_commerce_cart.dtos.CartDTO;
import com.project.e_commerce_cart.services.CreateCartService;
import com.project.e_commerce_cart.utils.exceptions.InvalidCreation;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserEmailConsumer {

    @Autowired
    private CreateCartService createCartService;

    @RabbitListener(queues = "${broker.queue.email.user}")
    public void Consumer(@Payload CartDTO cartDTO){

        try{
            createCartService.create(cartDTO);
        } catch (Exception e) {
            throw new InvalidCreation(e.getMessage());
        }

    }

}
