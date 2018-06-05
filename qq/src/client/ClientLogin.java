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
	//������������
	JLabel jbl1;
	JButton close;
	//�����м�����
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
	JLabel jp3_jbl1,jp3_jbl2,jp3_jbl3,jp3_jbl4;
	JLabel jp4_jbl1,jp4_jbl2,jp4_jbl3,jp4_jbl4;
	JButton jp2_jb1, jp3_jb1, jp4_jb1;
	JTextField jp2_jtf, jp3_jtf, jp4_jtf;
	JPasswordField jp2_jpf, jp3_jpf, jp4_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2, jp3_jcb1,jp3_jcb2, jp4_jcb1,jp4_jcb2;
	//������������
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	public static void main(String[] args) {
		new ClientLogin();
	}
	
	public ClientLogin() {
		//�������沿��
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
		
		//��������Ĳ���
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("src/images/denglu.gif"));
		jp1_jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog d = new JDialog();
				d.setBounds(900, 100, 300, 600);
				d.setTitle("�����б�");
				d.setLayout(null);
				d.setVisible(true);
			}
		});
		jp1_jb2 = new JButton(new ImageIcon("src/images/quxiao.gif"));
		jp1_jb3 = new JButton(new ImageIcon("src/images/xiangdao.gif"));
		//�Ѱ�ť����jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		//�����м�Ĳ���
		//QQ�ŵ�¼
		jp2 = new JPanel(new GridLayout(3, 3, 10, 10));
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
		//�ֻ��ŵ�¼
		jp3 = new JPanel(new GridLayout(3, 3));
		jp3_jbl1 = new JLabel("�ֻ�����", JLabel.CENTER);
		jp3_jbl2 = new JLabel("��        ��", JLabel.CENTER);
		jp3_jbl3 = new JLabel("��������", JLabel.CENTER);
		jp3_jbl3.setForeground(Color.blue);
		jp3_jbl4 = new JLabel("�������뱣��", JLabel.CENTER);
		jp3_jb1 = new JButton(new ImageIcon("src/images/clear.gif"));
		jp3_jtf = new JTextField();
		jp3_jpf = new JPasswordField();
		jp3_jcb1 = new JCheckBox("�����¼");
		jp3_jcb2 = new JCheckBox("��ס����");
		jp3.add(jp3_jbl1);
		jp3.add(jp3_jtf);
		jp3.add(jp3_jb1);
		jp3.add(jp3_jbl2);
		jp3.add(jp3_jpf);
		jp3.add(jp3_jbl3);
		jp3.add(jp3_jcb1);
		jp3.add(jp3_jcb2);
		jp3.add(jp3_jbl4);
		//�����¼
		jp4 = new JPanel(new GridLayout(3, 3));
		jp4_jbl1 = new JLabel("��������", JLabel.CENTER);
		jp4_jbl2 = new JLabel("��        ��", JLabel.CENTER);
		jp4_jbl3 = new JLabel("��������", JLabel.CENTER);
		jp4_jbl3.setForeground(Color.blue);
		jp4_jbl4 = new JLabel("�������뱣��", JLabel.CENTER);
		jp4_jb1 = new JButton(new ImageIcon("src/images/clear.gif"));
		jp4_jtf = new JTextField();
		jp4_jpf = new JPasswordField();
		jp4_jcb1 = new JCheckBox("�����¼");
		jp4_jcb2 = new JCheckBox("��ס����");
		jp4.add(jp4_jbl1);
		jp4.add(jp4_jtf);
		jp4.add(jp4_jb1);
		jp4.add(jp4_jbl2);
		jp4.add(jp4_jpf);
		jp4.add(jp4_jbl3);
		jp4.add(jp4_jcb1);
		jp4.add(jp4_jcb2);
		jp4.add(jp4_jbl4);
		
		//����ѡ�
		jtp = new JTabbedPane();
		jtp.add("QQ����", jp2);
		jtp.add("�ֻ�����", jp3);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//����û������¼
		if(e.getSource()==jp1_jb1)
		{
			User user = new User();
			user.setUserId(jp2_jtf.getText().trim());  //trim�ǳ�ȥ��ʼ���β�Ŀո�
			user.setPasswd(new String(jp2_jpf.getPassword()));
			
			if(this.checkUser(user))
			{
				try {
					//�Ѵ��������ǰ
					FriendList qqList = new FriendList(user.getUserId());
					ManageFriendList.addFriendList(user.getUserId(), qqList);
					
					//����һ��Ҫ�����ߺ��ѵ������
					ObjectOutputStream oos=new ObjectOutputStream(ManageClientConServerThread.getClientConServerTherad(user.getUserId()).getSocket().getOutputStream());
					
					//��һ��Message
					Message m = new Message();
					m.setMesType(MessageQqType.MESSAGE_GET_ONLINE_FRIEND);
					//ָ����Ҫ��qq�ŵĺ��ѵ����
					m.setSender(user.getUserId());
					oos.writeObject(m);	
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			//	new QqFriendList(u.getUserId());
				//�رյ���¼����
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "�û����������");
			}
		}
	}
	/**
	 * @Title: checkUser  
	 * @Description: ��������Ƿ���ȷ
	 * @param @param u
	 * @param @return    ����  
	 * @return boolean    ��������
	 */
	public boolean checkUser(User user)
	{
		return new ConnectServer().sendLoginInfoToServer(user);
	}
}
