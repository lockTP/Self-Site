package com.lockTP.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.DocumentException;
import com.lockTP.service.PrintService;

@Controller  
@RequestMapping("/print")  
public class PrintController {

	@Autowired
	PrintService printService;
	
	
    /**
     * PDF打印
     * ResponseEntity
     */
	@ResponseBody
    @RequestMapping(value="/printByInput", method=RequestMethod.GET)
    public void getPrintByInput(HttpServletRequest request,HttpServletResponse response){
		try {
			String from = request.getParameter("from");
			String content = request.getParameter("content");
			String to = request.getParameter("to");
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition","attachment; filename=letter.pdf");
			
			//执行pdf生成
			printService.printByInput(from, content, to, response.getOutputStream());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	
	
	/**
     * PDF预览
     * ResponseEntity
     */
	@ResponseBody
    @RequestMapping(value="/previewByInput", method=RequestMethod.GET)
    public void getPreviewByInput(HttpServletRequest request,HttpServletResponse response){
		try {
			String from = request.getParameter("from");
			String content = request.getParameter("content");
			String to = request.getParameter("to");
			
			printService.printByInput(from, content, to, response.getOutputStream());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	
	/**
     * PDF打印一道题
     * ResponseEntity
     */
	@ResponseBody
    @RequestMapping(value="/printOneQuesion", method=RequestMethod.GET)
    public void printOneQuesion(HttpServletRequest request,HttpServletResponse response){
		try {
			String from = request.getParameter("from");
			String content = request.getParameter("content");
			String to = request.getParameter("to");
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition","attachment; filename=letter.pdf");
			
			//执行pdf生成
			printService.printPaperOne(response.getOutputStream());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	/**
     * PDF打印一套题
     * ResponseEntity
     */
	@ResponseBody
    @RequestMapping(value="/printOnePaper", method=RequestMethod.GET)
    public void printOnePaper(HttpServletRequest request,HttpServletResponse response){
		try {
			String from = request.getParameter("from");
			String content = request.getParameter("content");
			String to = request.getParameter("to");
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition","attachment; filename=letter.pdf");
			
			//执行pdf生成
			printService.printPaperTwo(response.getOutputStream());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
