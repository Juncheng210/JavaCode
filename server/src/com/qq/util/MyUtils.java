package com.qq.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.qq.user.Group;
import com.qq.user.UserInfo;

public final class MyUtils {
	private MyUtils() {};
	
	public static UserInfo readUserList(String username) {
		UserInfo userFriends = new UserInfo();
		SAXReader sax = new SAXReader();
		try {
			Document doc = sax.read("src/com/qq/resources/userlist/"+username+".xml");
			Element user = doc.getRootElement();
			userFriends.setUsername(username);
			userFriends.setNickname(user.attributeValue("nickname"));
			List<Element> groups = user.selectNodes("//user//group");
			for (Element group : groups) {
				Group g = new Group(group.attributeValue("name"));
				userFriends.groupList.add(g);
				List<Element> persons = group.elements();
				for (Element person : persons) {
					g.getFriendsMap().put(person.attributeValue("username"), person.getTextTrim());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return userFriends;
	}
	
	public static void writeUserList(String username) {
		// 创建Document对象
        Document doc = DocumentHelper.createDocument();
        // 创建根节点
        Element user = doc.addElement("user");
        user.addAttribute("userneme", "username");
        // 创建group子节点
        Element group = user.addElement("group");
        group.addAttribute("name", "我的好友");
        group.setText("");
        
        createXML(doc, "src/com/qq/resources/userlist/"+username+".xml");
	}
	
	public static void updateFriendNickname(String username, String message) {
		SAXReader sax = new SAXReader();
		Document doc;
		try {
			doc = sax.read("src/com/qq/resources/userlist/"+username+".xml");
			Element user = doc.getRootElement();
			String str1 = message.split("[()]")[0];
			String str2 = message.split("[()]")[1];
			List<Element> persons = user.selectNodes("//person[@username='"+str2+"']");
			for (Element person : persons) {
				person.setText(str1);
			}
			createXML(doc, "src/com/qq/resources/userlist/"+username+".xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void createXML(Document doc, String filepath) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setIndent("\t");
		format.setEncoding("UTF-8");
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
