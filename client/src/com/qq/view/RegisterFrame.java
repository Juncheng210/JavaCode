package com.qq.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.qq.stream.ConnectionStream;
import com.qq.user.UserInfo;

public class RegisterFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1, jLabel2, jLabel3;
	private JTextField accountField;//账号文本框
	private JTextField nicknameField;//昵称文本框
	private JPasswordField passwordField;//密码文本框
	private JPanel jPanel1, jPanel2, jPanel3, jPanel4;
	private JButton register;//登录按钮
	
	private String nickname;
	private Socket socket;
	private UserInfo userInfo;
	private static final int SERVER_PORT = 8888;
	private InetAddress localAddress;
	
	private ConnectionStream connection;
	private String message;
	
	public RegisterFrame() {
		init();
		createFrame();
		addHandlerEvent();
	}

	private void createFrame() {
		//窗口基础操作设置
		setTitle("注册");
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
		//ImageIcon iconImg = new ImageIcon("src/com/qq/resources/logo.png");
		//iconImg.setImage(iconImg.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		//JLabel iconImgLable = new JLabel(iconImg);
		//操作区域
		JPanel operLayout = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		jLabel1 = new JLabel("账号");
		jLabel2 = new JLabel("昵称");
		jLabel3 = new JLabel("密码");
		
		//创建账号和密码框
		accountField = new JTextField(15);
		nicknameField = new JTextField(15);
		passwordField = new JPasswordField(15);
		
		JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		jPanel.add(imgLable);
		JPanel accRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		//注册按钮
		register = new JButton("注册");
		register.setBackground(new Color(30, 144, 255));
		register.setForeground(Color.WHITE);
		register.setPreferredSize(new Dimension(210, 30));
		
//		accRes.add(jLabel1);
//		accRes.add(accountField);
//		accRes.add(jLabel2);
//		accRes.add(nicknameField);
//		accRes.add(jLabel3);
//		passRes.add(passwordField);
		accRes.add(register);
		
//		accPassHintPanel.add(accRes);
//		accPassHintPanel.add(passRes);
		
		jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		//jPanel1.add(iconImgLable);
		jPanel1.add(jLabel1);
		jPanel1.add(accountField);
		
		jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
		jPanel2.add(jLabel2);
		jPanel2.add(nicknameField);
		
		jPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
		jPanel3.add(jLabel3);
		jPanel3.add(passwordField);
		
		jPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		jPanel4.add(register);
		
		//accPassHintPanel.add(jPanel2);
		operLayout.add(jPanel);
		operLayout.add(jPanel1);
		operLayout.add(jPanel2);
		operLayout.add(jPanel3);
		operLayout.add(jPanel4);
		add(operLayout);
		
		setVisible(true);
	}

	private void addHandlerEvent() {		
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(accountField.getText().trim().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
					return;
				}
				System.out.println("已开始向服务器发送登录数据...");
				connection.send("*#LOGIN#*-" + accountField.getText().trim() + "-" + nickname + "-" + localAddress.getHostAddress()+"-" + String.valueOf(passwordField.getPassword()).trim());
				System.out.println("等待服务器返回登录结果...");
				//while (true) {
					message = connection.read();
					if ("LOGIN_FAIL".equals(message)) {
						JOptionPane.showMessageDialog(null, "当前账号已在线，请退出后重新登录！");
						accountField.setText("");
						passwordField.setText("");
					} else if ("NAME_IS_NULL".equals(message)) {
						// setVisible(false);
						dispose();
						nickname = JOptionPane.showInputDialog(null, "来给自己起个名字吧");
						try {
							//发送：标志   IP 姓名  账号  密码
							connection.send("*#LOGIN#*-" + InetAddress.getLocalHost().getHostAddress() + "-" + nickname + "-" + accountField.getText().trim() + "-" + String.valueOf(passwordField.getPassword()).trim());
							userInfo.setIp(InetAddress.getLocalHost().getHostAddress());
							//userInfo.setRecenIP(InetAddress.getLocalHost().getHostAddress());
							//userInfo.setRecentPort(userPort);
							System.out.println("已向服务器重新发送了信息...");
						} catch (UnknownHostException e) {
							e.printStackTrace();
						}
					} else if ("LOGIN_SUCCESSFULLY".equals(message)) {
						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						userInfo.setUsername(accountField.getText());
						userInfo.setNickname(nickname);
						//userInfo.setPort(userPort);
						//LoginProcess loginProcess = new LoginProcess(userInfo.getUserPortraitNum());
//						try {
//							Thread.sleep(1000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
						//loginProcess.dispose();
						new FriendsListFrame((UserInfo)connection.readObject(), socket, connection);
						RegisterFrame.this.dispose();
//						JOptionPane.showMessageDialog(null, "登录成功！");
					} else if("ERROR".equals(message)) {
						JOptionPane.showMessageDialog(null, "密码错误，请重试！");
						passwordField.setText("");
					}
				//}
			}
		});

		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "本功能暂未开放！");
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void init() {
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
	
	public static void main(String[] args) {
		new RegisterFrame();
	}
}