package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @ClassName: Test3  
 * @Description: ��ʽ���� 
 * @author Administrator  
 * @date 2018��6��3��  
 *
 */
public class Test3 extends JFrame {
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	
	public static void main(String[] args) {
		Test3 test3 = new Test3();
	}
	
	public Test3() {
		//�������
		jb1 = new JButton("��ť1");
		jb2 = new JButton("��ť2");
		jb3 = new JButton("��ť3");
		jb4 = new JButton("��ť4");
		jb5 = new JButton("��ť5");
		jb6 = new JButton("��ť6");
		
		//������
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		
		//���ò��ֹ�����
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
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
