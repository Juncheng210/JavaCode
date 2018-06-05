package day0504;

import java.util.Arrays;

public class Recursion {
	/**
	 * 利用二分查找寻找数组中有没有固定的数
	 * @param arr 目标数组
	 * @param num 要查找的数
	 */
//	public void search(int[] arr,int num) {
//		if(Arrays.binarySearch(arr, num)>=0) {
//			System.out.println("该数组中有 " + num + " 这个数，其位置是第"+ (Arrays.binarySearch(arr, num)+1) +"位");
//		} else {
//			System.out.println("该数组中没有要查找的数");
//		}
//	}
	public static boolean search(int[] arr,int startIndex,int endIndex,int num) {
		if(startIndex>endIndex) {
			return false;
		}
		
		int mid = ( startIndex + endIndex ) / 2;
		if(arr[mid] == num) {
			return true;
		} else if(arr[mid] > num) {
			return search(arr, startIndex, mid-1, num);
		} else {
			return search(arr, mid+1, endIndex, num);
		}
	}
}
