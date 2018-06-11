package com.qq.util;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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
			userFriends.setUsername(user.attributeValue("username"));
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
	
	public void writeUserList() {
		
	}
}
