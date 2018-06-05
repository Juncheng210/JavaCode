package day0504;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		//一个5*5的二维数组，元素范围[1,100],把该数组行列互换
		int[][] arr = new int[5][5];
		
		Random r = new Random();
		//初始化数组
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
