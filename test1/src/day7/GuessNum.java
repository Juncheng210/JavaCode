package day7;

import java.util.Scanner;

public class GuessNum {

	public static void main(String[] args) {
		//猜数字
		int a = 100;
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("请猜数字：");
			int num = s.nextInt();
			
			if(num<a) {
				System.out.println("小了");
			} else if(num==a) {
				System.out.println("恭喜您！找到了："+a);
				break;
			} else {
				System.out.println("大了");
			}
		}
	}

}
