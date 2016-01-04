package com.lockTP.controller;


import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lockTP.service.FileService;


/**
 * 控制层
 */
@Controller  
@RequestMapping("/file")  
public class FileController implements ServletContextAware{  

	private ServletContext servletContext;
	
	@Resource
	private FileService fileService;
	
	@Override  
    public void setServletContext(ServletContext servletContext) {  
        this.servletContext = servletContext;  
    }  

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)  
    public ModelAndView fileUpload(
    		@RequestParam("up") MultipartFile multipartFile) throws Exception{  
        String path = servletContext.getRealPath("/");  
  
        //将文件存入服务器
        String storePath = fileService.saveFile(multipartFile, path);
        ModelAndView mv = new ModelAndView("redirect:/fileUpLoad.jsp");
        mv.addObject("storePath", storePath);
        return mv;
	}

}
