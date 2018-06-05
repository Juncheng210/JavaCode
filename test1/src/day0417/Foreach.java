package day0417;

import java.util.Arrays;

public class Foreach {

	public static void main(String[] args) {
		//增强型循环循环
//		int[] arr = new int[10];
//		System.out.println(Arrays.toString(arr));
//		for (int i : arr) {//i代表数组中的每一个元素
//			System.out.print(i+",");
//		}
		
		//Arrays类中的sort方法对数组排序
		int[] a = {20,30,60,70,50,10,90,80,40};
		Arrays.sort(a);//默认升序排列
		System.out.println(Arrays.binarySearch(a, 11 ));//二分搜索某个值，若存在，返回下标；否则返回一个负数。前提：先排序
		System.out.println(Arrays.toString(a));
	}

}
