package day0503;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		//������Ԫ�ؽ����������
		int[] a = {1,4,7,2,5,8,3,6,9};
		for(int i=0,k=a.length-1; i<k; i++,k--) {
			int temp = a[k];
			a[k] = a[i];
			a[i] = temp;
		}
		System.out.println(Arrays.toString(a));
	}
}
