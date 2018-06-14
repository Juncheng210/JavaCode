package com.qq.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.qq.stream.ConnectionStream;
import com.qq.user.UserInfo;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel register;//注册
	private JLabel findPassword;//找回密码
	private JCheckBox rememberPassword, autoLogin;//记住密码，自动登录
	private JTextField accountField;//账号文本框
	private JPasswordField passwordField;//密码文本框
	private JPanel jPanel1, jPanel2, jPanel3;
	private JButton login;//登录按钮
	
	private String nickname;
	private Socket socket;
	private UserInfo userInfo;
	private static final int SERVER_PORT = 8888;
	private InetAddress localAddress;
	
	private ConnectionStream connection;
	private String message;
	
	public LoginFrame() {
		createFrame();
		addHandlerEvent();
	}
	
	/**
	 * @Title: createFrame  
	 * @Description: 绘制窗口
	 * @param     参数  
	 * @return void    返回类型
	 */
	private void createFrame() {
		//窗口基础操作设置
		setTitle("登录");
		setSize(420, 360);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int height = getHeight();
		int width = getWidth();
		int screenWidth = screenSize.width / 2;
		int screenHeight = screenSize.height / 2;
		setLocation(screenWidth - width / 2, screenHeight - height / 2);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//设置背景图片
		ImageIcon backgroundImg = new ImageIcon("src/com/qq/resources/background.jpg");
		JLabel imgLable = new JLabel(backgroundImg);
		//设置默认头像
		ImageIcon iconImg = new ImageIcon("src/com/qq/resources/logo.png");
		iconImg.setImage(iconImg.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		JLabel iconImgLable = new JLabel(iconImg);
		//操作区域
		JPanel operLayout = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		//创建账号和密码框
		accountField = new JTextField(15);
		passwordField = new JPasswordField(15);
		
		JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		jPanel.add(imgLable);
		JPanel accRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		JPanel passRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		JPanel accPassHintPanel = new JPanel(new GridLayout(3, 15, 0, 0));
		//注册账号
		register = new JLabel("注册账号");
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.setForeground(Color.BLUE);
		//找回密码
		findPassword = new JLabel("找回密码");
		findPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findPassword.setForeground(Color.BLUE);
		//记住密码
		rememberPassword = new JCheckBox("记住密码");
		//自动登录
		autoLogin = new JCheckBox("自动登录");
		//登录按钮
		login = new JButton("安全登录");
		login.setBackground(new Color(30, 144, 255));
		login.setForeground(Color.WHITE);
		login.setPreferredSize(new Dimension(170, 30));
		
		accRes.add(accountField);
		accRes.add(register);
		
		passRes.add(passwordField);
		passRes.add(findPassword);
		
		accPassHintPanel.add(accRes);
		accPassHintPanel.add(passRes);
		
		jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 13));
		jPanel1.add(iconImgLable);
		jPanel1.add(accPassHintPanel);
		
		jPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
		jPanel2.add(rememberPassword);
		jPanel2.add(autoLogin);
		
		jPanel3 = new JPanel();
		jPanel3.add(login);
		
		accPassHintPanel.add(jPanel2);
		operLayout.add(jPanel);
		operLayout.add(jPanel1);
		operLayout.add(jPanel3);
		add(operLayout);
		
		setVisible(true);
	}
	
	/**
	 * @Title: addHandlerEvent  
	 * @Description: 处理事件
	 * @param     参数  
	 * @return void    返回类型
	 */
	private void addHandlerEvent() {
		/**
		 * 登录按钮的事件监听
		 */
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(accountField.getText().trim().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
					return;
				}
				init();
				connection.send("*#LOGIN#*-" + accountField.getText().trim() + "-" + nickname + "-" + localAddress.getHostAddress()+"-" + String.valueOf(passwordField.getPassword()).trim());
				message = connection.read();
				if ("LOGIN_FAIL".equals(message)) {
					JOptionPane.showMessageDialog(null, "当前账号已在线，请退出后重新登录！");
					accountField.setText("");
					passwordField.setText("");
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if ("LOGIN_SUCCESSFULLY".equals(message)) {
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					userInfo.setUsername(accountField.getText());
					userInfo.setNickname(nickname);
					new FriendsListFrame((UserInfo)connection.readObject(), socket, connection);
					LoginFrame.this.dispose();
				} else if("ERROR".equals(message)) {
					JOptionPane.showMessageDialog(null, "账号或密码错误，请重试！");
					passwordField.setText("");
				}
			}
		});
		
		/**
		 * 注册的事件监听
		 */
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				init();
				new RegisterFrame(socket, connection);
			}
		});
		
		/**
		 * 找回密码的事件监听
		 */
		findPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "本功能暂未开放！");
			}
		});
		/**
		 * 记住密码的事件监听
		 */
		rememberPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "本功能暂未开放！");
			}
		});
		/**
		 * 自动登录的事件监听
		 */
		autoLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "本功能暂未开放！");
			}
		});
		/**
		 * 关闭窗口的事件监听
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
	
	/**
	 * @Title: init  
	 * @Description: 进行初始化
	 * @param     参数  
	 * @return void    返回类型
	 */
	private void init() {
		userInfo = new UserInfo();
		try {
			localAddress = InetAddress.getLocalHost();
			socket = new Socket(localAddress, SERVER_PORT);
			connection = new ConnectionStream(socket);
		} catch (UnknownHostException e) {
			System.out.println("找不到 host 的任何 IP 地址!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("创建套接字时发生 I/O 错误!");
			e.printStackTrace();
		}
	}
}