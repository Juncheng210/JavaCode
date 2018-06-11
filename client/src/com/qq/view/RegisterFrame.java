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
	private JLabel jLabel1, jLabel2;
	private JTextField accountField;//ÕËºÅÎÄ±¾¿ò
	private JPasswordField passwordField;//ÃÜÂëÎÄ±¾¿ò
	private JPanel jPanel1, jPanel2, jPanel3;
	private JButton register;//µÇÂ¼°´Å¥
	
	private Socket socket;
	private UserInfo userInfo;
	private static final int SERVER_PORT = 8888;
	private InetAddress localAddress;
	
	private ConnectionStream connection;
	private String message;
	
	public RegisterFrame(Socket socket, ConnectionStream connection) {
		this.socket = socket;
		this.connection = connection;
		createFrame();
		addHandlerEvent();
	}
	
	private void createFrame() {
		//´°¿Ú»ù´¡²Ù×÷ÉèÖÃ
		setTitle("×¢²á");
		setSize(420, 330);
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
		
		//ÉèÖÃ±³¾°Í¼Æ¬
		ImageIcon backgroundImg = new ImageIcon("src/com/qq/resources/background.jpg");
		JLabel imgLable = new JLabel(backgroundImg);
		//²Ù×÷ÇøÓò
		JPanel operLayout = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		jLabel1 = new JLabel("ÕËºÅ");
		jLabel2 = new JLabel("ÃÜÂë");
		
		//´´½¨ÕËºÅºÍÃÜÂë¿ò
		accountField = new JTextField(15);
		passwordField = new JPasswordField(15);
		
		JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		jPanel.add(imgLable);
		JPanel accRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		//×¢²á°´Å¥
		register = new JButton("×¢²á");
		register.setBackground(new Color(30, 144, 255));
		register.setForeground(Color.WHITE);
		register.setPreferredSize(new Dimension(210, 30));
		
		accRes.add(register);
		
		
		jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		jPanel1.add(jLabel1);
		jPanel1.add(accountField);
		
		jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
		jPanel2.add(jLabel2);
		jPanel2.add(passwordField);
		
		jPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		jPanel3.add(register);
		
		operLayout.add(jPanel);
		operLayout.add(jPanel1);
		operLayout.add(jPanel2);
		operLayout.add(jPanel3);
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
				connection.send("*#REGISTER#*-"+accountField.getText().trim()+"-"+String.valueOf(passwordField.getPassword()).trim());
				message = connection.read();
				if("REGISTER_SUCCESSFULLY".equals(message)) {
					JOptionPane.showMessageDialog(null, "×¢²á³É¹¦£¡");
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} else if("REGISTER_FAIL".equals(message)) {
					JOptionPane.showMessageDialog(null, "ÕËºÅÒÑ´æÔÚ£¬ÇëÖØÊÔ£¡");
				}
			}
		});
	}
}