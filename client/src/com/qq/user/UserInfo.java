package com.qq.user;

public class UserInfo {
	private String username;//�û���
	private String nickname;//�ǳ�
	private String password;//����
	private String ip;//ip��ַ
	private int port;//�˿ں�
	
	public UserInfo() {
		
	}

	public UserInfo(String username, String nickname, String password, String ip, int port) {
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.ip = ip;
		this.port = port;
	}
	
	public UserInfo setUserInfo(String message) {
		
		
		return this;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
