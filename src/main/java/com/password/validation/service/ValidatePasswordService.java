package com.password.validation.service;

import com.password.validation.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidatePasswordService {

    public void isValid(String password) throws ValidationException {

        Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]");
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

        if( password.equals("")) {
            throw new ValidationException("campo vazio");
        }
        if (password.length() < 9) {
            throw new ValidationException("A senha possui menos de 8 campos");
        }
        if (!specailCharPatten.matcher(password).find()) {
            throw new ValidationException("A senha precisa conter caracter especial");
        }
        if (!UpperCasePatten.matcher(password).find()) {
            throw new ValidationException("A senha precisa conter ao menos uma letra maiúscula");
        }
        if (!lowerCasePatten.matcher(password).find()) {
            throw new ValidationException("A senha precisa conter ao menos uma letra minúscula");
        }

        if(!digitCasePatten.matcher(password).find()){
            throw new ValidationException("A senha precisa conter ao menos um número");
        }

        String pass = password.toLowerCase();
        for(int i=0; i < password.length(); i++) {
            char currentLetter = pass.charAt(i);
            for(int j=i+1; j < pass.length(); j++) {
                if(currentLetter == pass.charAt(j)){
                    throw new ValidationException("A senha contém caracteres repetidos");
                }
            }
        }
    }
}