package day0416;

import java.util.Random;

public class Exercises1 {

	public static void main(String[] args) {
		//一个5*5的二维数组，利用随机数为其赋值，求两条对角线上的元素
		int[][] arr = new int[5][5];  //创建数组
		
		Random rand = new Random();
		//初始化数组
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = rand.nextInt(1000);
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		//对角线1（左上-右下）
		System.out.print("主对角线元素为：");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==j) {
					System.out.print(arr[i][j]+" ");
				}
			}
		}
		System.out.println();
		
		//对角线2（右上-左下）
		System.out.print("副对角线元素为：");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i+j==4) {
					System.out.print(arr[i][j]+" ");
				}
			}
		}
		System.out.println();
	}

}
