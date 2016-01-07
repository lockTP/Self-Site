package com.lockTP.service;
import java.net.UnknownHostException;  
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lockTP.dao.UserDao;
import com.lockTP.model.User;

@Component  
public class UserService {
	private UserDao userDao = new UserDao();  
    
	public UserDao getUserDao() {  
        return userDao;  
    }  
  
    @Resource  
    public void setUserDao(UserDao userDao) {  
        this.userDao = userDao;  
    }  
	
    /** 
     * 保存 
     * @param user 
     * @throws UnknownHostException 
     */  
    public void save(User user) throws UnknownHostException{  
    	user.setId(UUID.randomUUID().toString());
        this.userDao.save(user);  
    }  
      
      
      
    /** 
     * 更新 
     * @param user 
     * @throws UnknownHostException 
     */  
    public void update(User user) throws UnknownHostException {  
        this.userDao.update(user);  
    }  
      
    /** 
     * 查询所有 
     * @return 
     * @throws UnknownHostException  
     */  
    public List<User> findAll() throws UnknownHostException{  
        return this.userDao.findAll();  
    }  
      
      
    /** 
     * 删除操作 
     * @param id 
     * @throws UnknownHostException 
     */  
    public void remove(int id) throws UnknownHostException{  
        this.userDao.remove(id);  
    }
}
