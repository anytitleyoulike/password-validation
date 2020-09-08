package com.password.validation.controller;


import com.password.validation.exception.ValidationException;
import com.password.validation.model.User;
import com.password.validation.service.ValidatePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    ValidatePasswordService passwordService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        try {
            passwordService.isValid(user.getPassword());
            return "Senha validada com sucesso!";
        } catch(ValidationException e) {
            return e.getMessage();
        }


    }
}
