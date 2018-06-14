package com.qq.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.qq.stream.ConnectionStream;
import com.qq.thread.ServerThread;
import com.qq.user.UserInfo;

public class ServerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea stateInfo;//服务器状态
	private JTextArea runInfo;//服务器运行信息
	private JTextArea onlineUserInfo;//在线用户信息
	private JButton start;//启动服务器按钮
	
	private Map<String, ConnectionStream> userMap;//存放在线用户及流传输信息
	private Set<UserInfo> userSet;//存放用户信息
	private ServerSocket serverSocket;
	
	
	public ServerFrame() {
		userMap = new HashMap<String, ConnectionStream>();
		userSet = new HashSet<UserInfo>();
		createFrame();
		addEventHandler();
	}
	/**
	 * @Title: createFrame  
	 * @Description: 创建服务器的可视化管理界面
	 * @param     参数  
	 * @return void    返回类型
	 */
	private void createFrame() {
		JPanel jPanel = new JPanel();
		
		JLabel jLabel = new JLabel("服务器界面");
		jPanel.add(jLabel);
		
		stateInfo = new JTextArea("当前状态：服务器未启动！\n");
		runInfo = new JTextArea();
		onlineUserInfo = new JTextArea();
		stateInfo.setEditable(false);
		runInfo.setEditable(false);
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
	/**
	 * @Title: addEventHandler  
	 * @Description: 事件监听及处理
	 * @param     参数  
	 * @return void    返回类型
	 */
	private void addEventHandler() {
		/**
		 * 启动按钮的事件监听及处理
		 */
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					serverSocket = new ServerSocket(8888);
					new Thread(new Runnable() {
						@Override
						public void run() {
							startServer();
						}
					}).start();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		/**
		 * 关闭窗口的监听及处理
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int quit = JOptionPane.showConfirmDialog(null, "确认退出服务器吗？", "是否退出", JOptionPane.OK_CANCEL_OPTION);
				if(quit == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	/**
	 * @Title: startServer  
	 * @Description: 启动服务器
	 * @param     参数  
	 * @return void    返回类型
	 */
	private void startServer() {
		while(true) {
			System.out.println("开始监听客户端连接...");
			runInfo.append("开始监听客户端连接...\n");
			printServerInfo();
			try {
				Socket socket = serverSocket.accept();
				runInfo.append("已从客户端（" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "）接收到数据...\n");
				new Thread(new ServerThread(new ConnectionStream(socket), userSet, userMap, stateInfo, runInfo, onlineUserInfo)).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
