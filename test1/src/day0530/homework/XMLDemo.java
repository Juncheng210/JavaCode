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
 * @Description: DOM4J解析XML实例练习
 * @author Administrator  
 * @date 2018年5月30日  
 *
 */
public final class XMLDemo {
	/**
	 * @Title: addUserMsg  
	 * @Description: 添加学生
	 * @param @param filepath    参数  
	 * @return void    返回类型
	 */
	public static void addUserMsg(String filepath) {
		SAXReader sax = new SAXReader();
		Scanner sc = new Scanner(System.in);
		
		try {
			Document doc = sax.read(filepath);
			Element root = doc.getRootElement();
			Element student = root.addElement("student");
			
			System.out.print("请输入学生姓名：");
			String name = sc.next();
			
			System.out.print("请输入学生身份证号：");
			String idcard = sc.next();
			
			System.out.print("请输入学生准考证号：");
			String examid = sc.next();
			
			System.out.print("请输入学生所在地：");
			String add = sc.next();
			
			System.out.print("请输入学生成绩：");
			String grade = sc.next();
			
			student.addElement("name").setText(name);
			student.addAttribute("idcard", idcard);
			student.addAttribute("examid", examid);
			student.addElement("location").setText(add);
			student.addElement("grade").setText(grade);
			
			System.out.println("------添加数据成功-------");
			createXML(doc, filepath);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Title: deleteUserMsg  
	 * @Description: 删除学生信息
	 * @param @param filepath    参数  
	 * @return void    返回类型
	 */
	public static void deleteUserMsg(String filepath) {
		SAXReader sax = new SAXReader();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("请输入删除的学生姓名：");
		String input = sc.next();
		
		try {
			Document doc = sax.read(filepath);
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			boolean flag = false;
			for (Element ele : list) {
				if(flag=((Element)ele.elements().get(0)).getText().equals(input)) {
					root.remove(ele);
					System.out.println("-------"+((Element)ele.elements().get(0)).getStringValue()+"删除成功-------");
					break;
				}
			}
			createXML(doc, filepath);
			if(!flag) {
				System.out.println("-------查无此人，请重试-------");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Title: queryUserMsg  
	 * @Description: 查询学生信息
	 * @param @param filepath    参数  
	 * @return void    返回类型
	 */
	public static void queryUserMsg(String filepath) {
		SAXReader sax = new SAXReader();
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		System.out.print("请输入要查询学生的准考证号：");
		String input = sc.next();
		
		try {
			Document doc = sax.read(filepath);
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			boolean flag = false;
			for (Element ele : list) {
				if(flag=ele.attributeValue("examid").equals(input)) {
					System.out.println("您查询的学生信息为：");
					List<Element> stu = ele.elements();
					sb.append("姓名："+stu.get(0).getText());
					sb.append("，身份号："+ele.attributeValue("idcard"));
					sb.append("，准考证号："+ele.attributeValue("examid"));
					sb.append("，地区："+stu.get(1).getText());
					sb.append("，成绩："+stu.get(2).getText());
					System.out.println(sb);
					break;
				}
			}
			if(!flag) {
				System.out.println("-------查无此人，请重试-------");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Title: createXML  
	 * @Description: 操作结束后重新写入文件
	 * @param @param doc
	 * @param @param filepath    参数  
	 * @return void    返回类型
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
