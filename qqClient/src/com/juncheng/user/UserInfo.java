package com.juncheng.user;
/**
 * 
 * @ClassName: UserInfo  
 * @Description: ���ඨ�����û�����Ϣ
 * @author juncheng
 * @date 2018��6��6��  
 *
 */
public class UserInfo {
	private String name;//�ǳ�
	private String account;//�˺�
	private String password;//����
	private String IP;//IP��ַ
	private int port;//�˿ں�
	
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
