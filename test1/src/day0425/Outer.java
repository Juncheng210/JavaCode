package day0425;

public class Outer {
	public String outer = "�ⲿ�����";
	public String a = "�ⲿ��ͬ��a����";
	public static String a1 = "�ⲿ�ྲ̬����";
	
	public void outer() {
		Inner in = new Inner();
		System.out.println("�ⲿ������ڲ��������"+in.inner);//�ⲿ������ڲ������
		System.out.println("�ⲿ�෽��");
	}
	
	public class Inner{
		public String inner = "�ڲ������";
		public String a = "�ڲ���ͬ��a����";
		
		public void inner() {
			System.out.println("�ڲ�������ⲿ�������"+outer);//�ڲ�������ⲿ�����
			System.out.println("�ڲ��෽��");
			outer();//�ڲ�������ⲿ�෽��
			System.out.println("�ڲ����з����ڲ���ͬ��������"+a);//�����ڲ���ͬ������
			System.out.println("�ڲ����з����ⲿ��ͬ��������"+Outer.this.a);//�����ⲿ��ͬ������
		}
	}
	
	public static class StaticInner{
		public String s = "��̬�ڲ������";
		public static String s1 = "��̬�ڲ��ྲ̬����";
		
		public void fun1() {
			System.out.println("��̬�ڲ��෽��");
			System.out.println("��̬�ڲ�����ֱ�ӷ����ⲿ�ྲ̬����"+a1);
		}
		public static void fun2() {
			System.out.println("��̬�ڲ��ྲ̬����");
		}
	}
}
