package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @ClassName: Test5
 * @Description: ���ֲ��ֹ�����ʹ��
 * @author Administrator  
 * @date 2018��6��3��  
 *
 */
public class Test5 extends JFrame {
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public static void main(String[] args) {
		Test5 test5 = new Test5();
	}
	
	public Test5() {
		//�������
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jb1 = new JButton("����");
		jb2 = new JButton("ƻ��");
		jb3 = new JButton("��֦");
		jb4 = new JButton("����");
		jb5 = new JButton("����");
		jb6 = new JButton("�㽶");
		
		//���JPanel
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		//��panel����JFrame
		this.add(jp1,BorderLayout.NORTH);
		this.add(jb6, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.SOUTH);
		
		//���ò��ֹ�����
		
		//���ô�������
		this.setTitle("��ʽ������ʾ");
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ֹ�û��ı䴰�ڴ�С
		this.setResizable(false);
		
		//��ʾ����
		this.setVisible(true);
	}
}
