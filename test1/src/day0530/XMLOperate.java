package day0530;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public final class XMLOperate {
	public static void queryXML(String filepath) {
		SAXReader sax = new SAXReader();
		
		try {
			Document doc = sax.read("src/day0530/class.xml");
			Element root = doc.getRootElement();
			Iterator<Element> ite = root.elementIterator();
			while(ite.hasNext()) {
				Element stu = ite.next();
				List<Element> list = stu.elements();
				for (Element ele : list) {
					System.out.println(ele.getName()+"��"+ele.getStringValue());
				}
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Student> XML2List() {
		List<Student> list = new ArrayList<Student>();
		SAXReader sax = new SAXReader();
	
		return list;
	}
}
