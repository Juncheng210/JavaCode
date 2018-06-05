package client;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ClientLogin extends JFrame {
	//定义上面的组件
	JLabel jbl1;
	JButton close;
	//定义中间的组件
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;
	//定义下面的组件
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	public static void main(String[] args) {
		ClientLogin login = new ClientLogin();
	}
	
	public ClientLogin() {
		//处理上面部分
		jbl1 = new JLabel(new ImageIcon("src/images/background.jpg"));
		close = new JButton(new ImageIcon("src/images/close.png"));
		close.setBounds(394, 0, 20, 20);
		close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		jbl1.add(close);
		
		//处理下面的部分
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("src/images/denglu.gif"));
		jp1_jb2 = new JButton(new ImageIcon("src/images/quxiao.gif"));
		jp1_jb3 = new JButton(new ImageIcon("src/images/xiangdao.gif"));
		//把按钮放入jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		//处理中间的部分
		jp2 = new JPanel(new GridLayout(3, 3));
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
		//创建选项卡
		jtp = new JTabbedPane();
		jtp.add("QQ号码", jp2);
		jp3 = new JPanel();
		jtp.add("手机号码", jp3);
		jp4 = new JPanel();
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
}
