package com.project.e_commerce_login_user;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@EnableRabbit
@SpringBootApplication
public class ECommerceLoginUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceLoginUserApplication.class, args);
	}

}
