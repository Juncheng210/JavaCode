package day7;

import java.util.Scanner;

public class GuessNum {

	public static void main(String[] args) {
		//������
		int a = 100;
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("������֣�");
			int num = s.nextInt();
			
			if(num<a) {
				System.out.println("С��");
			} else if(num==a) {
				System.out.println("��ϲ�����ҵ��ˣ�"+a);
				break;
			} else {
				System.out.println("����");
			}
		}
	}

}
