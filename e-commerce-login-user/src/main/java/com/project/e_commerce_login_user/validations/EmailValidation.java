package com.project.e_commerce_login_user.validations;

import com.project.e_commerce_login_user.utils.exceptions.InvalidEmail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

    public boolean validate(String email){

        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches()) {
            throw new InvalidEmail("Error, Invalid Email");
        }

        return true;
    };
}
