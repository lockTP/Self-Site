package com.lockTP.service;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Component
public class PrintService {

	PdfWriter pdfWriter;
	Document document;
	
	/** 
     * 依据输入打印
	 * @throws DocumentException 
	 * @throws IOException 
     */ 
	public String printByInput(String from, String content, String to, OutputStream os) throws DocumentException, IOException{
		
		//初始化打印对象
		Rectangle rectPageSize = new Rectangle(PageSize.A4);
		document = new Document(rectPageSize, 50, 50, 50, 50);
		document.addTitle("letter");
		pdfWriter = PdfWriter.getInstance(document, os);
		document.open();
		
		//初始化打印字体
		String s =  PrintService.class.getResource("/").getFile() + "fonts"
				+ File.separator + "STSONG.TTF";
		File path = new File(s);
		BaseFont baseFont = BaseFont.createFont(path.getCanonicalPath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		
		//生成打印内容
		PdfPTable mainTable = new PdfPTable(1);
		String toString = "亲爱的" + to + ":";
		Paragraph toPara = new Paragraph(toString, new Font(baseFont));
		PdfPCell toCell = new PdfPCell(toPara);
		toCell.setMinimumHeight(50);
		toCell.setBorder(Rectangle.NO_BORDER);
		mainTable.addCell(toCell);
		
		String contentString = content;
		Paragraph contentPara = new Paragraph(contentString, new Font(baseFont));
		PdfPCell contentCell = new PdfPCell(contentPara);
		contentCell.setBorder(Rectangle.NO_BORDER);
		contentCell.setMinimumHeight(300);
		mainTable.addCell(contentCell);
		
		String wishString = "祝：\n身体健康，工作顺利！";
		Paragraph wishPara = new Paragraph(wishString, new Font(baseFont));
		PdfPCell wishCell = new PdfPCell(wishPara);
		wishCell.setBorder(Rectangle.NO_BORDER);
		wishCell.setMinimumHeight(50);
		mainTable.addCell(wishCell);
		
		String fromString = from;
		Paragraph fromPara = new Paragraph(fromString, new Font(baseFont));
		PdfPCell fromCell = new PdfPCell(fromPara);
		fromCell.setBorder(Rectangle.NO_BORDER);
		fromCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		mainTable.addCell(fromCell);
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String dateString = dateFormat.format(now);
		Paragraph datePara = new Paragraph(dateString, new Font(baseFont));
		PdfPCell dateCell = new PdfPCell(datePara);
		dateCell.setBorder(Rectangle.NO_BORDER);
		dateCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		mainTable.addCell(dateCell);
		
		document.add(mainTable);
		
		//添加背景图片
		String imagefile =  PrintService.class.getResource("/").getFile() + "image"
				+ File.separator + "backimage.jpg";
		File iamge = new File(imagefile);
		Image tImgCover = Image.getInstance(iamge.getCanonicalPath());   
        /* 设置图片的位置 */  
        tImgCover.setAbsolutePosition(0, 0);  
        /* 设置图片的大小 */  
        tImgCover.scaleAbsolute(595, 842);  
        document.add(tImgCover);             //加载图片 
		
		document.close();
		
		return "print success";
	}
}
