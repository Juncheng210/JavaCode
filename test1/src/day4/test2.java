package day4;

import java.util.Random;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class test2 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		int count = 0;
		int num = 0;
		while(true) {
			int first = r.nextInt(100);
			int second = r.nextInt(100);
			
			int op = r.nextInt(4);
			switch (op) {
			case 0:
				System.out.println(first+"+"+second+"=?");
				break;
			case 1:
				System.out.println(first+"-"+second+"=?");
				break;
			case 2:
				System.out.println(first+"*"+second+"=?");
				break;
			case 3:
				System.out.println(first+"/"+second+"=?");
				break;
			}
			
			double result = s.nextInt();
			double trueResult = 0;
			if(op==0) {
				trueResult = first+second;
			}else if(op==1){
				trueResult = first-second;
			}else if(op==2){
				trueResult = first*second;
			}else if(op==3){
				trueResult = first*1.0/second;
			}
			
			if(trueResult==result) {
				System.out.println("�ش���ȷ");
				num++;
			} else {
				System.out.println("�ش����");
			}
			count++;
			System.out.println("���Ƿ������⣿��Y/N��");
			String str = s.next();
			if(str.equals("N")) {
				break;
			}
		}
		System.out.println("��һ������"+count+"����");
		System.out.println("��һ��������"+num+"��1��");
		System.out.println("������ȷ��Ϊ"+num*100.0/count+"%");
	}
}
