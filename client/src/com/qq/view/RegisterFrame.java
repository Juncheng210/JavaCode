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
	private JTextField accountField;//�˺��ı���
	private JTextField nicknameField;//�ǳ��ı���
	private JPasswordField passwordField;//�����ı���
	private JPanel jPanel1, jPanel2, jPanel3, jPanel4;
	private JButton register;//��¼��ť
	
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
		//���ڻ�����������
		setTitle("ע��");
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
		//ImageIcon iconImg = new ImageIcon("src/com/qq/resources/logo.png");
		//iconImg.setImage(iconImg.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		//JLabel iconImgLable = new JLabel(iconImg);
		//��������
		JPanel operLayout = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		jLabel1 = new JLabel("�˺�");
		jLabel2 = new JLabel("�ǳ�");
		jLabel3 = new JLabel("����");
		
		//�����˺ź������
		accountField = new JTextField(15);
		nicknameField = new JTextField(15);
		passwordField = new JPasswordField(15);
		
		JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		jPanel.add(imgLable);
		JPanel accRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		//ע�ᰴť
		register = new JButton("ע��");
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
				System.out.println("�ѿ�ʼ����������͵�¼����...");
				connection.send("*#LOGIN#*-" + accountField.getText().trim() + "-" + nickname + "-" + localAddress.getHostAddress()+"-" + String.valueOf(passwordField.getPassword()).trim());
				System.out.println("�ȴ����������ص�¼���...");
				//while (true) {
					message = connection.read();
					if ("LOGIN_FAIL".equals(message)) {
						JOptionPane.showMessageDialog(null, "��ǰ�˺������ߣ����˳������µ�¼��");
						accountField.setText("");
						passwordField.setText("");
					} else if ("NAME_IS_NULL".equals(message)) {
						// setVisible(false);
						dispose();
						nickname = JOptionPane.showInputDialog(null, "�����Լ�������ְ�");
						try {
							//���ͣ���־   IP ����  �˺�  ����
							connection.send("*#LOGIN#*-" + InetAddress.getLocalHost().getHostAddress() + "-" + nickname + "-" + accountField.getText().trim() + "-" + String.valueOf(passwordField.getPassword()).trim());
							userInfo.setIp(InetAddress.getLocalHost().getHostAddress());
							//userInfo.setRecenIP(InetAddress.getLocalHost().getHostAddress());
							//userInfo.setRecentPort(userPort);
							System.out.println("������������·�������Ϣ...");
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
//						JOptionPane.showMessageDialog(null, "��¼�ɹ���");
					} else if("ERROR".equals(message)) {
						JOptionPane.showMessageDialog(null, "������������ԣ�");
						passwordField.setText("");
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
			System.out.println("�Ҳ��� host ���κ� IP ��ַ!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�����׽���ʱ���� I/O ����!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RegisterFrame();
	}
}