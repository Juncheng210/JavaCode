package day6;

import java.util.Random;
import java.util.Scanner;

public class JudgementNumber {

	public static void main(String[] args) {
		//编写程序，从键盘输入一个 0~99999 之间的任意数，判断输入的数是几位	数
//		Random rand = new Random();
//		int r = rand.nextInt(100000);
		System.out.println("请输入一个0~99999之间的数：");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		System.out.println("您输入的数是："+r);
		String s = r+"";
		System.out.println("其位数为："+s.length());
/*
		Random r = new Random();
		int n = r.nextInt(100000);
		System.out.println(n);
		if(n>=0 & n<10){
			System.out.println("1位数");
		}else if(n>=10 & n<100){
			System.out.println("2位数");
		}else if(n>=100 & n<1000){
			System.out.println("3位数");
		}else if(n>=1000 & n<10000){
			System.out.println("4位数");
		}else if(n>=10000 & n<100000){
			System.out.println("5位数");
		}
*/
	}

}