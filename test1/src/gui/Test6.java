package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 
 * @ClassName: Test6
 * @Description: ���ֲ��ֹ�����ʹ��
 * @author Administrator  
 * @date 2018��6��3��  
 *
 */
public class Test6 extends JFrame {
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JTextField jtf1;
	JPasswordField jpf1;
	
	public static void main(String[] args) {
		Test6 test6 = new Test6();
	}
	
	public Test6() {
		//�������
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jlb1 = new JLabel("�û���");
		jlb2 = new JLabel("��    ��");
		jb1 = new JButton("��¼");
		jb2 = new JButton("ȡ��");
		
		jtf1 = new JTextField(10);
		jpf1 = new JPasswordField(10);
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(3, 1));
		
		//�������
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jpf1);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//���뵽JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//���ô�������
		this.setTitle("���ֲ�����ʾ");
		this.setSize(300, 150);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ֹ�û��ı䴰�ڴ�С
		this.setResizable(false);
		
		//��ʾ����
		this.setVisible(true);
	}
}