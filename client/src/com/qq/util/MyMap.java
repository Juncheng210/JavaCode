package com.qq.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyMap {
	private Map<String, String[]> userList;
	
	public MyMap() {
		userList = new LinkedHashMap<String, String[]>();
	}
	
	public MyMap(String groupName, String username, String nickname) {
		String[] srts = {username, nickname};
		userList = new LinkedHashMap<String, String[]>();
		userList.put(groupName, srts);
	}
}
