package com.project.e_commerce_login_user.utils.mappers;

import com.project.e_commerce_login_user.domain.User;
import com.project.e_commerce_login_user.dtos.UserDTO;
import com.project.e_commerce_login_user.infra.db.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserModel setUserDTOforUserModel(UserDTO userDTO);

    User setUserModelforUser(UserModel userModel);
}
