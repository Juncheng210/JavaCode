package day0510;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("-------------�ַ����������--------------");
		//���ַ���"abc"��"cba"�������
		String str1 = "abc";
		char[] ch1 = str1.toCharArray();
		String s1 = "";
		for(int i=ch1.length-1; i>=0; i--) {
			s1 += ch1[i];
		}
		System.out.println(s1);
		
		System.out.println("---------Ӣ�ĵ��ʷ���------------");
		//һ��Ӣ�ģ������еĵ����Է��������      "I love you"��"i evol uoy"
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
		System.out.println("------------���֤�ж��Ա�---------------");
		//��һ���֤��,�жϴ�Ϊ�л���Ů,���ڴ˷���,дһ���㷨,�ж�һ�����֤��Ϊ�л� ��Ů�� (���֤�� 15λ�� 18λ)
		String id = "123456199901016616";
		String sex;
		if(id.matches("\\d{15}")) {
			sex = id.charAt(14)%2 == 0 ? "Ů��" : "����";
			System.out.println(sex);
			return;
		}
		if(id.matches("\\d{17}[0-9Xx]")) {
			sex = id.charAt(16)%2 == 0 ? "Ů��" : "����";
			System.out.println(sex);
			return;
		}
		System.out.println("��������ȷ�����֤��");
		*/
		
		System.out.println("-------------ȥ���ظ�����---------------");
		//123-456---789-----123-2���ַ������ظ�����-ȥ�����ȵõ�123-456-789-123-2
		String str3 = "123-456---789-----123-2";
		String s3 = str3.replaceAll("-{2,}", "-");
		System.out.println(s3);
		
		System.out.println("----------��ȡ�����գ�ʱ����-----------");
		//"2018/05/10 12:11:10"�������ַ����а�������,ʱ����ֱ�ȡ������ӡ
		String str4 = "2018/05/10 12:11:10";
		String[] s4 = str4.split("[/ :]");
		for(String str : s4) {
			System.out.println(str);
		}
		
		System.out.println("-------------�ַ�����������----------------");
		//��һ������,���� 10��ѧ��������,��Ҫ����Щ���ְ��ֵ������������� (���ֶ� ��Ӣ��)
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
		
		System.out.println("-------------�������ȣ���������ַ���-----------------");
		//����һ������,�������һ���ó��ȵ��ַ���,�ɴ�д,Сд��ĸ�Լ��������
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		System.out.println("��������Ҫ�����ַ����ĳ��ȣ�");
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
		
		System.out.println("-------------�ַ������ܡ�����---------------");
		Password p = new Password("abcdefgZ dsfd,erz");
		p.encryption();
		p.decrypt();
	}
}
