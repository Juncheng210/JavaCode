package day0503;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		//对数组元素进行逆序操作
		int[] a = {1,4,7,2,5,8,3,6,9};
		for(int i=0,k=a.length-1; i<k; i++,k--) {
			int temp = a[k];
			a[k] = a[i];
			a[i] = temp;
		}
		System.out.println(Arrays.toString(a));
	}
}
