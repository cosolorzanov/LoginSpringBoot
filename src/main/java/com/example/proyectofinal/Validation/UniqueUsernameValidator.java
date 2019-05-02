package com.example.proyectofinal.Validation;

import com.example.proyectofinal.Repository.UserRepository;
import com.example.proyectofinal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return  s!= null & !userRepository.existsByUsername(s);
    }
}
