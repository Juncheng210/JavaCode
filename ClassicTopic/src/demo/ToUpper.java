package demo;

import java.util.Scanner;

public class ToUpper {

	public static void main(String[] args) {
		//��д��������һ���ַ����ж����Ƿ�ΪСд��ĸ������ǣ�����ת���ɴ�д��ĸ�����򣬲�ת��
		//a-z��97-122   A-Z:65-90
		Scanner s = new Scanner(System.in);
		System.out.println("������һ����ĸ��");
		String i = s.next();
		
		char char1 = i.charAt(0);
		
		if(char1>=97 && char1<=122) {
			System.out.print("���������ĸΪ��"+i+"\n");
			char1 = (char)(char1 - 32);
			System.out.print("ת����Ľ��Ϊ��"+char1);
		} else if(char1>=65 && char1<=90) {
			System.out.println("������Ĳ���Сд��ĸ��");
		} else {
			System.out.println("������Ĳ�����ĸ");
		}
	}

}
