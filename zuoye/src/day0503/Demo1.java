package day0503;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		//��СΪ100���������飬���������Ϊ�丳ֵ��ȡֵ��Χ[1,100]
		//ͳ�ƴ���������������
		//Ѱ���Ƿ���ĳ�����������[1,100],��50�����У��������λ�ã�û�������û��
		int[] arr = new int[100];
		
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		
		//Ϊ���鸳ֵ
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		//ͳ�ƴ���������������
		int[] num = new int[arr.length];
		int count = 0;
		for(int i=0 ;i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]==arr[j]) {
					count++;
				}
			}
			num[i] = count;
			count = 0;
		}
		int max = num[0];
		int index = 0;
		for(int i=0; i<num.length; i++) {
			if(num[i]>max) {
				max = num[i];
				index = i;
			}
		}
		System.out.println("���ִ���������Ϊ��"+arr[index]);
		
		//��ѯλ��
		System.out.print("������1-100֮�������һ������ִ�в�ѯ��");
		int m = s.nextInt();
		s.close();
		boolean onOff = true;
		for(int i=0; i<arr.length; i++) {
			if(m==arr[i]) {
				System.out.println("�����ҵ������ڵ� " + (i+1) + "λ");
				onOff = false;
			}
		}
		if(onOff) {
			System.out.println("������û��Ҫ��ѯ����");
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
