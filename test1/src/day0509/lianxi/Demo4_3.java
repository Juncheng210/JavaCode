package day0509.lianxi;

import java.util.Random;

/**
 * 求一个二维数组的每行最大数
 * @author Administrator
 */
public class Demo4_3 {
	public static void main(String[] args) {
		Random r = new Random();
		int[][] arr = new int[5][10];
		int max;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = r.nextInt(100)+1;
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
		for(int i=0; i<arr.length; i++) {
			max = arr[i][0];
			for(int j=1; j<arr[i].length; j++) {
				if(arr[i][j]>max) {
					max = arr[i][j];
				}
			}
			System.out.println(max);
		}
	}
}
