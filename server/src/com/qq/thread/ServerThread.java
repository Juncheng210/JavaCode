package com.qq.thread;

import java.util.Map;
import java.util.Set;

import javax.swing.JTextArea;

import com.qq.stream.ConnectionStream;
import com.qq.user.UserInfo;
import com.qq.util.LoginAndRegister;

public class ServerThread implements Runnable {
	private JTextArea stateInfo;//������״̬
	private JTextArea runInfo;//������������Ϣ
	private JTextArea onlineUserInfo;//�����û���Ϣ
	private UserInfo userInfo;
	private Map<String, ConnectionStream> userMap;//����û�������������Ϣ
	private Set<UserInfo> userSet;//����û���Ϣ
	private ConnectionStream connection;
	
	public ServerThread(ConnectionStream connection, Set<UserInfo> userSet, Map<String, ConnectionStream> userMap, JTextArea stateInfo, JTextArea runInfo, JTextArea onlineUserInfo) {
		this.connection = connection;
		this.userSet = userSet;
		this.userMap = userMap;
		this.stateInfo = stateInfo;
		this.runInfo = runInfo;
		this.onlineUserInfo = onlineUserInfo;
		userInfo = new UserInfo();
	}
	
	@Override
	public void run() {
		while(true) {
			String message = connection.read();
			if(message.startsWith("*#LOGIN#*")) {
				userInfo.setUserInfo(message);
				if(LoginAndRegister.loginCheck(userInfo.getUsername(), message.split("-")[4])) {
					userMap.put(userInfo.getUsername(), connection);
					userSet.add(userInfo);
					connection.send("LOGIN_SUCCESSFUL");
					runInfo.append("�û�" + userInfo.getUsername() + "��¼�������ɹ���\n");
				} else if(userMap.containsKey(userInfo.getUsername())) {
					connection.send("LOGIN_FAIL");
				}
			} else if(message.startsWith("*#EXIT#*")) {
				runInfo.append("�յ��û� " + userInfo.getUsername() + " ���˳�����...\n");
				userMap.remove(userInfo.getUsername());
				userSet.remove(userInfo);
				
				runInfo.append("�����û� " + userInfo.getUsername() + " �������û��б���Ϣ��\n");
				break;
			}
		}
	}
	
	public void sendUserList() {
		System.out.println("�������û������б���Ϣ...");
	}
}
