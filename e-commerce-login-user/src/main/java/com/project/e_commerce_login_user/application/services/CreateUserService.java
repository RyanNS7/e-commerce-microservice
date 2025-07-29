package com.project.e_commerce_login_user.application.services;

import com.project.e_commerce_login_user.domain.User;
import com.project.e_commerce_login_user.dtos.UserDTO;
import com.project.e_commerce_login_user.producers.UserProducer;
import com.project.e_commerce_login_user.utils.exceptions.InvalidNumberOfCharacters;
import com.project.e_commerce_login_user.domain.repositories.UserRepository;
import com.project.e_commerce_login_user.validations.Repository.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ValidationRepository validationRepository;

    public User set(UserDTO userDTO) throws Exception{

        if(userDTO.name().length() <= 3){
            throw new InvalidNumberOfCharacters("Error, invalid number of characters, the name must contain more characters");
        }

        try{

            validationRepository.EmailValidator(userDTO.email());
            validationRepository.PasswordValidator(userDTO.password());

            return userRepository.save(userDTO);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
