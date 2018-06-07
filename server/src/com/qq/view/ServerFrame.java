package com.qq.view;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.qq.stream.Server2ClientStream;
import com.qq.user.UserInfo;

public class ServerFrame extends JFrame {
	private JTextArea stateInfo;//������״̬
	private JTextArea runInfo;//������������Ϣ
	private JTextArea onlineUserInfo;//�����û���Ϣ
	private JButton start;//������������ť
	
	private Map<String, Server2ClientStream> userMap;//��������û�����������Ϣ
	private Set<UserInfo> userSet;
	private ServerSocket serverSocket;
	
	
	public ServerFrame() {
		createFrame();
	}
	
	private void createFrame() {
		JPanel jPanel = new JPanel();
		
		JLabel jLabel = new JLabel("����������");
		jPanel.add(jLabel);
		
		stateInfo = new JTextArea("��ǰ״̬��������δ������\n");
		runInfo = new JTextArea();
		onlineUserInfo = new JTextArea();
		stateInfo.setEditable(false);
		runInfo.setEnabled(false);
		onlineUserInfo.setEditable(false);
		
		//����һ��ѡ�
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
		JScrollPane stateInfoPane = new JScrollPane(stateInfo);
		JScrollPane runInfoPane = new JScrollPane(runInfo);
		JScrollPane onlineUserInfoPane = new JScrollPane(onlineUserInfo);
		
		tabPane.add("������״̬", stateInfoPane);
		tabPane.add("��������", runInfoPane);
		tabPane.add("�����û�����", onlineUserInfoPane);
		
		start = new JButton("����������");
		JPanel southPanel = new JPanel();
		southPanel.add(start);
		
		add(jPanel, BorderLayout.NORTH);
		add(tabPane, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
	private void startServer() {
		while(true) {
			System.out.println("��ʼ�����ͻ�������...");
			runInfo.append("��ʼ�����ͻ�������...\n");
			printServerInfo();
			try {
				Socket socket = serverSocket.accept();
				runInfo.append("�Ѵӿͻ��ˣ�" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "�����յ�����...\n");
				new Thread(new ServerThread()).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
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
