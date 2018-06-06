package com.juncheng.view;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextArea;

import com.juncheng.stream.Server2ClientStream;
import com.juncheng.user.User;

public class ServerThread implements Runnable {
	private Server2ClientStream userCS;
	private User userInfo;
	private Set<User> userSet;
	private Map<String, Server2ClientStream> userMap;
	private StringBuffer userList;
	private JTextArea hintInfo;
	private JTextArea startInfoTextArea;
	private JTextArea onlineUserInfo;

	public ServerThread(Server2ClientStream userCS, Set<User> userSet,
			Map<String, Server2ClientStream> userMap, JTextArea hintInfo, JTextArea startInfoTextArea,
			JTextArea onlineUserInfo) {
		super();
		this.userCS = userCS;
		this.userSet = userSet;
		this.userMap = userMap;
		this.hintInfo = hintInfo;
		this.startInfoTextArea = startInfoTextArea;
		this.onlineUserInfo = onlineUserInfo;
		userList = new StringBuffer();
		userInfo = new User();
	}

	@Override
	public void run() {
		while (true) {
			String message = userCS.read();
			if (message.indexOf("*#login#*") == 0) {
				userInfo.setInfo(message);
				// ��־ IP �˿ں� ���� �˺� ����
				if (userMap.containsKey(userInfo.getAccount())) {
					userCS.send("LOGIN_FIAL");
				} else if (userInfo.getName().equals("")) {
					userCS.send("NAME_IS_NULL");
				} else {
					userMap.put(userInfo.getAccount(), userCS);
					userSet.add(userInfo);
					userCS.send("LOGIN_SUCESSFULLY");
					startInfoTextArea.append("�ͻ����˺ţ�" + userInfo.getAccount() + "��½��������½�ɹ���\n");
					userList.append(userInfo.getAccount() + "&LOGIN:");
					sendCurrentUserList();
				}
			} else if (message.indexOf("%EXIT%") == 0) {
				startInfoTextArea.append("�������յ��ͻ����˺ţ�" + userInfo.getAccount() + "���˳�����...\n");
				userMap.remove(userInfo.getAccount());
				userSet.remove(userInfo);
				userList.append(userInfo.getAccount() + "&EXIT:");
				sendCurrentUserList();
				startInfoTextArea.append("����ͻ����˺ţ�" + userInfo.getAccount() + "�������û��б���Ϣ��\n");
				break;
			}
		}
		if (userCS != null) {
			userCS.close();
		}
	}

	public void sendCurrentUserList() {
		System.out.println("������ͻ��˷����û��б���Ϣ...");
		onlineUserInfo.setText("");
		for (User userInfo : userSet) {
			onlineUserInfo.append("�˺ţ�" + userInfo.getAccount() + ",���룺" + userInfo.getPassword() + ",�ǳƣ�"
					+ userInfo.getName() + ",IP��ַ��" + userInfo.getIP() + ",�˿ں�(UDP)��" + userInfo.getPort() + "\n");
			userList.append(userInfo.getIP() + "-" + userInfo.getPort() + "-" + userInfo.getAccount() + "-"
					+ userInfo.getName() + "-" + userInfo.getUserPortraitNum() + ",");
		}

		for (String string : userMap.keySet()) {
			userMap.get(string).send("%USER_LIST%:" + userList);
			startInfoTextArea.append("��������" + string + "���͵��û��б�Ϊ��%USER_LIST%:" + userList + "\n");
		}
		startInfoTextArea.append("����ͻ����˺ţ�" + userInfo.getAccount() + "�������û��б���Ϣ��\n");
		userList.delete(0, userList.length());
		printServerInfo();
		System.out.println("�Ѹ����˷�����״̬��Ϣ��");
		startInfoTextArea.append("�Ѹ����˷�����״̬��Ϣ��\n");
	}

	private void printServerInfo() {
		hintInfo.setText("��ǰ״̬����ʼ�����ͻ�������...");
		try {
			hintInfo.append("\n���������ƣ�" + InetAddress.getLocalHost().getHostName());
			hintInfo.append("\n������IP��ַ��" + InetAddress.getLocalHost().getHostAddress());
			hintInfo.append("\n�����˿ڣ�9000");
			hintInfo.append("\n��ǰ����������" + userMap.size());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
