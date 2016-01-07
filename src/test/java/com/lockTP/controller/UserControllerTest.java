package com.lockTP.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserControllerTest {

	@InjectMocks
	UserController userController;
	
	MockMvc mockMVC;
	
	@Before
	public void init(){
		//注入虚拟controller
		MockitoAnnotations.initMocks(this);
		mockMVC = MockMvcBuilders.standaloneSetup(userController).build();		
	}
	
	
	//MockMVC 虚拟请求测试
	@Test
	public void testMockMVCRequest() throws Exception{
		//发送虚拟请求
		MvcResult result = mockMVC.perform(get("/user/testMockMVC")
		        .param("para", "abcdefg")).andReturn();
		//验证
		ModelAndView mv = result.getModelAndView();
		assertEquals("redirect:/fileUpLoadSuccess.jsp", mv.getViewName());
		assertEquals("abcdefg", mv.getModel().get("para"));
	}

}
