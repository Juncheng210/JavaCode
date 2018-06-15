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
						JOptionPane.showMessageDialog(null, "�Է���ǰ�����ߣ�");
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
	 * @Description: ���ƴ���
	 * @param     ����  
	 * @return void    ��������
	 */
	private void createFrame() {
		setTitle("������"+friendUsername+"����...");
		setLayout(null);
		
		messageArea = new JTextArea();//��ʾ��Ϣ
		messageArea.setBounds(10, 10, 615, 350);
		messageArea.setEditable(false);//���ò��ɱ༭
		messageArea.setCaretPosition(messageArea.getText().length());//������ʾ���һ���ı�
		
		JScrollPane scrollPane = new JScrollPane(messageArea);
		scrollPane.setBounds(10, 10, 615, 330);
		
		inputArea = new JTextArea();//������Ϣ
		inputArea.setBounds(10, 350, 615, 100);
		
		btn1 = new JButton("����");
		btn1.setBounds(10, 460, 100, 30);
		btn2 = new JButton("�����ļ�");
		btn2.setBounds(130, 460, 100, 30);
		btn3 = new JButton("���ڶ���");
		btn3.setBounds(250, 460, 100, 30);
		close = new JButton("�ر�");
		close.setBounds(370, 460, 100, 30);
		close.setBackground(new Color(255, 84, 57));
		close.setForeground(Color.white);
		send = new JButton("����");
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
		//���ھ�����ʾ
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
	 * @Description: �˷������������¼�
	 * @param     ����  
	 * @return void    ��������
	 */
	private void addEventHandler() {
		//���Ͱ�ť���¼�
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = inputArea.getText()+"\n";
				if (message == null || message.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "���ܷ��Ϳ���Ϣ��");
				} else {
					String time = simpleDateFormat.format(new Date());
					if(connection != null) {
						messageArea.append("��  "+time+"\n"+message);
						message = message.replaceAll("\n", "\\*##\\*");
						connection.send("*#CHAT#*-"+friendUsername+"-"+userInfo.getNickname()+"("+userInfo.getUsername()+")-"+time+"-"+message);
					}
					inputArea.setText("");
				}
			}
		});
		//�رհ�ť���¼�
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connection.send("*#CHAT_EXIT#*");
				dispose();
			}
		});
		//Ĭ�Ϲر��¼�
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				connection.send("*#CHAT_EXIT#*");
				dispose();
			}
		});
	}
}
