package com.password.validation.service;

import com.password.validation.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidatePasswordService {

    public void isValid(String password) throws ValidationException {

        Pattern specialCharPattern = Pattern.compile("[^a-z0-9 ]");
        Pattern UpperCasePattern = Pattern.compile("[A-Z ]");
        Pattern lowerCasePattern = Pattern.compile("[a-z ]");
        Pattern digitCasePattern = Pattern.compile("[0-9 ]");
        Pattern whiteSpacePattern = Pattern.compile("\\s");

        if( password.equals("")) {
            throw new ValidationException("campo vazio");
        }
        if (password.length() < 9) {
            throw new ValidationException("A senha possui menos de 8 campos");
        }
        if (!specialCharPattern.matcher(password).find()) {
            throw new ValidationException("A senha precisa conter caracter especial");
        }
        if (!UpperCasePattern.matcher(password).find()) {
            throw new ValidationException("A senha precisa conter ao menos uma letra maiúscula");
        }
        if (!lowerCasePattern.matcher(password).find()) {
            throw new ValidationException("A senha precisa conter ao menos uma letra minúscula");
        }

        if(!digitCasePattern.matcher(password).find()){
            throw new ValidationException("A senha precisa conter ao menos um número");
        }

        if(whiteSpacePattern.matcher(password).find()){
            throw new ValidationException("A senha não pode ter espaços em branco.");
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