package demo;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		/*
		 * ��һ�����ֱ�ȥ��2��sqrt(�����)������ܱ�������
		 * ���������������������֮��������
		 * */
		/*
		System.out.println("������һ����������");
		
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		s.close();
		
		int i=2;
		while(i<m) {
			i++;
			if(m%i==0) break;
		}
		if(i==m){
			System.out.println(m+"������");
		}else{
			System.out.println(m+"��������");
		}
		*/
		/*
		 * �ж�101-200֮���ж��ٸ����������������������
		 * */
		for(int j=100; j<=200; j++) {
			int i=2;
			while(i<j) {
				i++;
				if(j%i==0) break;
			}
			if(i==j){
				System.out.println(j+"������");
			}
		}

	}

}
