package client;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ClientLogin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	//定义上面的组件
	JLabel jbl1;
	JButton close;
	//定义中间的组件
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
	JLabel jp3_jbl1,jp3_jbl2,jp3_jbl3,jp3_jbl4;
	JLabel jp4_jbl1,jp4_jbl2,jp4_jbl3,jp4_jbl4;
	JButton jp2_jb1, jp3_jb1, jp4_jb1;
	JTextField jp2_jtf, jp3_jtf, jp4_jtf;
	JPasswordField jp2_jpf, jp3_jpf, jp4_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2, jp3_jcb1,jp3_jcb2, jp4_jcb1,jp4_jcb2;
	//定义下面的组件
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	public static void main(String[] args) {
		new ClientLogin();
	}
	
	public ClientLogin() {
		//处理上面部分
		jbl1 = new JLabel(new ImageIcon("src/images/background.jpg"));
		ImageIcon img = new ImageIcon("src/images/close.png");
		img.setImage(img.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		close = new JButton(img);
		close.setBounds(394, 0, 20, 20);
		close.setBorderPainted(false);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				close.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				close.setBackground(null);
			}
		});
		jbl1.add(close);
		
		//处理下面的部分
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("src/images/denglu.gif"));
		jp1_jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog d = new JDialog();
				d.setBounds(900, 100, 300, 600);
				d.setTitle("好友列表");
				d.setLayout(null);
				d.setVisible(true);
			}
		});
		jp1_jb2 = new JButton(new ImageIcon("src/images/quxiao.gif"));
		jp1_jb3 = new JButton(new ImageIcon("src/images/xiangdao.gif"));
		//把按钮放入jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		//处理中间的部分
		//QQ号登录
		jp2 = new JPanel(new GridLayout(3, 3, 10, 10));
		jp2_jbl1 = new JLabel("QQ号码", JLabel.CENTER);
		jp2_jbl2 = new JLabel("QQ密码", JLabel.CENTER);
		jp2_jbl3 = new JLabel("忘记密码", JLabel.CENTER);
		jp2_jbl3.setForeground(Color.blue);
		jp2_jbl4 = new JLabel("申请密码保护", JLabel.CENTER);
		jp2_jb1 = new JButton(new ImageIcon("src/images/clear.gif"));
		jp2_jtf = new JTextField();
		jp2_jpf = new JPasswordField();
		jp2_jcb1 = new JCheckBox("隐身登录");
		jp2_jcb2 = new JCheckBox("记住密码");
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		//手机号登录
		jp3 = new JPanel(new GridLayout(3, 3));
		jp3_jbl1 = new JLabel("手机号码", JLabel.CENTER);
		jp3_jbl2 = new JLabel("密        码", JLabel.CENTER);
		jp3_jbl3 = new JLabel("忘记密码", JLabel.CENTER);
		jp3_jbl3.setForeground(Color.blue);
		jp3_jbl4 = new JLabel("申请密码保护", JLabel.CENTER);
		jp3_jb1 = new JButton(new ImageIcon("src/images/clear.gif"));
		jp3_jtf = new JTextField();
		jp3_jpf = new JPasswordField();
		jp3_jcb1 = new JCheckBox("隐身登录");
		jp3_jcb2 = new JCheckBox("记住密码");
		jp3.add(jp3_jbl1);
		jp3.add(jp3_jtf);
		jp3.add(jp3_jb1);
		jp3.add(jp3_jbl2);
		jp3.add(jp3_jpf);
		jp3.add(jp3_jbl3);
		jp3.add(jp3_jcb1);
		jp3.add(jp3_jcb2);
		jp3.add(jp3_jbl4);
		//邮箱登录
		jp4 = new JPanel(new GridLayout(3, 3));
		jp4_jbl1 = new JLabel("电子邮箱", JLabel.CENTER);
		jp4_jbl2 = new JLabel("密        码", JLabel.CENTER);
		jp4_jbl3 = new JLabel("忘记密码", JLabel.CENTER);
		jp4_jbl3.setForeground(Color.blue);
		jp4_jbl4 = new JLabel("申请密码保护", JLabel.CENTER);
		jp4_jb1 = new JButton(new ImageIcon("src/images/clear.gif"));
		jp4_jtf = new JTextField();
		jp4_jpf = new JPasswordField();
		jp4_jcb1 = new JCheckBox("隐身登录");
		jp4_jcb2 = new JCheckBox("记住密码");
		jp4.add(jp4_jbl1);
		jp4.add(jp4_jtf);
		jp4.add(jp4_jb1);
		jp4.add(jp4_jbl2);
		jp4.add(jp4_jpf);
		jp4.add(jp4_jbl3);
		jp4.add(jp4_jcb1);
		jp4.add(jp4_jcb2);
		jp4.add(jp4_jbl4);
		
		//创建选项卡
		jtp = new JTabbedPane();
		jtp.add("QQ号码", jp2);
		jtp.add("手机号码", jp3);
		jtp.add("电子邮箱", jp4);
		
		this.add(jbl1, "North");
		this.add(jtp, "Center");
		this.add(jp1, "South");
		this.setTitle("QQ登录");
		this.setSize(414, 368);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon("src/images/logo.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//如果用户点击登录
		if(e.getSource()==jp1_jb1)
		{
			User user = new User();
			user.setUserId(jp2_jtf.getText().trim());  //trim是出去开始或结尾的空格
			user.setPasswd(new String(jp2_jpf.getPassword()));
			
			if(this.checkUser(user))
			{
				try {
					//把创建语句提前
					FriendList qqList = new FriendList(user.getUserId());
					ManageFriendList.addFriendList(user.getUserId(), qqList);
					
					//发送一个要求在线好友的请求包
					ObjectOutputStream oos=new ObjectOutputStream(ManageClientConServerThread.getClientConServerTherad(user.getUserId()).getSocket().getOutputStream());
					
					//做一个Message
					Message m = new Message();
					m.setMesType(MessageQqType.MESSAGE_GET_ONLINE_FRIEND);
					//指明我要的qq号的好友的情况
					m.setSender(user.getUserId());
					oos.writeObject(m);	
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			//	new QqFriendList(u.getUserId());
				//关闭掉登录界面
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "用户名密码错误");
			}
		}
	}
	/**
	 * @Title: checkUser  
	 * @Description: 检查密码是否正确
	 * @param @param u
	 * @param @return    参数  
	 * @return boolean    返回类型
	 */
	public boolean checkUser(User user)
	{
		return new ConnectServer().sendLoginInfoToServer(user);
	}
}
