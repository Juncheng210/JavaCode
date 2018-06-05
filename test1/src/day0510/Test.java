package day0510;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("-------------字符串反序输出--------------");
		//将字符串"abc"→"cba"反序输出
		String str1 = "abc";
		char[] ch1 = str1.toCharArray();
		String s1 = "";
		for(int i=ch1.length-1; i>=0; i--) {
			s1 += ch1[i];
		}
		System.out.println(s1);
		
		System.out.println("---------英文单词反序------------");
		//一句英文，将其中的单词以反序输出。      "I love you"→"i evol uoy"
		String str2 = "I love you";
		str2 = str2.toLowerCase();
		String[] s2 = str2.split(" ");
		
		for(int i=0; i<s2.length; i++) {
			char[] ch = s2[i].toCharArray();
			for(int k=ch.length-1; k>=0; k--) {
				System.out.print(ch[k]);
			}
			System.out.print(" ");
		}
		System.out.println();
		
		/*
		System.out.println("------------身份证判断性别---------------");
		//有一身份证号,判断此为男还是女,基于此方法,写一个算法,判断一个身份证号为男还 是女。 (身份证分 15位和 18位)
		String id = "123456199901016616";
		String sex;
		if(id.matches("\\d{15}")) {
			sex = id.charAt(14)%2 == 0 ? "女性" : "男性";
			System.out.println(sex);
			return;
		}
		if(id.matches("\\d{17}[0-9Xx]")) {
			sex = id.charAt(16)%2 == 0 ? "女性" : "男性";
			System.out.println(sex);
			return;
		}
		System.out.println("请输入正确的身份证号");
		*/
		
		System.out.println("-------------去除重复符号---------------");
		//123-456---789-----123-2把字符串中重复符号-去掉，既得到123-456-789-123-2
		String str3 = "123-456---789-----123-2";
		String s3 = str3.replaceAll("-{2,}", "-");
		System.out.println(s3);
		
		System.out.println("----------提取年月日，时分秒-----------");
		//"2018/05/10 12:11:10"从日期字符串中把年月日,时分秒分别取出来打印
		String str4 = "2018/05/10 12:11:10";
		String[] s4 = str4.split("[/ :]");
		for(String str : s4) {
			System.out.println(str);
		}
		
		System.out.println("-------------字符串数组排序----------------");
		//有一个数组,存了 10个学生的名字,现要求将这些名字按字典排序存在数组里。 (名字都 是英文)
		String[] str5 = {"Hardy","Joachim","Tomi","Aurelius","Elmer","Burton","Curran","Farrell","Nura","Rahman"};
		for(int i=0; i<str5.length-1; i++) {
			for(int j=i+1; j<str5.length; j++) {
				if(str5[i].compareToIgnoreCase(str5[j])>0) {
					String temp = str5[i];
					str5[i] = str5[j];
					str5[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(str5));
		
		System.out.println("-------------给定长度，随机生成字符串-----------------");
		//给定一个长度,随机产生一个该长度的字符串,由大写,小写字母以及数字组成
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		System.out.println("请输入想要生成字符串的长度：");
		int length = s.nextInt();
		s.close();
		char[] ch = new char[length];
		for(int i=0; i<ch.length; i++) {
			int num = r.nextInt(75)+48;
			if(num>=48 && num<=57 || num>=65 && num<=90 || num>=97 && num<=122) {
				ch[i] = (char)num;
			} else {
				i--;
				continue;
			}
		}
		for(char i : ch) {
			System.out.print(i);
		}
		System.out.println();
		
		System.out.println("-------------字符串加密、解密---------------");
		Password p = new Password("abcdefgZ dsfd,erz");
		p.encryption();
		p.decrypt();
	}
}
