package com.project.e_commerce_login_user.validations.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository {

    boolean EmailValidator(String email);
    boolean PasswordValidator(String email);

}
