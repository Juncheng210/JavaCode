package demo;

import java.util.Scanner;

public class Rabbit {

	public static void main(String[] args) {
		/*
		 * �ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�
		 * С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ�������
		 * ��ÿ���µ���������Ϊ���٣�
		 * ���ӵĹ���Ϊ����1,1,2,3,5,8,13,21.... 
		 * */
		int total = 0;  //��������
		int firstRabbit = 1;  //��һ������������
		int secondRabbit = 1;  //�ڶ�������������
		
		Scanner s = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ���������·ݣ�");
		int month = s.nextInt();  //�ڼ�����
		s.close();
		
		for(int i=3; i<=month; i++) {
			total = firstRabbit + secondRabbit;
			firstRabbit = secondRabbit;
			secondRabbit = total;
		}
		
		System.out.println("��"+month+"���µ���������Ϊ��"+total);

	}

}
