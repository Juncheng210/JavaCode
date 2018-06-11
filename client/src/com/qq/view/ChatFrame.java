package com.qq.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.qq.stream.ConnectionStream;
import com.qq.user.UserInfo;

public class ChatFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextArea messageArea, inputArea;
	private JButton btn1, btn2, btn3, btn4, send;
	
	private SimpleDateFormat simpleDateFormat;
	
	private Socket socket;
	private String friendUsername;
	private String username;
	private UserInfo userInfo;
	private ConnectionStream connection;
	
	public ChatFrame(Socket socket, UserInfo userInfo, String friendUsername, ConnectionStream connection) {
		this.socket = socket;
		this.userInfo = userInfo;
		this.friendUsername = friendUsername;
		this.connection = connection;
		
		simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		createFrame();
		addEventHandler();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				String str = "";
				while(true) {
					str = connection.read();
					System.out.println(str);
				}
			}
		}).start();
	}
	
	private void createFrame() {
		setTitle("正在与"+friendUsername+"聊天...");
		setLayout(null);
		
		messageArea = new JTextArea();
		messageArea.setBounds(10, 10, 615, 350);
		messageArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(messageArea);
		scrollPane.setBounds(10, 10, 615, 330);
		
		inputArea = new JTextArea();
		inputArea.setBounds(10, 350, 615, 100);
		
		btn1 = new JButton("截屏");
		btn1.setBounds(10, 460, 100, 30);
		btn2 = new JButton("发送文件");
		btn2.setBounds(130, 460, 100, 30);
		btn3 = new JButton("窗口抖动");
		btn3.setBounds(250, 460, 100, 30);
		btn4 = new JButton("关闭");
		btn4.setBounds(370, 460, 100, 30);
		send = new JButton("发送");
		send.setBounds(500, 460, 120, 30);
		send.setBackground(new Color(30, 144, 255));
		send.setForeground(Color.white);
		
		add(scrollPane);
		add(inputArea);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(send);
		setSize(650, 540);
		//窗口居中显示
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int height = getHeight();
		int width = getWidth();
		int screenWidth = screenSize.width / 2;
		int screenHeight = screenSize.height / 2;
		setLocation(screenWidth - width / 2, screenHeight - height / 2);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String message = inputArea.getText();
		if (message == null || message.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "不能发送空消息！");
		} else {
			String time = simpleDateFormat.format(new Date());
			if(connection != null) {
				connection.send(userInfo.getNickname()+"("+userInfo.getUsername()+")-"+time+"-"+message);
				messageArea.append("我  "+time+"\n"+message+"\n");
			}
			inputArea.setText("");
		}
	}
	
	private void addEventHandler() {
		send.addActionListener(this);
		
	}
}
