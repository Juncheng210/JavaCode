package day0417;

import java.util.Arrays;

public class Foreach {

	public static void main(String[] args) {
		//��ǿ��ѭ��ѭ��
//		int[] arr = new int[10];
//		System.out.println(Arrays.toString(arr));
//		for (int i : arr) {//i���������е�ÿһ��Ԫ��
//			System.out.print(i+",");
//		}
		
		//Arrays���е�sort��������������
		int[] a = {20,30,60,70,50,10,90,80,40};
		Arrays.sort(a);//Ĭ����������
		System.out.println(Arrays.binarySearch(a, 11 ));//��������ĳ��ֵ�������ڣ������±ꣻ���򷵻�һ��������ǰ�᣺������
		System.out.println(Arrays.toString(a));
	}

}
