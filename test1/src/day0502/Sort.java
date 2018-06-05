package day0502;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		//√∞≈›≈≈–Ú
		int[] arr1 = {3,5,2,6,7,1,4,9,8,0};
		for(int i=1; i<arr1.length; i++) {
			for(int j=0; j<arr1.length-i; j++) {
				if(arr1[j]>arr1[j+1]) {
					int t = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = t;
				}
			}
		}
		System.out.println(Arrays.toString(arr1));
		
		//—°‘Ò≈≈–Ú
		int[] arr2 = {3,5,2,6,7,1,4,9,8,0};
		for(int i=0; i<arr2.length-1; i++) {
			for(int j=i; j<arr2.length; j++) {
				if(arr2[i]>arr2[j]) {
					int t = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = t;
				}
			}
		}
		System.out.println(Arrays.toString(arr2));
	}
}
