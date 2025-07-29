package com.project.e_commerce_login_user.domain.repositories;

import com.project.e_commerce_login_user.domain.User;
import com.project.e_commerce_login_user.dtos.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository {

    User save(UserDTO userDTO);
    User findByID(UUID id);
}
