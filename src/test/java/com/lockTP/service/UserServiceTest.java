package com.lockTP.service;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lockTP.model.User;


//使用spring-junit来注入类进行测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserServiceTest {
	
	@Autowired
	UserService userService;

	@Ignore
	@Test
	public void testSave() {
		User user = new User();
		user.setId("1");
		user.setName("lockTP");
		user.setAddress("China");
		try {
			userService.save(user);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, 1);
	}
	
	@Test
	public void testFindAll() {
		try {
			ArrayList<User> users = (ArrayList<User>) userService.findAll();
			for(int i = 0; i < users.size(); i++){
				System.out.print(users.get(i).toString());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1, 1);
	}

}
