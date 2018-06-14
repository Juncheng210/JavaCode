package com.qq.thread;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextArea;

import com.qq.stream.ConnectionStream;
import com.qq.user.UserInfo;
import com.qq.util.LoginAndRegister;
import com.qq.util.MyUtils;

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
					if(userMap.containsKey(userInfo.getUsername())) {
						connection.send("LOGIN_FAIL");
						break;
					} else {
						userMap.put(userInfo.getUsername(), connection);
						userSet.add(userInfo);
						connection.send("LOGIN_SUCCESSFULLY");
						runInfo.append("用户" + userInfo.getUsername() + "登录服务器成功！\n");
						connection.sendObject(MyUtils.readUserList(userInfo.getUsername()));
						sendUserList();
					}
				} else {
					connection.send("ERROR");
				}
			} else if(message.equals("*#EXIT#*")) {
				runInfo.append("收到用户 " + userInfo.getUsername() + " 的退出请求...\n");
				userMap.remove(userInfo.getUsername());
				userSet.remove(userInfo);
				printServerInfo();
				break;
			} else if(message.startsWith("*#UPDATE_NICK#*-")) {
				MyUtils.updateFriendNickname(userInfo.getUsername(), message.substring(16, message.length()));
			} else if(message.startsWith("*#REGISTER#*-")) {
				if(LoginAndRegister.register(message.split("-")[1], message.split("-")[3])) {
					MyUtils.writeUserList(message.split("-")[1]+"-"+message.split("-")[2]);
					connection.send("REGISTER_SUCCESSFULLY");
				} else {
					connection.send("REGISTER_FAIL");
				}
			} else if(message.startsWith("*#CHAT#*-")) {
				if(message.startsWith("*#CHAT_EXIT#*")) {
					connection.send(message);
					break;
				} else {
					String[] strs = message.split("-");
					int count = 0;
					String friendUsername = strs[1].split("[()]")[1];
					for(String s : userMap.keySet()) {
						if(s.equals(friendUsername)) {
							userMap.get(s).send(message.substring(9+friendUsername.length(), message.length()));
							break;
						}
						count++;
					}
					if(count==userMap.size()) {
						connection.send("FRIEND_IS_NOT_ONLINE");
					}
				}
			}
		}
	}
	
	/**
	 * @Title: sendUserList  
	 * @Description: 从文件中读取用户列表信息
	 * @param     参数  
	 * @return void    返回类型
	 */
	public void sendUserList() {
		System.out.println("正在向用户发送列表消息...");
		onlineUserInfo.setText("");
		UserInfo userList = MyUtils.readUserList(userInfo.getUsername());
		for (UserInfo userInfo : userSet) {
			onlineUserInfo.append("用户："+userInfo.getUsername()+"，IP："+userInfo.getIp()+"\n");
		}
		connection.sendObject(userList);
		runInfo.append("已向用户 " + userInfo.getUsername() + " 发送了用户列表消息！\n");
		
		printServerInfo();
		System.out.println("已更新了服务器状态信息！");
		runInfo.append("已更新了服务器状态信息！\n");
	}
	
	/**
	 * @Title: printServerInfo  
	 * @Description: 打印服务器对应的信息
	 * @param     参数  
	 * @return void    返回类型
	 */
	private void printServerInfo() {
		stateInfo.setText("当前状态：开始监听客户端连接...");
		try {
			stateInfo.append("\n服务器名称：" + InetAddress.getLocalHost().getHostName());
			stateInfo.append("\n服务器IP地址：" + InetAddress.getLocalHost().getHostAddress());
			stateInfo.append("\n监听端口：8888");
			stateInfo.append("\n当前在线人数：" + userMap.size());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
