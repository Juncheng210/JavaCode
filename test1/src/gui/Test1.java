package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 extends JFrame {
	JButton jb1 = null;
	public static void main(String[] args) {
		Test1 test1 = new Test1();
	}
	
	public Test1() {
		jb1 = new JButton("��ť1");
		//���ñ���
		this.setTitle("GUI����");
		//���ô�С
		this.setSize(400, 300);
		//���JButton���
		this.add(jb1);
		//������ʼλ��
		this.setLocation(200, 300);
		//���ùرմ������˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ÿɼ�
		this.setVisible(true);
	}
}
