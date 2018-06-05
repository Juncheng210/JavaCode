package day0509.lianxi;

import java.util.Arrays;
import java.util.Random;

/**
 * 将一个数组中的数逆序重新存放
 * @author Administrator
 */
public class Demo4_1 {
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
