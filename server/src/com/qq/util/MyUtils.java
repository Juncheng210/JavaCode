package com.qq.util;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public final class MyUtils {
	private MyUtils() {};
	
	public void readUserList(String filepath) {
		SAXReader sax = new SAXReader();
		try {
			Document doc = sax.read(filepath);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void writeUserList() {
		
	}
}
