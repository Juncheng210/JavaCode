package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @ClassName: Test4 
 * @Description: ���񲼾�
 * @author Administrator  
 * @date 2018��6��3��  
 *
 */
public class Test4 extends JFrame {
	int size = 9;
	JButton[] jbs = new JButton[size];
	
	public static void main(String[] args) {
		Test4 test4 = new Test4();
	}
	
	public Test4() {
		//�������
		for(int i=0; i<9; i++) {
			jbs[i] = new JButton(""+(i+1));
		}
		
		//������
		for(int i=0; i<9; i++) {
			this.add(jbs[i]);
		}
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(3, 3, 10, 10));
		
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
