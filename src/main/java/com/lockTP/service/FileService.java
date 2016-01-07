package com.lockTP.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component  
public class FileService {

	/** 
     * 保存 
     * @param multipartFile
     * @param path
	 * @throws IOException 
	 * @throws IllegalStateException 
     */ 
	public String saveFile(MultipartFile multipartFile, String path) throws IllegalStateException, IOException{
        File file = null;
		 if(multipartFile.isEmpty()){  //是否有选择文件
	            System.out.println("没有选择文件");  
	        }else{  //将文件存入服务器
	            String fileName = multipartFile.getOriginalFilename();  
	            path = path + File.separatorChar + "fileUpLoad" + File.separatorChar + "pic" + File.separatorChar;
	            file = new File(path+fileName);  
	            multipartFile.transferTo(file);  
	              
	            System.out.println("文件名："+fileName);  
	            System.out.println("文件路径："+file.getPath());  
	            System.out.println("文件后缀名："+FilenameUtils.getExtension(multipartFile.getOriginalFilename()));  
	        }
		return file.getPath();
	}
}
