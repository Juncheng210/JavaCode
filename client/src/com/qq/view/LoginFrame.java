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
import javax.swing.JDialog;
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
	private JLabel register;//ע��
	private JLabel findPassword;//�һ�����
	private JCheckBox rememberPassword, autoLogin;//��ס���룬�Զ���¼
	private JTextField accountField;//�˺��ı���
	private JPasswordField passwordField;//�����ı���
	private JPanel jPanel1, jPanel2, jPanel3;
	private JButton login;//��¼��ť
	
	private String nickname;
	private Socket socket;
	private UserInfo userInfo;
	private static final int SERVER_PORT = 8888;
	private InetAddress localAddress;
	
	private ConnectionStream c2s;
	private String message;
	
	public LoginFrame() {
		init();
		createFrame();
		addHandlerEvent();
	}

	private void createFrame() {
		//���ڻ�����������
		setTitle("��¼");
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
		
		//���ñ���ͼƬ
		ImageIcon backgroundImg = new ImageIcon("src/com/qq/resources/background.jpg");
		JLabel imgLable = new JLabel(backgroundImg);
		//����Ĭ��ͷ��
		ImageIcon iconImg = new ImageIcon("src/com/qq/resources/logo.png");
		iconImg.setImage(iconImg.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		JLabel iconImgLable = new JLabel(iconImg);
		//��������
		JPanel operLayout = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		//�����˺ź������
		accountField = new JTextField(15);
		passwordField = new JPasswordField(15);
		
		JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		jPanel.add(imgLable);
		JPanel accRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		JPanel passRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		JPanel accPassHintPanel = new JPanel(new GridLayout(3, 15, 0, 0));
		//ע���˺�
		register = new JLabel("ע���˺�");
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.setForeground(Color.BLUE);
		//�һ�����
		findPassword = new JLabel("�һ�����");
		findPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findPassword.setForeground(Color.BLUE);
		//��ס����
		rememberPassword = new JCheckBox("��ס����");
		//�Զ���¼
		autoLogin = new JCheckBox("�Զ���¼");
		//��¼��ť
		login = new JButton("��ȫ��¼");
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

	private void addHandlerEvent() {		
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(accountField.getText().trim().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
					return;
				}
				System.out.println("�ѿ�ʼ����������͵�¼����...");
				c2s.send("*#LOGIN#*-" + accountField.getText().trim() + "-" + nickname + "-" + localAddress.getHostAddress()+"-" + String.valueOf(passwordField.getPassword()).trim());
				System.out.println("�ȴ����������ص�¼���...");
				//while (true) {
					message = c2s.read();
					if ("LOGIN_FAIL".equals(message)) {
						JOptionPane.showMessageDialog(null, "������ͬ���˺ţ�����������");
						accountField.setText("");
						passwordField.setText("");
					} else if ("NAME_IS_NULL".equals(message)) {
						// setVisible(false);
						dispose();
						nickname = JOptionPane.showInputDialog(null, "�����Լ�������ְ�");
						try {
							//���ͣ���־   IP ����  �˺�  ����
							c2s.send("*#LOGIN#*-" + InetAddress.getLocalHost().getHostAddress() + "-" + nickname + "-" + accountField.getText().trim() + "-" + String.valueOf(passwordField.getPassword()).trim());
							userInfo.setIp(InetAddress.getLocalHost().getHostAddress());
							//userInfo.setRecenIP(InetAddress.getLocalHost().getHostAddress());
							//userInfo.setRecentPort(userPort);
							System.out.println("������������·�������Ϣ...");
						} catch (UnknownHostException e) {
							e.printStackTrace();
						}
					} else if ("LOGIN_SUCESSFULLY".equals(message)) {
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
						//new JDialog(new FriendsListFrame(userInfo, socket, c2s));
						LoginFrame.this.dispose();
//						JOptionPane.showMessageDialog(null, "��¼�ɹ���");
					}
				//}
			}
		});

		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "��������δ���ţ�");
			}
		});
		
		findPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "��������δ���ţ�");
			}
		});
		rememberPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��������δ���ţ�");
			}
		});
		autoLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��������δ���ţ�");
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
			c2s = new ConnectionStream(socket);
		} catch (UnknownHostException e) {
			System.out.println("�Ҳ��� host ���κ� IP ��ַ!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�����׽���ʱ���� I/O ����!");
			e.printStackTrace();
		}
	}
}