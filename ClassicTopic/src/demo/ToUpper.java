package demo;

import java.util.Scanner;

public class ToUpper {

	public static void main(String[] args) {
		//编写程序，输入一个字符，判断它是否为小写字母，如果是，将它转换成大写字母，否则，不转换
		//a-z：97-122   A-Z:65-90
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个字母：");
		String i = s.next();
		
		char char1 = i.charAt(0);
		
		if(char1>=97 && char1<=122) {
			System.out.print("您输入的字母为："+i+"\n");
			char1 = (char)(char1 - 32);
			System.out.print("转换后的结果为："+char1);
		} else if(char1>=65 && char1<=90) {
			System.out.println("您输入的不是小写字母！");
		} else {
			System.out.println("您输入的不是字母");
		}
	}

}
