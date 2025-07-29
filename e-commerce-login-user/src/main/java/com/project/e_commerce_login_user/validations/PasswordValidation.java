package com.project.e_commerce_login_user.validations;

import com.project.e_commerce_login_user.utils.exceptions.InvalidPassword;

public class PasswordValidation {

    public boolean validate(String password) {
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specialChars = "!@#$%&*()_-+=;:<>/?|";

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.indexOf(c) >= 0) {
                hasSpecial = true;
            }
        }

        if(!hasLower){ throw new InvalidPassword("Error, The password must contain at least 1 lowercase characters"); }
        else if (!hasUpper) { throw new InvalidPassword("Error, The password must contain at least 1 uppercase characters"); }
        else if (!hasDigit) { throw new InvalidPassword("Error, The password must contain at least 1 number"); }
        else if (!hasSpecial) { throw new InvalidPassword("Error, The password must contain at least 1 special character"); }

        return true;
    }
}