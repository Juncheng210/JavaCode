package com.juncheng.user;
/**
 * 
 * @ClassName: UserInfo  
 * @Description: 该类定义了用户的信息
 * @author juncheng
 * @date 2018年6月6日  
 *
 */
public class UserInfo {
	private String name;//昵称
	private String account;//账号
	private String password;//密码
	private String IP;//IP地址
	private int port;//端口号
	
	public UserInfo() {
		
	}
	public UserInfo(String name, String account, String password, String iP, int port) {
		this.name = name;
		this.account = account;
		this.password = password;
		this.IP = iP;
		this.port = port;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
