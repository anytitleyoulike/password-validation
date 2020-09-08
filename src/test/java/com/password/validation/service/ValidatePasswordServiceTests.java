package com.password.validation.service;


import com.password.validation.exception.ValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ValidatePasswordServiceTests {
    @InjectMocks
    ValidatePasswordService passwordService;

    @Rule
    public ExpectedException excecaoEsperada = ExpectedException.none();

    @Test
    public void passwordLessThan8chars() throws Exception {

        excecaoEsperada.expect(ValidationException.class);
        excecaoEsperada.expectMessage("A senha possui menos de 8 campos");

        passwordService.isValid("1234");
    }

    @Test
    public void passwordIsEmpty() throws Exception {

        excecaoEsperada.expect(ValidationException.class);
        excecaoEsperada.expectMessage("campo vazio");

        passwordService.isValid("");
    }

    @Test
    public void passwordWithoutSpecialchars() throws Exception {

        excecaoEsperada.expect(ValidationException.class);
        excecaoEsperada.expectMessage("A senha precisa conter caracter especial");

        passwordService.isValid("abcdfghip");
    }

    @Test
    public void passwordWithoutLowercase() throws Exception {

        excecaoEsperada.expect(ValidationException.class);
        excecaoEsperada.expectMessage("A senha precisa conter ao menos uma letra minúscula");

        passwordService.isValid("ABCDEF1@H");
    }

    @Test
    public void passwordWithoutUppercase() throws Exception {

        excecaoEsperada.expect(ValidationException.class);
        excecaoEsperada.expectMessage("A senha precisa conter ao menos uma letra maiúscula");

        passwordService.isValid("bca@jsp2ac");
    }

    @Test
    public void passwordHasRepeatedChars() throws Exception {

        excecaoEsperada.expect(ValidationException.class);
        excecaoEsperada.expectMessage("A senha contém caracteres repetidos");

        passwordService.isValid("Bca@jsp2ac");
    }



}
