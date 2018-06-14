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
	private JTextArea stateInfo;//������״̬
	private JTextArea runInfo;//������������Ϣ
	private JTextArea onlineUserInfo;//�����û���Ϣ
	private JButton start;//������������ť
	
	private Map<String, ConnectionStream> userMap;//��������û�����������Ϣ
	private Set<UserInfo> userSet;//����û���Ϣ
	private ServerSocket serverSocket;
	
	
	public ServerFrame() {
		userMap = new HashMap<String, ConnectionStream>();
		userSet = new HashSet<UserInfo>();
		createFrame();
		addEventHandler();
	}
	/**
	 * @Title: createFrame  
	 * @Description: �����������Ŀ��ӻ��������
	 * @param     ����  
	 * @return void    ��������
	 */
	private void createFrame() {
		JPanel jPanel = new JPanel();
		
		JLabel jLabel = new JLabel("����������");
		jPanel.add(jLabel);
		
		stateInfo = new JTextArea("��ǰ״̬��������δ������\n");
		runInfo = new JTextArea();
		onlineUserInfo = new JTextArea();
		stateInfo.setEditable(false);
		runInfo.setEditable(false);
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
	/**
	 * @Title: addEventHandler  
	 * @Description: �¼�����������
	 * @param     ����  
	 * @return void    ��������
	 */
	private void addEventHandler() {
		/**
		 * ������ť���¼�����������
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
		 * �رմ��ڵļ���������
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int quit = JOptionPane.showConfirmDialog(null, "ȷ���˳���������", "�Ƿ��˳�", JOptionPane.OK_CANCEL_OPTION);
				if(quit == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	/**
	 * @Title: startServer  
	 * @Description: ����������
	 * @param     ����  
	 * @return void    ��������
	 */
	private void startServer() {
		while(true) {
			System.out.println("��ʼ�����ͻ�������...");
			runInfo.append("��ʼ�����ͻ�������...\n");
			printServerInfo();
			try {
				Socket socket = serverSocket.accept();
				runInfo.append("�Ѵӿͻ��ˣ�" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "�����յ�����...\n");
				new Thread(new ServerThread(new ConnectionStream(socket), userSet, userMap, stateInfo, runInfo, onlineUserInfo)).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
