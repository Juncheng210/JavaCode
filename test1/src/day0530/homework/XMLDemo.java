package day0530.homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 
 * @ClassName: XMLDemo  
 * @Description: DOM4J����XMLʵ����ϰ
 * @author Administrator  
 * @date 2018��5��30��  
 *
 */
public final class XMLDemo {
	/**
	 * @Title: addUserMsg  
	 * @Description: ����ѧ��
	 * @param @param filepath    ����  
	 * @return void    ��������
	 */
	public static void addUserMsg(String filepath) {
		SAXReader sax = new SAXReader();
		Scanner sc = new Scanner(System.in);
		
		try {
			Document doc = sax.read(filepath);
			Element root = doc.getRootElement();
			Element student = root.addElement("student");
			
			System.out.print("������ѧ��������");
			String name = sc.next();
			
			System.out.print("������ѧ������֤�ţ�");
			String idcard = sc.next();
			
			System.out.print("������ѧ��׼��֤�ţ�");
			String examid = sc.next();
			
			System.out.print("������ѧ�����ڵأ�");
			String add = sc.next();
			
			System.out.print("������ѧ���ɼ���");
			String grade = sc.next();
			
			student.addElement("name").setText(name);
			student.addAttribute("idcard", idcard);
			student.addAttribute("examid", examid);
			student.addElement("location").setText(add);
			student.addElement("grade").setText(grade);
			
			System.out.println("------�������ݳɹ�-------");
			createXML(doc, filepath);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Title: deleteUserMsg  
	 * @Description: ɾ��ѧ����Ϣ
	 * @param @param filepath    ����  
	 * @return void    ��������
	 */
	public static void deleteUserMsg(String filepath) {
		SAXReader sax = new SAXReader();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ɾ����ѧ��������");
		String input = sc.next();
		
		try {
			Document doc = sax.read(filepath);
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			boolean flag = false;
			for (Element ele : list) {
				if(flag=((Element)ele.elements().get(0)).getText().equals(input)) {
					root.remove(ele);
					System.out.println("-------"+((Element)ele.elements().get(0)).getStringValue()+"ɾ���ɹ�-------");
					break;
				}
			}
			createXML(doc, filepath);
			if(!flag) {
				System.out.println("-------���޴��ˣ�������-------");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Title: queryUserMsg  
	 * @Description: ��ѯѧ����Ϣ
	 * @param @param filepath    ����  
	 * @return void    ��������
	 */
	public static void queryUserMsg(String filepath) {
		SAXReader sax = new SAXReader();
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		System.out.print("������Ҫ��ѯѧ����׼��֤�ţ�");
		String input = sc.next();
		
		try {
			Document doc = sax.read(filepath);
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			boolean flag = false;
			for (Element ele : list) {
				if(flag=ele.attributeValue("examid").equals(input)) {
					System.out.println("����ѯ��ѧ����ϢΪ��");
					List<Element> stu = ele.elements();
					sb.append("������"+stu.get(0).getText());
					sb.append("�����ݺţ�"+ele.attributeValue("idcard"));
					sb.append("��׼��֤�ţ�"+ele.attributeValue("examid"));
					sb.append("��������"+stu.get(1).getText());
					sb.append("���ɼ���"+stu.get(2).getText());
					System.out.println(sb);
					break;
				}
			}
			if(!flag) {
				System.out.println("-------���޴��ˣ�������-------");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Title: createXML  
	 * @Description: ��������������д���ļ�
	 * @param @param doc
	 * @param @param filepath    ����  
	 * @return void    ��������
	 */
	private static void createXML(Document doc, String filepath) {
//		OutputFormat format = new OutputFormat("	", true);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndent("\t");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(filepath),format);
			writer.write(doc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}