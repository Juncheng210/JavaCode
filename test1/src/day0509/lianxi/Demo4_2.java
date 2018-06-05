package day0509.lianxi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 已知数组（12，23，26，45，58，60）是有序的，输入一个数x，将它插入到数组中，保证数组仍然是有序的
 * @author Administrator
 */
public class Demo4_2 {
	public static void main(String[] args) {
		int[] arr = {12, 23, 26, 45, 58, 60};
		System.out.println("请输入一个整数：");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		s.close();
		
		arr = Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1] = num;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
