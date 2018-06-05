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
	//������������
	JLabel jbl1;
	JButton close;
	//�����м�����
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;
	//������������
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	public static void main(String[] args) {
		ClientLogin login = new ClientLogin();
	}
	
	public ClientLogin() {
		//�������沿��
		jbl1 = new JLabel(new ImageIcon("src/images/background.jpg"));
		close = new JButton(new ImageIcon("src/images/close.png"));
		close.setBounds(394, 0, 20, 20);
		close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		jbl1.add(close);
		
		//��������Ĳ���
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("src/images/denglu.gif"));
		jp1_jb2 = new JButton(new ImageIcon("src/images/quxiao.gif"));
		jp1_jb3 = new JButton(new ImageIcon("src/images/xiangdao.gif"));
		//�Ѱ�ť����jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		//�����м�Ĳ���
		jp2 = new JPanel(new GridLayout(3, 3));
		jp2_jbl1 = new JLabel("QQ����", JLabel.CENTER);
		jp2_jbl2 = new JLabel("QQ����", JLabel.CENTER);
		jp2_jbl3 = new JLabel("��������", JLabel.CENTER);
		jp2_jbl3.setForeground(Color.blue);
		jp2_jbl4 = new JLabel("�������뱣��", JLabel.CENTER);
		jp2_jb1 = new JButton(new ImageIcon("src/images/clear.gif"));
		jp2_jtf = new JTextField();
		jp2_jpf = new JPasswordField();
		jp2_jcb1 = new JCheckBox("�����¼");
		jp2_jcb2 = new JCheckBox("��ס����");
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		//����ѡ�
		jtp = new JTabbedPane();
		jtp.add("QQ����", jp2);
		jp3 = new JPanel();
		jtp.add("�ֻ�����", jp3);
		jp4 = new JPanel();
		jtp.add("��������", jp4);
		
		this.add(jbl1, "North");
		this.add(jtp, "Center");
		this.add(jp1, "South");
		this.setTitle("QQ��¼");
		this.setSize(414, 368);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon("src/images/logo.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
