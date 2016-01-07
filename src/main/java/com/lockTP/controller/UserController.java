package com.lockTP.controller;


import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lockTP.model.User;
import com.lockTP.service.UserService;

/**
 * 控制层
 */
@Controller  
@RequestMapping("/user")  
public class UserController {  
  
    private UserService userService;  
    
    
    @RequestMapping(params = "method=add")  
    public String add(User user){  
        System.out.println("名字:"+user.getName());  
        System.out.println("地址:"+user.getAddress());  
        try {
			userService.save(user);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return "success";  
    }  

    public UserService UserService() {  
        return userService;  
    }  
    @Resource  
    public void setUserService(UserService userService) {  
        this.userService = userService;  
    }  
    
    
    /**
     * JSON数据返回测试
     * 多条数据
     * ResponseEntity
     */
    @RequestMapping(value="getUserList", method=RequestMethod.GET)
    public ResponseEntity<List<User>> getUserList(){
    	List<User> users = null;
		try {
			users = userService.findAll();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    
    /**
     * 用于MockMVC基础测试
     * 
     */
    @RequestMapping(value = "/testMockMVC", method = RequestMethod.GET)  
    public ModelAndView mockMVCRequest(String para) throws Exception{  
        ModelAndView mv = new ModelAndView("redirect:/fileUpLoadSuccess.jsp");
        mv.addObject("para", para);
        return mv;
	}

}