package com.password.validation;

import com.password.validation.controller.UserController;
import com.password.validation.service.ValidatePasswordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(UserController.class)
//@SpringBootTest
class ValidationApplicationTests {

	static final String url = "/login";

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Autowired
	ValidatePasswordService passwordService;

//	@Test
//	public void validPassword() throws Exception {
//
//		RequestBuilder req = MockMvcRequestBuilders
//				.post("/login")
//				.contentType(MediaType.APPLICATION_JSON_VALUE)
//				.param("password","123453122");
//
//		MvcResult res = mockMvc.perform(req).andReturn();
//		System.out.println("aaaaa"+res.getResponse().getContentAsString());
//	}
//
//	@Test
//	public void deveChamarOController() throws Exception {
//		Mockito.when(passwordService.isValid(Mockito.anyString())).thenReturn(true);
//
//
//		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
//				.post("/teste")
//				.param("password","123453122");
//
//		mockMvc.perform(request).andReturn();
//
//	}
//
//	@Test
//	public void passwordIsValid() throws Exception {
//		Assertions.assertTrue(passwordService.isValid("aB213@c!d"));
//	}
//
//
//	@Test
//	public void passwordOnlyNumbers() throws Exception {
//		Assertions.assertEquals(passwordService.isValid("12442156"), false);
//	}
//
//	@Test
//	public void passwordOnlyLetter() throws Exception {
//		Assertions.assertEquals(passwordService.isValid("abcdefgh"), false);
//	}
//
//	@Test
//	public void passwordWithoutEspecialChar() throws Exception {
//		Assertions.assertEquals(passwordService.isValid("Abc123Dz5"), false);
//	}
//
//	@Test
//	public void passwordLowerCase() throws Exception {
//		Assertions.assertEquals(passwordService.isValid("abc123dz5"), false);
//	}
}
