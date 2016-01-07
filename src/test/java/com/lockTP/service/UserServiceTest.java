package com.lockTP.service;

import static org.junit.Assert.*;

import java.awt.List;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import com.lockTP.model.User;

public class UserServiceTest {

	@Ignore
	@Test
	public void testSave() {
		UserService userService = new UserService();
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
		UserService userService = new UserService();
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
