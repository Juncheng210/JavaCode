package gui;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Test8 extends JFrame {
	JPanel jp1,jp2;
	JLabel jl1,jl2;
	JComboBox<String> jcb1;
	JList<String> jlist;
	JScrollPane jsp;
	
	public static void main(String[] args) {
		Test8 test8 = new Test8();
	}
	
	public Test8() {
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jl1 = new JLabel("����");
		jl2 = new JLabel("���εص�");
		
		String[] jg = {"����", "�Ϻ�", "���", "�ɶ�"};
		jcb1 = new JComboBox<String>(jg);
		
		String[] dd = {"��կ��", "�ʹ�", "����", "�찲��"};
		jlist = new JList<String>(dd);
		//������ʾ�ĸ���
		jlist.setVisibleRowCount(2);
		jsp = new JScrollPane(jlist);
		
		
		//���ò���
		this.setLayout(new GridLayout(3, 1));
		
		//������
		jp1.add(jl1);
		jp1.add(jcb1);
		
		jp2.add(jl1);
		jp2.add(jsp);
		
		this.add(jp1);
		this.add(jp2);
		
		//���ô�������
		this.setTitle("���ֲ�����ʾ");
		this.setSize(300, 150);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ֹ�û��ı䴰�ڴ�С
		//this.setResizable(false);
		
		//��ʾ����
		this.setVisible(true);
	}
}
