package day6;

import java.util.Random;
import java.util.Scanner;

public class JudgementNumber {

	public static void main(String[] args) {
		//��д���򣬴Ӽ�������һ�� 0~99999 ֮������������ж���������Ǽ�λ	��
//		Random rand = new Random();
//		int r = rand.nextInt(100000);
		System.out.println("������һ��0~99999֮�������");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		System.out.println("����������ǣ�"+r);
		String s = r+"";
		System.out.println("��λ��Ϊ��"+s.length());
/*
		Random r = new Random();
		int n = r.nextInt(100000);
		System.out.println(n);
		if(n>=0 & n<10){
			System.out.println("1λ��");
		}else if(n>=10 & n<100){
			System.out.println("2λ��");
		}else if(n>=100 & n<1000){
			System.out.println("3λ��");
		}else if(n>=1000 & n<10000){
			System.out.println("4λ��");
		}else if(n>=10000 & n<100000){
			System.out.println("5λ��");
		}
*/
	}

}