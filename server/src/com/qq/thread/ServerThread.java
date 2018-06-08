package com.qq.thread;

import java.util.Map;
import java.util.Set;

import javax.swing.JTextArea;

import com.qq.stream.ConnectionStream;
import com.qq.user.UserInfo;
import com.qq.util.LoginAndRegister;

public class ServerThread implements Runnable {
	private JTextArea stateInfo;//服务器状态
	private JTextArea runInfo;//服务器运行信息
	private JTextArea onlineUserInfo;//在线用户信息
	private UserInfo userInfo;
	private Map<String, ConnectionStream> userMap;//存放用户名及流传输信息
	private Set<UserInfo> userSet;//存放用户信息
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
					runInfo.append("用户" + userInfo.getUsername() + "登录服务器成功！\n");
				} else if(userMap.containsKey(userInfo.getUsername())) {
					connection.send("LOGIN_FAIL");
				}
			} else if(message.startsWith("*#EXIT#*")) {
				runInfo.append("收到用户 " + userInfo.getUsername() + " 的退出请求...\n");
				userMap.remove(userInfo.getUsername());
				userSet.remove(userInfo);
				
				runInfo.append("已向用户 " + userInfo.getUsername() + " 发送了用户列表消息！\n");
				break;
			}
		}
	}
	
	public void sendUserList() {
		System.out.println("正在向用户发送列表消息...");
	}
}
