package com.project.e_commerce_cart.utils.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Value("${broker.queue.email.user}")
    private String queue;

    @Bean
    public Queue queue(){
        return new Queue(queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter converterMessage(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
