package demo;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		/*
		 * 用一个数分别去除2到sqrt(这个数)，如果能被整除，
		 * 则表明此数不是素数，反之是素数。
		 * */
		/*
		System.out.println("请输入一个正整数：");
		
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		s.close();
		
		int i=2;
		while(i<m) {
			i++;
			if(m%i==0) break;
		}
		if(i==m){
			System.out.println(m+"是素数");
		}else{
			System.out.println(m+"不是素数");
		}
		*/
		/*
		 * 判断101-200之间有多少个素数，并输出所有素数。
		 * */
		for(int j=100; j<=200; j++) {
			int i=2;
			while(i<j) {
				i++;
				if(j%i==0) break;
			}
			if(i==j){
				System.out.println(j+"是素数");
			}
		}

	}

}
