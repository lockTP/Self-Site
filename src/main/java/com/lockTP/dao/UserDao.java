package com.lockTP.dao;

import com.lockTP.model.User;

import java.net.UnknownHostException;  
import java.util.ArrayList;  
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;  
import com.mongodb.DB;  
import com.mongodb.DBCollection;  
import com.mongodb.DBCursor;  
import com.mongodb.DBObject;  
import com.mongodb.Mongo;  
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

@Component  
public class UserDao {

	
	@Autowired  
    private MongoTemplate mongoTemplate;
	 /** 
     * 保存 
     * @param user 
     * @throws UnknownHostException 
     */  
    public void save(User user) throws UnknownHostException {  
    	DB myMongo = mongoTemplate.getDb();
        DBCollection userCollection = myMongo.getCollection("user");  
  
        DBObject dbo = (DBObject) JSON.parse(user.toJson());  
        userCollection.insert(dbo);  
    }  
  
    /** 
     * 更新 
     * @param user 
     * @throws UnknownHostException 
     */  
    public void update(User user) throws UnknownHostException {  
    	DB myMongo = mongoTemplate.getDb(); 
        DBCollection userCollection = myMongo.getCollection("user");  
  
        BasicDBObject baseDBO = new BasicDBObject();  
        baseDBO.put("id", user.getId());  
          
        DBObject newDBO = (DBObject) JSON.parse(user.toJson());  
          
        userCollection.update(baseDBO, newDBO);  
    }  
      
    /** 
     * 查询所有 
     * @return 
     * @throws UnknownHostException  
     */  
    public List<User> findAll() throws UnknownHostException{  
    	DB myMongo = mongoTemplate.getDb();
        DBCollection userCollection = myMongo.getCollection("user");  
        DBCursor cursor=userCollection.find();  
          
        List<User> userList = new ArrayList<User>();  
        while(cursor.hasNext()){  
             User user = new User();  
             user.parse(cursor.next());  
             userList.add(user);  
        }  
        return userList;  
    }  
      
      
    /** 
     * 删除操作 
     * @param id 
     * @throws UnknownHostException 
     */  
    public void remove(int id) throws UnknownHostException{  
    	DB myMongo = mongoTemplate.getDb();
        DBCollection userCollection = myMongo.getCollection("user");  
          
          
        BasicDBObject baseDBO =new BasicDBObject();  
        baseDBO.put("id", id);  
  
        //删除某一条记录  
        userCollection.remove(baseDBO);  
    }  
}
