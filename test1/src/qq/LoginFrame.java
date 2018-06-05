package qq;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

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

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel register;
	private JLabel findPassword;
	private JCheckBox remPassword;
	private JCheckBox autoLogin;
	private JTextField accountField;
	private JPasswordField passwordField;
	private JPanel jPanel_1;
	private JPanel jPanel_2;
	private JPanel jPanel_3;
	private JButton login;

	public LoginFrame() throws HeadlessException {
		createFrame();
		addHandlerEvent();
	}

	private void createFrame() {
		setTitle("登陆");
		ImageIcon image1 = new ImageIcon("src/qq/images/background.jpg");
		JLabel imageLable = new JLabel(image1);
		ImageIcon portraItImage = new ImageIcon("src/qq/images/logo.png");
		portraItImage.setImage(portraItImage.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		JLabel portraItImageLable = new JLabel(portraItImage);
		JPanel mainLayout = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		accountField = new JTextField(15);
		login = new JButton("安全登录");
		login.setBackground(new Color(30, 144, 255));
		login.setForeground(Color.white);
		login.setPreferredSize(new Dimension(170, 30));
		passwordField = new JPasswordField(15);
		JPanel jPanel_0 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		JPanel accRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		JPanel passRes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		JPanel accPassHintPanel = new JPanel(new GridLayout(3, 15, 0, 0));
		register = new JLabel("注册账号");
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.setForeground(Color.BLUE);
		findPassword = new JLabel("找回密码");
		findPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findPassword.setForeground(Color.BLUE);
		remPassword = new JCheckBox("记住密码");
		autoLogin = new JCheckBox("自动登录");
		accRes.add(accountField);
		accRes.add(register);
		passRes.add(passwordField);
		passRes.add(findPassword);
		accPassHintPanel.add(accRes);
		accPassHintPanel.add(passRes);
		jPanel_1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		jPanel_2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 1));
		jPanel_3 = new JPanel();
		jPanel_0.add(imageLable);
		jPanel_3.add(login);
		jPanel_2.add(remPassword);
		jPanel_2.add(autoLogin);
		accPassHintPanel.add(jPanel_2);
		mainLayout.add(jPanel_0);
		jPanel_1.add(portraItImageLable);
		jPanel_1.add(accPassHintPanel);
		mainLayout.add(jPanel_1);
		mainLayout.add(jPanel_3);
		add(mainLayout);
		setVisible(true);
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
	}

	private void addHandlerEvent() {
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JDialog jd = new JDialog(new ChatRoomUserListFrame());
				jd.setVisible(true);
				dispose();
				System.out.println("已开始向服务器发送登录数据...");
				System.out.println("等待服务器返回登录结果...");
			}
		});

		register.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "本功能暂未开放！");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		findPassword.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "本功能暂未开放！");
			}
		});
		remPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "本功能暂未开放！");
			}
		});
		autoLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
	public static void main(String[] args) {
		new LoginFrame();
	}
}