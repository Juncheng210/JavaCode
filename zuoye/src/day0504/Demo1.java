package day0504;

import java.util.Arrays;
import java.util.Random;

public class Demo1 {
	public static void main(String[] args) {
		//���õݹ���⣬����һ������Ϊ100���������飬��Χ[1,100]���Ѿ��ź������ö��ֲ��ҷ�ȥѰ��һ���̶�����
		int[] arr = new int[100];
		
		Random r = new Random();
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(100) + 1;
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
//		int num = 50;
//		int startIndex = 0;
//		int endIndex = arr.length-1;
//		
//		while(startIndex<endIndex) {
//			int mid = (startIndex+endIndex)/2;
//			int midVal = arr[mid];
//			if(midVal==num) {
//				System.out.println("��");
//				break;
//			} else if(midVal>num) {
//				endIndex = mid - 1;
//			} else {
//				startIndex = mid + 1;
//			}
//		}
		System.out.println( Recursion.search(arr, 0, arr.length-1, 49) );
		
	}
}
