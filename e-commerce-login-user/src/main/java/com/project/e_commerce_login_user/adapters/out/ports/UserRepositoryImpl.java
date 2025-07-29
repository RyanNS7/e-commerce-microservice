package com.project.e_commerce_login_user.adapters.out.ports;

import com.project.e_commerce_login_user.domain.User;
import com.project.e_commerce_login_user.dtos.UserDTO;
import com.project.e_commerce_login_user.infra.db.models.UserModel;
import com.project.e_commerce_login_user.infra.db.repositories.UserDBRepository;
import com.project.e_commerce_login_user.utils.mappers.UserMapper;
import com.project.e_commerce_login_user.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    UserDBRepository userRepo;
    UserMapper userMapper;

    public UserRepositoryImpl(UserDBRepository userRepo, UserMapper userMapper){
        this.userMapper = userMapper;
        this.userRepo = userRepo;
    }

    @Override
    public User save(UserDTO userDTO) {

        try{

            UserModel userModel = userRepo.save(userMapper.setUserDTOforUserModel(userDTO));

            return userMapper.setUserModelforUser(userModel);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User findByID(UUID id) {

        try{

            Optional<UserModel> user = userRepo.findById(id);

            if(user.isEmpty()){
                throw new EntityNotFoundException("Error, User Not Founded");
            }

            return userMapper.setUserModelforUser(user.get());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
