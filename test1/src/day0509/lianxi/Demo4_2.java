package day0509.lianxi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��֪���飨12��23��26��45��58��60��������ģ�����һ����x���������뵽�����У���֤������Ȼ�������
 * @author Administrator
 */
public class Demo4_2 {
	public static void main(String[] args) {
		int[] arr = {12, 23, 26, 45, 58, 60};
		System.out.println("������һ��������");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		s.close();
		
		arr = Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1] = num;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
