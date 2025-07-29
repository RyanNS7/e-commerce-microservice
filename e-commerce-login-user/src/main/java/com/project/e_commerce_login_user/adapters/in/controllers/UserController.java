package com.project.e_commerce_login_user.adapters.in.controllers;

import com.project.e_commerce_login_user.adapters.out.ports.UserRepositoryImpl;
import com.project.e_commerce_login_user.adapters.out.ports.ValidationRepositoryImpl;
import com.project.e_commerce_login_user.domain.User;
import com.project.e_commerce_login_user.dtos.CartDTO;
import com.project.e_commerce_login_user.dtos.UserDTO;
import com.project.e_commerce_login_user.application.services.CreateUserService;
import com.project.e_commerce_login_user.producers.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserRepositoryImpl userRepository;

    @Autowired
    public ValidationRepositoryImpl validationRepository;

    @Autowired
    public CreateUserService createNewUser;

    @Autowired
    private UserProducer userProducer;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) throws Exception{

        User user = createNewUser.set(userDTO);

        CartDTO cartDTO = new CartDTO(user.getEmail());

        userProducer.publishMessageUserEmail(cartDTO);

        return ResponseEntity.status(201).body(user);

    }
}
