package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @ClassName: Test2  
 * @Description: BorderLayout��ʾ
 * @author Administrator  
 * @date 2018��6��3��  
 *
 */
public class Test2 extends JFrame {
	JButton jb1,jb2,jb3,jb4,jb5;
	
	public static void main(String[] args) {
		Test2 test2 = new Test2();
	}
	
	public Test2() {
		//�������
		jb1 = new JButton("�в�");
		jb2 = new JButton("����");
		jb3 = new JButton("����");
		jb4 = new JButton("�ϲ�");
		jb5 = new JButton("����");
		
		//������
		this.add(jb1, BorderLayout.CENTER);
		this.add(jb2, BorderLayout.NORTH);
		this.add(jb3, BorderLayout.EAST);
		this.add(jb4, BorderLayout.SOUTH);
		this.add(jb5, BorderLayout.WEST);
		
		//���ô�������
		this.setTitle("�߽粼����ʾ");
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ʾ����
		this.setVisible(true);
	}
}
