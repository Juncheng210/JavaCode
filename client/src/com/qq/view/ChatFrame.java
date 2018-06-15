package com.qq.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class ChatFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea messageArea, inputArea;
	private JButton btn1, btn2, btn3, close, send;
	
	private SimpleDateFormat simpleDateFormat;
	
	private Socket socket;
	private String friendUsername;
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
					if(str.startsWith("*#CHAT_EXIT#*")) {
						break;
					}
					System.out.println(str);
					if(str.equals("FRIEND_IS_NOT_ONLINE")) {
						JOptionPane.showMessageDialog(null, "对方当前不在线！");
					} else {
						String[] strs = str.replaceAll("\\*##\\*", "\n").split("-");
						messageArea.append(strs[0]+"  "+strs[1]+"\n"+strs[2]);
					}
				}
			}
		}).start();
	}
	
	/**
	 * @Title: createFrame  
	 * @Description: 绘制窗口
	 * @param     参数  
	 * @return void    返回类型
	 */
	private void createFrame() {
		setTitle("正在与"+friendUsername+"聊天...");
		setLayout(null);
		
		messageArea = new JTextArea();//显示信息
		messageArea.setBounds(10, 10, 615, 350);
		messageArea.setEditable(false);//设置不可编辑
		messageArea.setCaretPosition(messageArea.getText().length());//设置显示最后一行文本
		
		JScrollPane scrollPane = new JScrollPane(messageArea);
		scrollPane.setBounds(10, 10, 615, 330);
		
		inputArea = new JTextArea();//输入信息
		inputArea.setBounds(10, 350, 615, 100);
		
		btn1 = new JButton("截屏");
		btn1.setBounds(10, 460, 100, 30);
		btn2 = new JButton("发送文件");
		btn2.setBounds(130, 460, 100, 30);
		btn3 = new JButton("窗口抖动");
		btn3.setBounds(250, 460, 100, 30);
		close = new JButton("关闭");
		close.setBounds(370, 460, 100, 30);
		close.setBackground(new Color(255, 84, 57));
		close.setForeground(Color.white);
		send = new JButton("发送");
		send.setBounds(500, 460, 120, 30);
		send.setBackground(new Color(30, 144, 255));
		send.setForeground(Color.white);
		
		add(scrollPane);
		add(inputArea);
		add(btn1);
		add(btn2);
		add(btn3);
		add(close);
		add(send);
		setSize(650, 540);
		setResizable(false);
		//窗口居中显示
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int height = getHeight();
		int width = getWidth();
		int screenWidth = screenSize.width / 2;
		int screenHeight = screenSize.height / 2;
		setLocation(screenWidth - width / 2, screenHeight - height / 2);
		
		setVisible(true);
	}
	
	/**
	 * @Title: addEventHandler  
	 * @Description: 此方法用来监听事件
	 * @param     参数  
	 * @return void    返回类型
	 */
	private void addEventHandler() {
		//发送按钮的事件
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = inputArea.getText()+"\n";
				if (message == null || message.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "不能发送空消息！");
				} else {
					String time = simpleDateFormat.format(new Date());
					if(connection != null) {
						messageArea.append("我  "+time+"\n"+message);
						message = message.replaceAll("\n", "\\*##\\*");
						connection.send("*#CHAT#*-"+friendUsername+"-"+userInfo.getNickname()+"("+userInfo.getUsername()+")-"+time+"-"+message);
					}
					inputArea.setText("");
				}
			}
		});
		//关闭按钮的事件
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connection.send("*#CHAT_EXIT#*");
				dispose();
			}
		});
		//默认关闭事件
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				connection.send("*#CHAT_EXIT#*");
				dispose();
			}
		});
	}
}
