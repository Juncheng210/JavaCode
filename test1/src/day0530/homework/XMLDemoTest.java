package day0530.homework;

import java.util.Scanner;

public class XMLDemoTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String filepath = "src/day0530/homework/exam1.xml";
		
		while(true) {
			System.out.println("����û�����a��	ɾ���û�����b��	��ѯ�ɼ�����c��");
			System.out.print("������������ͣ�");
			String input = sc.next();
			if(input.equalsIgnoreCase("a")) {
				XMLDemo.addUserMsg(filepath);
				System.out.print("����Ҫ���������𣿣�ȷ�������롰Y��,��������������ĸ����");
				String in = sc.next();
				if(in.equalsIgnoreCase("Y")) {
					continue;
				} else {
					break;
				}
			} else if(input.equalsIgnoreCase("b")) {
				XMLDemo.deleteUserMsg(filepath);
				System.out.print("����Ҫ���������𣿣�ȷ�������롰Y��,��������������ĸ����");
				String in = sc.next();
				if(in.equalsIgnoreCase("Y")) {
					continue;
				} else {
					break;
				}
			} else if(input.equalsIgnoreCase("c")) {
				XMLDemo.queryUserMsg(filepath);
				System.out.print("����Ҫ���������𣿣�ȷ�������롰Y��,��������������ĸ����");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String in = sc.next();
				if(in.equalsIgnoreCase("Y")) {
					continue;
				} else {
					break;
				}
			} else {
				System.out.print("�����뷽�����еĵ�����ĸ��");
			}
		}
//		sca.close();
	}
}
