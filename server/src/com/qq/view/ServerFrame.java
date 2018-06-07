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
	private JTextArea stateInfo;//服务器状态
	private JTextArea runInfo;//服务器运行信息
	private JTextArea onlineUserInfo;//在线用户信息
	private JButton start;//启动服务器按钮
	
	private Map<String, Server2ClientStream> userMap;//存放在线用户及流传输信息
	private Set<UserInfo> userSet;
	private ServerSocket serverSocket;
	
	
	public ServerFrame() {
		createFrame();
	}
	
	private void createFrame() {
		JPanel jPanel = new JPanel();
		
		JLabel jLabel = new JLabel("服务器界面");
		jPanel.add(jLabel);
		
		stateInfo = new JTextArea("当前状态：服务器未启动！\n");
		runInfo = new JTextArea();
		onlineUserInfo = new JTextArea();
		stateInfo.setEditable(false);
		runInfo.setEnabled(false);
		onlineUserInfo.setEditable(false);
		
		//创建一个选项卡
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
		JScrollPane stateInfoPane = new JScrollPane(stateInfo);
		JScrollPane runInfoPane = new JScrollPane(runInfo);
		JScrollPane onlineUserInfoPane = new JScrollPane(onlineUserInfo);
		
		tabPane.add("服务器状态", stateInfoPane);
		tabPane.add("运行详情", runInfoPane);
		tabPane.add("在线用户详情", onlineUserInfoPane);
		
		start = new JButton("启动服务器");
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
			System.out.println("开始监听客户端连接...");
			runInfo.append("开始监听客户端连接...\n");
			printServerInfo();
			try {
				Socket socket = serverSocket.accept();
				runInfo.append("已从客户端（" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "）接收到数据...\n");
				new Thread(new ServerThread()).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
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
