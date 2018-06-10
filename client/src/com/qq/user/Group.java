package com.qq.user;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	private String groupName;
	private Map<String, String> friendsMap;
	
	public Group(String groupName) {
		this.groupName = groupName;
		friendsMap = new LinkedHashMap<String, String>();
	}
	
	public Group(String friendUserName, String friendNickName) {
		friendsMap = new LinkedHashMap<String, String>();
		friendsMap.put(friendUserName, friendNickName);
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Map<String, String> getFriendsMap() {
		return friendsMap;
	}

	public void setFriendsMap(Map<String, String> friendsMap) {
		this.friendsMap = friendsMap;
	}
	
}
