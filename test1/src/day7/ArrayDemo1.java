package day7;

import java.util.Random;

public class ArrayDemo1 {

	public static void main(String[] args) {
		//����Ĵ�������ֵ��ȡֵ
//		int[] arr1 = new int[5];
//		int[] arr2 = new int[] {2,4,6,8};
//		int[] arr3 = {1,3,5,7,9};
/*
		arr1[0] = 10;
		arr2[1] = 5;
		arr3[4] = 10;
		
		System.out.println(arr1[0]);
		System.out.println(arr2[1]);
		System.out.println(arr3[4]);
*/
		
/*
		//ͨ��ѭ����ֵ��ȡֵ
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = i*2;
		}
		for(int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
*/
		
		//���������Ϊ���鸳ֵ
		int[] arr = new int[20];
		Random rand = new Random();
		
		for(int i=0; i<arr.length; i++) {
			int s = rand.nextInt(1000);
			arr[i] = s;
			System.out.println(arr[i]);
		}
	}

}
