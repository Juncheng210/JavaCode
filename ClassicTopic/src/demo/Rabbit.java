package demo;

import java.util.Scanner;

public class Rabbit {

	public static void main(String[] args) {
		/*
		 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
		 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
		 * 问每个月的兔子总数为多少？
		 * 兔子的规律为数列1,1,2,3,5,8,13,21.... 
		 * */
		int total = 0;  //兔子总数
		int firstRabbit = 1;  //第一个月兔子总数
		int secondRabbit = 1;  //第二个月兔子总数
		
		Scanner s = new Scanner(System.in);
		System.out.println("请输入要查询兔子数的月份：");
		int month = s.nextInt();  //第几个月
		s.close();
		
		for(int i=3; i<=month; i++) {
			total = firstRabbit + secondRabbit;
			firstRabbit = secondRabbit;
			secondRabbit = total;
		}
		
		System.out.println("第"+month+"个月的兔子总数为："+total);

	}

}
