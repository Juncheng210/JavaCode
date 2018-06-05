package day0416;

import java.util.Random;

public class Demo1 {
	public static void main(String[] args) {
		//求数组元素的最大值（其位置），最小值（其位置），平均值，和
		
		int[] arr = new int[10];
		Random rand = new Random();
		for(int i=0; i<arr.length; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i] + " ");
		}
		
		int arrMax = arr[0];
		int index = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>arrMax) {
				arrMax = arr[i];
				index = i;
			}
		}
		System.out.println("数组最大值为："+ arrMax + "，对应位置为：第" + (index+1) + "个");
		
		System.out.println("---------------------------------------------------------------");
		
		//求数组中相邻两项（后-前）的最大值
		int max = arr[1] - arr[0];
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i+1]-arr[i]>max) {
				max = arr[i+1]-arr[i];
			}
		}
		System.out.println("数组两项之差最大值为："+max);
	}
}
