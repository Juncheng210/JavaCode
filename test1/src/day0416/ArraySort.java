//数组排序
package day0416;

import java.util.Random;

public class ArraySort {

	public static void main(String[] args) {
/*		
		//冒泡排序
		int[] arr = new int[10];
		Random rand = new Random();
		for(int i=0; i<arr.length; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i] + " ");
		}
		//升序排列
		int temp = 0;
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<arr.length-i; j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println();
		//打印排序后的数组
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
*/		
		//选择排序
		int[] arr = new int[10];
		Random rand = new Random();
		for(int i=0; i<arr.length; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i] + " ");
		}
		//升序排列
		int temp = 0;
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println();
		//打印排序后的数组
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
