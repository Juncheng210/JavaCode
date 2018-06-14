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
					if(userMap.containsKey(userInfo.getUsername())) {
						connection.send("LOGIN_FAIL");
						break;
					} else {
						userMap.put(userInfo.getUsername(), connection);
						userSet.add(userInfo);
						connection.send("LOGIN_SUCCESSFULLY");
						runInfo.append("�û�" + userInfo.getUsername() + "��¼�������ɹ���\n");
						connection.sendObject(MyUtils.readUserList(userInfo.getUsername()));
						sendUserList();
					}
				} else {
					connection.send("ERROR");
				}
			} else if(message.equals("*#EXIT#*")) {
				runInfo.append("�յ��û� " + userInfo.getUsername() + " ���˳�����...\n");
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
	 * @Description: ���ļ��ж�ȡ�û��б���Ϣ
	 * @param     ����  
	 * @return void    ��������
	 */
	public void sendUserList() {
		System.out.println("�������û������б���Ϣ...");
		onlineUserInfo.setText("");
		UserInfo userList = MyUtils.readUserList(userInfo.getUsername());
		for (UserInfo userInfo : userSet) {
			onlineUserInfo.append("�û���"+userInfo.getUsername()+"��IP��"+userInfo.getIp()+"\n");
		}
		connection.sendObject(userList);
		runInfo.append("�����û� " + userInfo.getUsername() + " �������û��б���Ϣ��\n");
		
		printServerInfo();
		System.out.println("�Ѹ����˷�����״̬��Ϣ��");
		runInfo.append("�Ѹ����˷�����״̬��Ϣ��\n");
	}
	
	/**
	 * @Title: printServerInfo  
	 * @Description: ��ӡ��������Ӧ����Ϣ
	 * @param     ����  
	 * @return void    ��������
	 */
	private void printServerInfo() {
		stateInfo.setText("��ǰ״̬����ʼ�����ͻ�������...");
		try {
			stateInfo.append("\n���������ƣ�" + InetAddress.getLocalHost().getHostName());
			stateInfo.append("\n������IP��ַ��" + InetAddress.getLocalHost().getHostAddress());
			stateInfo.append("\n�����˿ڣ�8888");
			stateInfo.append("\n��ǰ����������" + userMap.size());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
