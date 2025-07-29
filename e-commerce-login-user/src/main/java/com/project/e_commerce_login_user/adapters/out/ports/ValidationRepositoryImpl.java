package com.project.e_commerce_login_user.adapters.out.ports;

import com.project.e_commerce_login_user.validations.EmailValidation;
import com.project.e_commerce_login_user.validations.PasswordValidation;
import com.project.e_commerce_login_user.validations.Repository.ValidationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ValidationRepositoryImpl implements ValidationRepository {

    @Override
    public boolean EmailValidator(String email) {
        return new EmailValidation().validate(email);
    }

    @Override
    public boolean PasswordValidator(String password) {
        return new PasswordValidation().validate(password);
    }
}
