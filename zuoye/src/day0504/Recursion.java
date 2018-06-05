package day0504;

import java.util.Arrays;

public class Recursion {
	/**
	 * ���ö��ֲ���Ѱ����������û�й̶�����
	 * @param arr Ŀ������
	 * @param num Ҫ���ҵ���
	 */
//	public void search(int[] arr,int num) {
//		if(Arrays.binarySearch(arr, num)>=0) {
//			System.out.println("���������� " + num + " ���������λ���ǵ�"+ (Arrays.binarySearch(arr, num)+1) +"λ");
//		} else {
//			System.out.println("��������û��Ҫ���ҵ���");
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
