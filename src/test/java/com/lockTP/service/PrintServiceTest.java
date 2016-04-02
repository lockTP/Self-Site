package com.lockTP.service;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itextpdf.text.DocumentException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class PrintServiceTest {

	@Autowired
	PrintService printService;
	
	@Test
	public void testPrintByInput() throws DocumentException, IOException {
		FileOutputStream os = new FileOutputStream("output/letter.pdf");
		printService.printByInput("aa", "contentcontentcontent", "bb", os);
		assertEquals(1, 1);
	}
	
	@Test
	public void testPrintQuestion() throws DocumentException, IOException {
		printService.createQuestion();
		assertEquals(1, 1);
	}

}
