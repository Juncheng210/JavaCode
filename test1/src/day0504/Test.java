package day0504;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		//һ��5*5�Ķ�ά���飬Ԫ�ط�Χ[1,100],�Ѹ��������л���
		int[][] arr = new int[5][5];
		
		Random r = new Random();
		//��ʼ������
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = r.nextInt(100) + 1;
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[j][i] + "  ");
			}
			System.out.println();
		}
	}
}
