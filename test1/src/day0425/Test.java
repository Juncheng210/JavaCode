package day0425;

import day0425.Outer.Inner;
import day0425.Outer.StaticInner;

public class Test {
	public static void main(String[] args) {
		//��Ա�ڲ���
		//�����ڲ��࣬д��һ��ͬ���ڣ�����д�����赼����
		Outer.Inner in1 = new Outer().new Inner();
		in1.inner();
		System.out.println("-------------�����ķָ���---------------");
		//�����ڲ��࣬д������ͬ���ڣ�����д����Ҫ������
		Inner in2 = new Outer().new Inner();
		in2.inner();
		System.out.println("-------------�����ķָ���---------------");
		//�����ڲ��࣬д������ͬ���ڣ�����д����Ҫ������
		Outer out = new Outer();
		Inner in3 = out.new Inner();
		in3.inner();
		System.out.println("-------------�����ķָ���---------------");
		
		//��̬�ڲ��ࣨͬ���ڣ�����д����Ҫ������
		StaticInner sin = new StaticInner();
		System.out.println(sin.s);
		System.out.println(sin.s1);
		sin.fun1();
		System.out.println("-------------�����ķָ���---------------");
		
		//�ֲ��ڲ���
		Outer1 out1 = new Outer1();
		out1.fun();
		System.out.println("-------------�����ķָ���---------------");
		
		//�����ڲ���
		IOuter io = new IOuter() {
			
			@Override
			public void work() {
				System.out.println("����");
			}
			
			@Override
			public void eat() {
				System.out.println("�Զ���");
			}
		};
		io.eat();
		io.work();
	}
}
