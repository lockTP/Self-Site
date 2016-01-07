package com.lockTP.model;

import com.lockTP.utils.JsonUtils;
import com.mongodb.DBObject;

public class User {
	 	private String id;  
	    private String name;  
	    private String address;  
	      
	      
	    public String getId() {  
	        return id;  
	    }  
	    public void setId(String id) {  
	        this.id = id;  
	    }  
	    public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	    public String getAddress() {  
	        return address;  
	    }  
	    public void setAddress(String address) {  
	        this.address = address;  
	    }  
	      
	      
	    public String toJson(){  
	        return JsonUtils.toJson(this);  
	    }  
	      
	    public void parse(DBObject dbo){  
	        this.setId((String)dbo.get("id"));  
	        this.setName((String)dbo.get("name"));  
	        this.setAddress((String)dbo.get("address"));  
	    }  
	      
	      
	    public String toString(){  
	        return "id:"+id+",name:"+name+",address:"+address;  
	    }
}
